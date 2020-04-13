package com.cba.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.functions.*;
import org.apache.spark.sql.*;

public class cbaSparkTest 
{
    public static void main( String[] args )
    {
	String configFile=args[0];
	 String sparkProperties="hive.metastore.uris=thrift://datanode1.custom-built-apps.com:9083;";
                sparkProperties += "spark.driver.maxResultSize=0;spark.sql.session.timeZone=Canada/Eastern;";
                sparkProperties += "hive.exec.dynamic.partition=true;hive.exec.dynamic.partition.mode=nonstrict;";

		cbaSpark cbaspark=null;
	try
	{
		cbaspark= new cbaSpark("cbaSparkTest",configFile,sparkProperties);
		cbaspark.printStart();
		cbaspark.printSettings();

		String source_db=cbaspark.getVariableValue("source_db");
		//String stage_db=cbaspark.variables.get("stage_db");

		String strSQL=String.format("select * from %s.customers_src order by id",source_db);
		Dataset<Row>dfTest = cbaspark.execHiveQuery(strSQL);
		cbaspark.createView(dfTest,"testview");
		System.out.println( dfTest.count() );
		dfTest.show(false);
		
		
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		cbaspark.printEnd();
                cbaspark.stop();
	}
    }
}

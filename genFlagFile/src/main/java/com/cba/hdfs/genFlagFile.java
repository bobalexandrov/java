//File      : genFlagFile.java
//Author    : Boris Alexandrov <boris.alexandrov@custom-built-apps.com>
//Date      : Sun Apr 15 12:16:47 EDT 2020
//Project   : genFlagFile implementation 
//Version   : v1.0
//Revision  :initial version
////////////////////////////////////////////
package com.cba.hdfs;

import java.io.IOException;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class genFlagFile 
{
    public static void main( String[] args )
    {

        Configuration conf = new Configuration();
        try
        {
	    Date date = Calendar.getInstance().getTime();  
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            String strDate = dateFormat.format(date);  
            FileSystem fs = FileSystem.get(conf);
	    for(String fileName : args) 
	    {
		    Path hdfsFile = new Path(fileName);
		    FSDataOutputStream out = fs.create(hdfsFile);
		    out.write(strDate.getBytes("UTF-8"));
		    out.close();
	    }
        }
	catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}


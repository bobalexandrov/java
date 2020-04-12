//File      : emailMessage.java
//Author    : Boris Alexandrov <boris.alexandrov@custom-built-apps.com>
//Date      : Sun Apr 12 12:16:47 EDT 2020
//Project   : emailMessage implementation 
//Version   : v1.0
//Revision  :initial version
////////////////////////////////////////////
package com.cba.hdfs;

import java.io.IOException;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class emailMessage 
{
    public static void main( String[] args )
    {

        String fileName=args[0];
        //no need to set configuration,just read it from conf files

        Configuration conf = new Configuration();
        try
        {

            FileSystem fs = FileSystem.get(conf);
            Path hdfsFile = new Path(fileName);
            FSDataOutputStream out = fs.create(hdfsFile);
	    out.write(args[1].getBytes("UTF-8"));
	    out.close();
        }
	catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}


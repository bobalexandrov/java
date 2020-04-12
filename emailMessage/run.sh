#!/bin/sh
VER=1.0-SNAPSHOT
PROJECT=emailMessage
JAR=target/${PROJECT}-${VER}.jar
param1="/user/dataexplorer1/somfile.txt"
param2="Please be advised that the workflow failed
	Regards,
        Oozie system"
yarn jar target/${PROJECT}-${VER}.jar ${param1} "${param2}"

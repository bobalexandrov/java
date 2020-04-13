#!/bin/sh
VER=1.0-SNAPSHOT
PROJECT=cbaSparkTest
JAR=target/${PROJECT}-${VER}.jar
param1="hdfs://nameservice1/user/dataexplorer1/oozie/spark/settings.ini"
param2="DEBUG"
nohup spark-submit --jars cbaSpark.jar --driver-memory 4G  --conf spark.dynamicAllocation.maxExecutors=5 --num-executors 5 --executor-cores 6 --executor-memory 4G --queue root.users.dataexplorer1 ${JAR} ${param1}  ${param2} 1>${PROJECT}_result.txt 2>${PROJECT}_run.log &


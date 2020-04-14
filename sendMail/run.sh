#!/bin/sh
VER=1.0-SNAPSHOT
PROJECT=sendMail
JAR=target/${PROJECT}-${VER}.jar
export HADOOP_CLASSPATH=${HOME}/projects/java/sendMail/lib/*
param1="192.168.10.123"
param2="the message and so on"
#yarn jar target/${PROJECT}-${VER}.jar --jars javax.mail-1.6.2.jar,activation-1.1.1.jar ${param1} ${param2}
yarn jar target/${PROJECT}-${VER}.jar ${param1} ${param2}

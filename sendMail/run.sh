#!/bin/sh
VER=1.0-SNAPSHOT
PROJECT=sendMail
JAR=target/${PROJECT}-${VER}.jar
export HADOOP_CLASSPATH=${HOME}/projects/java/sendMail/lib/*
param1="
Please be advised that the java email client
is working using Yet Another
Resource 
Manager.

Greetings,
Your YARN mailer

"
param2="The message from the Yarn,Not to be confused with Barn"

yarn jar target/${PROJECT}-${VER}.jar "${param1}" "${param2}"

#!/bin/sh
VER=1.0-SNAPSHOT
PROJECT=genFlagFile
JAR=target/${PROJECT}-${VER}.jar
param1="/user/dataexplorer1/oozie/orapipeline/flags/hivetable/2020-04-15/_END"
param2="/user/dataexplorer1/oozie/orapipeline/flags/hivetable/2020-04-15/_SUCCESS"
yarn jar target/${PROJECT}-${VER}.jar ${param1} ${param2}

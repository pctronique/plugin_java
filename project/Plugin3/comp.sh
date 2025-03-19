#!/bin/bash

#/////////////////////////////////////
#//    DEVELOPPEUR : PCTRONIQUE     //
#/////////////////////////////////////

rm -rf dist
#mkdir dist
rm -rf build
mkdir build
rm -rf tmp
mkdir tmp

if [ -z ${VALUE_JAVA_VERSION} ]
then
    VALUE_JAVA_VERSION=21
fi

if [ -z ${JAVA_FOLDER_PROJECT} ]
then
    JAVA_FOLDER_PROJECT=${0%/*}/..
fi

JAVA_FOLDER_PROJECT=${JAVA_FOLDER_PROJECT}/Plugin3

if [ -z ${MANI_FOLDER} ]
then
    MANI_FOLDER=${JAVA_FOLDER_PROJECT}/tmp
fi

cd ${JAVA_FOLDER_PROJECT}

mkdir -p ${MANI_FOLDER}

LIST_LIB_JAR=$(find -L lib -name "*.jar")
LIST_LIB_JAR=$(echo ${LIST_LIB_JAR})
LIST_ALL_JAVA=$(find -L src -name "*.java")
LIST_ALL_JAVA=$(echo ${LIST_ALL_JAVA})

IFS=' ' read -r -a arrayJava <<< "${LIST_ALL_JAVA}"

echo "Manifest-Version: 1.0" > ${MANI_FOLDER}/MANIFEST.MF
echo "Created-By: ${VALUE_JAVA_VERSION} (Ubuntu)" >> ${MANI_FOLDER}/MANIFEST.MF
echo "Class-Path: ${LIST_LIB_JAR}" >> ${MANI_FOLDER}/MANIFEST.MF

cd build
cmake ../
make
cd ..

rm -rf build
rm -rf tmp

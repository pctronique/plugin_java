#********** start CmakeLists.txt **********

cmake_minimum_required(VERSION 3.5)

project(PROJECT_JAVA)

#set(CMAKE_BUILD_TYPE Debug)
set(CMAKE_BUILD_TYPE Release)

find_package(Java REQUIRED)
include(UseJava)

file(GLOB_RECURSE java_SRCS ${CMAKE_CURRENT_SOURCE_DIR}/src/*.java)
file(GLOB lib_SRCS ${CMAKE_CURRENT_SOURCE_DIR}/lib/*.jar)
file(GLOB libplugin_SRCS ${CMAKE_CURRENT_SOURCE_DIR}/../dist/bin/*.jar)

set(JAR_NAME plugin2)
set(JAVA_SOURCE_FILES ${java_SRCS})
add_jar(${JAR_NAME} SOURCES ${JAVA_SOURCE_FILES} INCLUDE_JARS ${lib_SRCS} ${libplugin_SRCS} MANIFEST "${CMAKE_CURRENT_SOURCE_DIR}/tmp/MANIFEST.MF" OUTPUT_DIR "${CMAKE_CURRENT_SOURCE_DIR}/../dist/bin/plugins")

#********** end CmakeLists.txt **********
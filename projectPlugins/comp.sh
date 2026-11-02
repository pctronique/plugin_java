#!/bin/bash

#/////////////////////////////////////
#//    DEVELOPPEUR : PCTRONIQUE     //
#/////////////////////////////////////

rm -rf dist
mkdir dist

cd ${0%/*}/pctrplugin
chmod 777 comp.sh
./comp.sh

cd ../testplugin
chmod 777 comp.sh
./comp.sh

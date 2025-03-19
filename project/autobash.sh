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

cd ../Plugin1
chmod 777 comp.sh
./comp.sh

cd ../Plugin2
chmod 777 comp.sh
./comp.sh

cd ../Plugin3
chmod 777 comp.sh
./comp.sh

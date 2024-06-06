#!/bin/bash

cd ${0%/*}/main_plugin
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

#!/usr/bin/env bash

## LOCAL: vars
echo '---------------------------------------------------------------'
echo 'Create the BACKUP files of "SRC" folder and "build.gradle" file'
echo '---------------------------------------------------------------'
mv src BACKUP_src
mv build.gradle BACKUP_build.gradle

mkdir src/

echo '---------------------------------------------------------------'
echo 'Create the "TEMP" configuration'
echo '---------------------------------------------------------------'
mkdir -p temp/
cd temp
git clone https://github.com/manoelcyreno/lfrgs-selenium-samples.git

echo '---------------------------------------------------------------'
echo 'Create the "SAMPLES" codes'
echo '---------------------------------------------------------------'
cp -r lfrgs-selenium-samples/src/* ../src/
cp -rf lfrgs-selenium-samples/build.gradle ../build.gradle

echo '---------------------------------------------------------------'
echo 'Remove the "TEMP" configuration'
echo '---------------------------------------------------------------'
cd ..
rm -rf temp/
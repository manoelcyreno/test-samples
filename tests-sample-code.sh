#!/usr/bin/env bash

## LOCAL: vars
echo '------------------------------------------------------------------'
echo 'Create the BACKUP files of "SRC" folder and "settings.gradle" file'
echo '------------------------------------------------------------------'
mv src BACKUP_src
mv settings.gradle BACKUP_settings.gradle

mkdir modules/

echo '---------------------------------------------------------------'
echo 'Create the "TEMP" configuration'
echo '---------------------------------------------------------------'
mkdir -p temp/
cd temp
git clone https://github.com/manoelcyreno/lfrgs-selenium-samples.git

echo '---------------------------------------------------------------'
echo 'Create the "SAMPLES" codes'
echo '---------------------------------------------------------------'
cp -r lfrgs-selenium-samples/modules/* ../modules/
cp -rf lfrgs-selenium-samples/settings.gradle ../settings.gradle

echo '---------------------------------------------------------------'
echo 'Remove the "TEMP" configuration'
echo '---------------------------------------------------------------'
cd ..
rm -rf temp/
#!/bin/bash

echo "Current version of"
echo "Java"
java --version
echo "Gradle"
gradle --version
echo "Python"
python3 --version
echo "Python modules using with Python"
pip3 list
echo "Updating Server App "
rm server_app.py
wget https://raw.githubusercontent.com/pastorcmentarny/DomJavaKB/master/python/serverstatus/server_app.py
python3 server_app.py &
echo "Update complete"

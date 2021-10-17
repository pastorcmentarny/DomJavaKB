echo "Updating Server App "
rm server_app.py
wget https://raw.githubusercontent.com/pastorcmentarny/DomJavaKB/master/python/serverstatus/server_app.py
python3 server_app.py
echo "Update complete"
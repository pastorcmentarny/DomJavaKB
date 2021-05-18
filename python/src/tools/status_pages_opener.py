"""
This is a script to open all pages I used on my info display
"""
import webbrowser

pages = [
    "http://aqicn.org/city/wroclaw",
    "http://aqicn.org/city/tianjin",
    "http://aqicn.org/city/london",
    "http://www.londonair.org.uk/LondonAir/Forecast/",
    "https://tfl.gov.uk/tube-dlr-overground/status/",
    "http://trains.im/ppm/",
    "https://www.motorwaycameras.co.uk/england/m25/anticlockwise/traffic-camera/1330",
    "https://www.motorwaycameras.co.uk/england/m25/clockwise/traffic-camera/511",
    "https://connect.garmin.com/modern/dashboard/39832936",
    "https://connect.garmin.com/modern/dashboard/39885708",
    "https://trello.com/b/bfiNOaju/todo",
    "https://docs.google.com/document/d/1-Oaqc9Qs0qFuQlkhB0mkAhowoTMNqfhV7rzKAFA1Wtw/edit",
    "https://docs.google.com/document/d/1QDc7nqmCv6t8bFXQ7HsAyJQOIrSc7a23X0MaREToQXA/edit",
]
for page in pages:
    webbrowser.open(page)

import platform


def get_path():
    if platform.node() == "DOM-DESKTOP":
        return r'B:\GitHub\DomKB\transportManager\TransportManagerDB\stations.txt'
    else:
        return r'home/pi/stations.txt'
import platform

pc = "DOM-DESKTOP"
server_port = 18003


def get_path():
    if platform.node() == pc:
        return r'B:\GitHub\DomKB\transportManager\TransportManagerDB\stations.txt'
    else:
        return r'/home/pi/stations.txt'

#!/usr/bin/env python3

import socket
import math
from time import sleep

HOST = '127.0.0.1'  # Standard loopback interface address (localhost)
PORT = 12000      # Port to listen on (non-privileged ports are > 1023)


with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((HOST, PORT))
    s.listen()
    conn, addr = s.accept()
    with conn:
        print('Connected by', addr)
        r = 0
        g = 0
        b = 0
        i = 0
        while True:
            i = i + math.pi/15
            r = int(max(min((math.sin(i) * 255), 255), 0))
            b = int(max(min((math.sin(i+math.pi/2) * 255), 255), 0))
            g = int(max(min((math.sin(i + math.pi) * 255), 255), 0))
            framecolor = "#%02x%02x%02x;" % (r, g, b)
            frame = framecolor * 1024
            conn.send(('{' + frame + '}\n').encode())
            sleep(1.0/15.0)

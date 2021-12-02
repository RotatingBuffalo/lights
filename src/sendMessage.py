#!/usr/bin/env python3

import socket
import math
from time import sleep

HOST = '127.0.0.1'  # Standard loopback interface address (localhost)
PORT = 12000      # Port to listen on (non-privileged ports are > 1023)


def channelsFade(i, r, g, b):
    i = i + math.pi/15
    r = int(max(min(((math.sin(i)) * 255), 255), 0))
    b = int(max(min(((math.sin(i+(2*math.pi)/3)) * 255), 255), 0))
    g = int(max(min(((math.sin(i + (4*math.pi)/3)) * 255), 255), 0))
    framecolor = "#%02x%02x%02x;" % (r, g, b)
    frame = framecolor * 1024
    return frame, r, g, b


def betterFade(r, g, b):
    if(r+g+b == 0):
        r = 255
    if(r > 0 and b == 0):
        r = r-17
        g = g+17
    if(g > 0 and r == 0):
        g = g-17
        b = b+17
    if(b > 0 and g == 0):
        b = b-17
        r = r+17
    framecolor = "#%02x%02x%02x;" % (r, g, b)
    return (framecolor, r, g, b)


def wave(r, g, b):
    frame = ""
    for i in range(32):
        rowColor, r, g, b = betterFade(r, g, b)
        frame = frame + rowColor*32
    return (frame, r, g, b)


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
            frame, r, g, b = betterFade(r, g, b)
            i = i + 1
            i = i % 240
            frame = frame*1024
            conn.send(('{' + frame + '}\n').encode())
            sleep(1.0/8.0)

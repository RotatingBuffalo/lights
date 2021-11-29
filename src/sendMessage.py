#!/usr/bin/env python3

import socket
from typing import ByteString

HOST = '127.0.0.1'  # Standard loopback interface address (localhost)
PORT = 12000      # Port to listen on (non-privileged ports are > 1023)

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((HOST, PORT))
    s.listen()
    conn, addr = s.accept()
    with conn:
        print('Connected by', addr)
        while True:
            conn.sendall(b"We are gaming")

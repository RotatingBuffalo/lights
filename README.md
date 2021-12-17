# RotatingBuffalo/lights
## This repository contains code for controlling a 32x32 LED Matrix, as well as a simulator for said matrix written in Java.
The code for controlling the board/simulator is written in C#, and the simulator was written in Java. All of this is subject to change, especially as I doubt it will be easy to get C# code running on a Raspberry Pi.

## The Java Simulator
Frames are structured as follows:

`{#FFFFFF;#FFFFFE;#FFFFFD;#FFFFFC; ... (this should be 1024 hex codes, separated by commas) ... #FF00FF;#FF00FF;#FFFFFF;#FFFFFF;}\n`

The frame is made up of 1024 comma delimited hex codes, enclosed within curly braces and followed by a line terminator. Send these over socket 12000 after starting the simulator and you should see your very own frame show up. An example python script will be included later to demonstrate this.

Currently this has not run on physical hardware, and it will continue to not do so for as long as I don't feel like doing soldering work.

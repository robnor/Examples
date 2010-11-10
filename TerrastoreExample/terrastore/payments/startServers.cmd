@echo off
cd master
start cmd /K startmaster.cmd

cd ..
cd server1
start cmd /K startserver1.cmd

cd ..
cd server2
start cmd /K startserver2.cmd

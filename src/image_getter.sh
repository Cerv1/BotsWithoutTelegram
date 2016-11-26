#!/bin/bash

echo "Iniciado script"

cd ~/tg/bin/

(
echo "contact_search ImageBot";sleep 2;
echo "msg ImageBot /get $1"; sleep 4;
echo "load_file 2"; sleep 5;

) | ./telegram-cli -N

eog -f ~/.telegram-cli/downloads/*

rm -r ~/.telegram-cli/downloads/*

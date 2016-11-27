#!/bin/bash

echo "Iniciado script"

cd ~/tg/bin/

(
echo "contact_search ImageBot";sleep 5;
echo "msg ImageBot /get $1";sleep 10;

) | ./telegram-cli -N -s ~/BotsWithoutTelegram/src/test.lua

eog -f ~/.telegram-cli/downloads/*

rm -r ~/.telegram-cli/downloads/*

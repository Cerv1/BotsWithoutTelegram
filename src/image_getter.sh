#!/bin/bash

echo "Iniciado script"

cd ~/tg/bin/

(
echo "contact_search ImageBot";sleep 3;
echo "msg ImageBot /get $1 $2";sleep 6;

) | ./telegram-cli -N -s ~/BotsWithoutTelegram/src/test.lua

cp ~/.telegram-cli/downloads/* ~/.telegram-cli/downloads/image

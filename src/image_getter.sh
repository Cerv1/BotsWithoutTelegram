#!/bin/bash

echo "Iniciado script"

cd ~/tg/bin/

(
echo "contact_search ImageBot";sleep 6;
echo "msg ImageBot /get $1";sleep 8;

) | ./telegram-cli -s ~/BotsWithoutTelegram/src/test.lua

cp ~/.telegram-cli/downloads/* ~/.telegram-cli/downloads/image

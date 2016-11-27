!/bin/bash

echo "Iniciado script"

cd ~/tg/bin/

(
echo "contact_search ImageBot";sleep 4;
echo "msg ImageBot /get $1"; sleep 4;

) | ./telegram-cli -N -s ~/BotsWithoutTelegram/src/test.lua

eog -f ~/.telegram-cli/downloads/*

rm -r ~/.telegram-cli/downloads

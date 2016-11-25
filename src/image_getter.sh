#!/bin/bash

echo "Iniciado script"

cd ~/tg/bin/

(
echo "contact_search ImageBot";sleep 2;
echo "msg ImageBot /get cupcake"; sleep 4;
echo "load_file 2"; sleep 5;

) | ./telegram-cli -N

eog -f ~/.telegram-cli/downloads/*
sleep 2;
rm -r ~/.telegram-cli/downloads/*

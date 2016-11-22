cd /home/cervi/tg/bin/

(
echo "contact_search ImageBot";sleep 1;
echo "msg ImageBot /get cat"; sleep 6;
echo "load_file 2"; sleep 10;
) | ./telegram-cli -N

eog -f ~/.telegram-cli/downloads/*
sleep 8;
rm -r ~/.telegram-cli/downloads/*

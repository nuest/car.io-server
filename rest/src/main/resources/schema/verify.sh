#!/bin/sh
for f in *.json; do 
	echo $f
	cat $f | python -m json.tool > /dev/null
done
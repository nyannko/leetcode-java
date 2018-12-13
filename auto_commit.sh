#!/bin/bash

git add .

dt=`date '+%d/%m/%Y,%H:%M'`
echo "$dt"

git commit -m $dt

git push


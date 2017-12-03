#!/bin/bash


service ssh start


$HADOOP_COMMON_HOME/sbin/start-yarn.sh



if [[ $1 == "-bash" ]]; then
  /bin/bash
fi

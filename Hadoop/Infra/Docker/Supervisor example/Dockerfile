
From  ubuntu:15.10

MAINTAINER JP

USER root

RUN   apt-get update && \
      apt-get install -y openjdk-8-jdk  && \
      apt-get install openjdk-8-jre

ENV   JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64

RUN   apt-get install -y  openssh-server && \
      apt-get install -y openssh-client  


RUN   apt-get install -y curl && \
      apt-get install -y net-tools


ADD     hadoop-2.7.2.tar.gz  /usr/local


ENV 	HADOOP_PREFIX /usr/local/hadoop-2.7.2	
ENV	HADOOP_COMMON_HOME /usr/local/hadoop-2.7.2 
ENV	HADOOP_HDFS_HOME /usr/local/hadoop-2.7.2 
ENV	HADOOP_MAPRED_HOME /usr/local/hadoop-2.7.2 
ENV	HADOOP_YARN_HOME /usr/local/hadoop-2.7.2 
ENV	HADOOP_CONF_DIR /usr/local/hadoop-2.7.2/etc/hadoop 
ENV	YARN_CONF_DIR $HADOOP_PREFIX/etc/hadoop  



RUN  mkdir $HADOOP_COMMON_HOME/logs

ADD  hadoop-env.sh  $YARN_CONF_DIR/hadoop-env.sh

RUN   chown  -R  root:root /usr/local/hadoop-2.7.2
RUN   chmod  777   /usr/local/hadoop-2.7.2


RUN service ssh start 
RUN $HADOOP_YARN_HOME/sbin/start-yarn.sh


#RUN ssh-keygen -q -N "" -t dsa -f /etc/ssh/ssh_host_dsa_key
#RUN ssh-keygen -q -N "" -t rsa -f /etc/ssh/ssh_host_rsa_key
RUN ssh-keygen -q -N "" -t rsa -f /root/.ssh/id_rsa
RUN cp /root/.ssh/id_rsa.pub /root/.ssh/authorized_keys


ADD  start.sh  /etc/start.sh
RUN chown root:root /etc/start.sh
RUN chmod 700  /etc/start.sh

#CMD ["/bin/bash","service ssh start"]

#CMD ["/etc/start.sh","-a"]


RUN  apt-get install -y supervisor

COPY supervisord.conf /etc/supervisor/conf.d/supervisord.conf

CMD ["/usr/bin/supervisord"]

EXPOSE 8030 8031 8032 8033 8040 8042 8088 22






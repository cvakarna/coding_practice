From  ubuntu:15.10

MAINTAINER JP

USER root

RUN   apt-get update && \
      apt-get install -y \
      openjdk-8-jdk   \
      openjdk-8-jre   \
      openssh-server  \
      openssh-client  \
      curl            \
      net-tools       \
      supervisor

ENV   JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64


ADD     hadoop-2.7.2.tar.gz  /usr/local


ENV \
	HADOOP_PREFIX /usr/local/hadoop-2.7.2	\
	HADOOP_COMMON_HOME /usr/local/hadoop-2.7.2 \
	HADOOP_HDFS_HOME /usr/local/hadoop-2.7.2 \
	HADOOP_MAPRED_HOME /usr/local/hadoop-2.7.2 \
	HADOOP_YARN_HOME /usr/local/hadoop-2.7.2 \ 
	HADOOP_CONF_DIR /usr/local/hadoop-2.7.2/etc/hadoop \
	YARN_CONF_DIR $HADOOP_PREFIX/etc/hadoop  \

RUN  mkdir $HADOOP_COMMON_HOME/logs

ADD  hadoop-env.sh  $YARN_CONF_DIR/hadoop-env.sh
RUN   chown  -R  root:root /usr/local/hadoop-2.7.2
RUN   chmod  777   /usr/local/hadoop-2.7.2




#RUN ssh-keygen -q -N "" -t dsa -f /etc/ssh/ssh_host_dsa_key
#RUN ssh-keygen -q -N "" -t rsa -f /etc/ssh/ssh_host_rsa_key

RUN ssh-keygen -q -N "" -t rsa -f /root/.ssh/id_rsa
RUN cp /root/.ssh/id_rsa.pub /root/.ssh/authorized_keys



COPY supervisord.conf /etc/supervisor/conf.d/supervisord.conf

CMD ["/usr/bin/supervisord"]

EXPOSE 8030 8031 8032 8033 8040 8042 8088 22






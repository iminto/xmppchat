FROM openjdk:8-jdk-alpine
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
COPY target/dependency/ target/dependency/
COPY target/classes/ target/classes/
COPY run.sh run.sh
RUN chmod a+x run.sh
CMD ["/run.sh"]

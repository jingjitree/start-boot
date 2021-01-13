#基于openjdk8的镜像
FROM openjdk:8-jdk-alpine

#将本地文件夹挂在当前容器
VOLUME /tmp

#赋值文件到容器中
ADD *.jar app.jar

#配置容器启动后执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

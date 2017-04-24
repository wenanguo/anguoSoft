FROM tomcat:8.0-jre8

WORKDIR /usr/local/tomcat/webapps/
RUN echo "hi  wwww"
RUN ls /usr/local/tomcat/webapps

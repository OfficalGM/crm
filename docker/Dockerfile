FROM openjdk:12-alpine

RUN apk add --no-cache bash ttf-dejavu coreutils

COPY ./*.jar ./crm.jar

EXPOSE 8080

CMD ["java","-Dname=crm[crm-server]","-Dfile.encoding=UTF8","-Dlogging.config=logback-spring.xml", "-jar", "crm.jar"]
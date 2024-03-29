# DEMO SPRING BOOT WITH WEBSPHERE OR WILDFLY

A demo application of spring boot with websphere and mq-ibm or wildfly and active-mq.

## WEBSPHERE

### Commands to build

```
docker build -t openliberty-app -f DockerfileLiberty .
```

### Commands to run

```
docker-compose up --build oracle-db mq-ibm
docker-compose up --build websphere
```

## WILDFLY

### Commands to build and run

```
docker-compose up oracle-db activemq
docker-compose up wildfly
```

## CONSOLES

### IBM MQ

```
https://localhost:9443/ibmmq/console
```

## URLs

### WS

```
http://localhost:9080/ws/v1/banks
```

### MQ

```
http://localhost:9080/mq/v1/send
http://localhost:9080/mq/v1/recv
```

### REFERENCES

https://openliberty.io/guides/spring-boot.html#building-and-running-the-application-in-a-docker-container

https://ibm-cloud-architecture.github.io/cloudpak-for-applications/spring/https://ibm-cloud-architecture.github.io/cloudpak-for-applications/spring/

https://github.com/ibm-cloud-architecture/cloudpak-for-applications/tree/spring

https://www.ibm.com/support/knowledgecenter/en/SSGMCP_5.4.0/configuring/java/config_jvmserver_liberty.html

https://blogs.oracle.com/imc/jdeveloper-12c-ora-01882:-timezone-region-not-found

https://www.baeldung.com/spring-boot-thin-jar

https://www.ibm.com/support/knowledgecenter/SSGMCP_5.4.0/configuring/java/serverxmljvm.html?view=embed

https://www.ibm.com/support/knowledgecenter/en/SSGMCP_5.4.0/configuring/java/config_jvmserver_liberty.html

https://openliberty.io/docs/20.0.0.12/reference/config/dataSource.html

https://developer.ibm.com/components/ibm-mq/tutorials/mq-jms-application-development-with-spring-boot/

https://github.com/nuviosoftware/custom-ibm-mq/blob/master/Dockerfile

https://www.youtube.com/watch?v=IxR5G7DEyfU

https://stackoverflow.com/questions/63999792/cannot-debug-websphere-application-server-inside-of-a-docker-container-using-int

https://www.ibm.com/support/knowledgecenter/SSEQTP_liberty/com.ibm.websphere.wlp.doc/ae/t_creating_remote_server_docker.html

https://openliberty.io/docs/21.0.0.2/log-trace-configuration.html

https://www.ibm.com/support/knowledgecenter/SSD28V_liberty/com.ibm.websphere.wlp.core.doc/ae/twlp_ui_setup.html#twlp_ui_setup__uiinstall

https://www.ibm.com/support/knowledgecenter/SSEQTP_liberty/com.ibm.websphere.wlp.doc/ae/video_transcript_ui_setup.html

https://websphereusergroup.co.uk/wug/presentations/40/liberty-docker-wug.pdf

https://www.ibm.com/support/knowledgecenter/SSEQTP_liberty/com.ibm.websphere.wlp.doc/ae/twlp_ui_login.html

https://hub.docker.com/_/websphere-liberty

https://medium.com/assertqualityassurance/como-construir-e-testar-uma-api-em-java-utilizando-o-postman-baae69d8b8aa

https://www.baeldung.com/javax-validation
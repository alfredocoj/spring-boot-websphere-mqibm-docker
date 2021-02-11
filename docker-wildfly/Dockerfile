FROM jboss/wildfly:13.0.0.Final

# adds a management user with the following credentials: admin:admin
# if you want to add an application user, use the '-a' option
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

##ADD jdbc /opt/jdbc
##ADD ojdbc7.jar /opt/jboss/wildfly/
ADD ojdbc/ojdbc7.jar /opt/jdbc
ADD config /opt/config
ADD amq /opt/amq

USER root
RUN chmod +x /opt/config/execute.sh
USER jboss

RUN /opt/config/execute.sh commands.cli
RUN mkdir -p /opt/jboss/wildfly/modules/org/apache/activemq/main
RUN unzip /opt/amq/activemq-rar-5.10.0.rar -d /opt/jboss/wildfly/modules/org/apache/activemq/main

RUN rm -f /opt/jboss/wildfly/modules/org/apache/activemq/main/broker-config.xml
RUN rm -f /opt/jboss/wildfly/modules/org/apache/activemq/main/log4j*
RUN rm -f /opt/jboss/wildfly/modules/org/apache/activemq/main/slf4j*
RUN rm -f /opt/jboss/wildfly/modules/org/apache/activemq/main/geronimo*

# cleanup
RUN rm -rf $JBOSS_HOME/standalone/configuration/standalone_xml_history
RUN /opt/config/execute.sh add-activemq-rar.cli

# cleanup
RUN rm -rf $JBOSS_HOME/standalone/configuration/standalone_xml_history

COPY target/demo-0.0.1-SNAPSHOT1.war /opt/jboss/wildfly/standalone/deployments/demo-0.0.1-SNAPSHOT.war
#ENV JAVA_OPTS="-Xms1G -Xmx1G -Djava.util.logging.config.file=logging.properties -Djava.security.auth.login.config=/opt/activemq/conf/login.config -Dcom.sun.management.jmx remote -Djava.awt.headless=true -Djava.io.tmpdir=/opt/activemq/tmp -Dactivemq.classpath=/opt/activemq/conf -Dactivemq.home=/opt/activemq -Dactivemq.base=/opt/activemq -Dactivemq.conf=/opt/activemq/conf -Dactivemq.data=/opt/activemq/data --add-modules java.se.ee"
# automatically launch the standalone configuration
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0", "-c", "standalone-full.xml"]

#https://github.com/dnvriend/jboss-wildfly-test
#https://thepracticaldeveloper.com/how-to-deploy-a-spring-boot-war-in-wildfly-jboss/
#https://gist.github.com/clairtonluz/836567eb6047b302076f#file-dt-sh
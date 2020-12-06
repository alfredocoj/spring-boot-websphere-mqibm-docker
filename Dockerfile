#start from eap72-openshift
FROM registry.access.redhat.com/jboss-eap-7/eap72-openshift

# Copy war to deployments folder
COPY target/*.war $JBOSS_HOME/standalone/deployments/

# User root to modify war owners
USER root

# Modify owners war
RUN chown jboss:jboss $JBOSS_HOME/standalone/deployments/wingsure_crop_insurance-0.0.1.war

# Important, use jboss user to run image
USER jboss
FROM adoptopenjdk:11.0.5_10-jre-hotspot-bionic
ADD build/libs/digital-fuel-scheduler-service-0.0.1-SNAPSHOT.jar digital-fuel-scheduler-service-0.0.1-SNAPSHOT.jar
RUN echo Asia/Muscat > /etc/timezone
ENTRYPOINT exec java $JAVA_OPTS $TIME_ZONE -jar digital-fuel-scheduler-service-0.0.1-SNAPSHOT.jar --spring.config.location=/home/application.yml
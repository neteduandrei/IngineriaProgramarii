FROM maven
MAINTAINER Valentin Rosca <rosca.valentin2012@gmail.com>
ARG JUSER=b2formeditor
RUN useradd -ms /bin/bash ${JUSER}
USER ${JUSER}
# Cache mvn sources
COPY ./pom.xml /b2formeditor/pom.xml
RUN cd /b2formeditor && mvn dependency:go-offline
# Build the project
COPY ./ /b2formeditor
USER root
RUN chown --recursive ${JUSER}:${JUSER} /b2formeditor
USER ${JUSER}
RUN cd /b2formeditor && mvn initialize \
	&& mvn compile \
	&& mvn -Dmaven.test.skip=true package
CMD java -jar /b2formeditor/target/b2formeditor-0.0.1-SNAPSHOT.jar 

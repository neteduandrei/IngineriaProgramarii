FROM maven
MAINTAINER Valentin Rosca <rosca.valentin2012@gmail.com>
ARG JUSER=b2formeditor
RUN useradd -ms /bin/bash ${JUSER}
USER ${JUSER}
RUN mkdir -p ~/b2formeditor
# Cache mvn sources
COPY ./pom.xml /home/b2formeditor/b2formeditor/pom.xml
RUN cd ~/b2formeditor && mvn -U clean dependency:resolve dependency:go-offline org.apache.maven.plugins:maven-dependency-plugin:2.6:resolve
# Also cache mvn compile time and package time dependencies
RUN cd ~/b2formeditor && mvn -Dmaven.test.skip=true compile prepare-package && (mvn org.springframework.boot:spring-boot-maven-plugin:1.5.3.RELEASE:repackage || mvn maven-jar-plugin:2.4:jar || exit 0)
# Build the project
COPY ./ /home/b2formeditor/b2formeditor
USER root
USER ${JUSER}
RUN cd ~/b2formeditor && mvn initialize \
	&& mvn compile \
	&& mvn -Dmaven.test.skip=true package
EXPOSE 8443
EXPOSE 8090
WORKDIR ~/b2formeditor
EXPOSE 8443
EXPOSE 8090
# TODO: create a separate spring profile for changing variables
CMD java -jar target/b2formeditor-0.0.1-SNAPSHOT.jar --spring.data.mongodb.host=db

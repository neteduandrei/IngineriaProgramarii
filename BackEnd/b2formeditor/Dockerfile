FROM maven
MAINTAINER Valentin Rosca <rosca.valentin2012@gmail.com>
# Cache mvn sources
COPY ./pom.xml /b2formeditor/pom.xml
RUN cd /b2formeditor && mvn -U clean dependency:resolve dependency:go-offline org.apache.maven.plugins:maven-dependency-plugin:2.6:resolve
# Also cache mvn compile time and package time dependencies
RUN cd /b2formeditor && mvn -Dmaven.test.skip=true compile prepare-package && (mvn org.springframework.boot:spring-boot-maven-plugin:1.5.3.RELEASE:repackage || mvn maven-jar-plugin:2.4:jar || exit 0)
# Prepare ports
EXPOSE 8443
EXPOSE 8090
# Build the project
COPY ./ /b2formeditor
RUN cd /b2formeditor && mvn initialize \
	&& mvn compile \
	&& mvn -Dmaven.test.skip=true package
WORKDIR /b2formeditor
# TODO: create a separate spring profile for changing variables
CMD java -jar target/b2formeditor-0.0.1-SNAPSHOT.jar --server.host=0.0.0.0 --spring.data.mongodb.host=db

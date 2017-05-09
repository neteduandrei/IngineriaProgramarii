#Backend

## Prerequisites
* docker
```
curl -sSL get.docker.com | sudo sh
```

* docker-compose
```
sudo su -c "curl -L https://github.com/docker/compose/releases/download/1.12.0/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose" root
sudo chmod +x /usr/local/bin/docker-compose
```

* maven (install using apt-get or yum)

## Deployment

### Local
 
 * Change working directory to the maven project
```
cd b2formeditor
```

 * Prepare the release
```
mvn initialize
mvn compile
mvn -Dmaven.test.skip=true package
```

 * Deploy the database
```
mkdir database
docker-compose start db
```

 * Run the server
```
java -jar target/b2formeditor-0.0.1-SNAPSHOT.jar
```

### Docker deploy
 * Change working directory to the maven project
```
cd b2formeditor
```

 * Build the docker container with spring
```
docker-compose build
```

 * Start the database and spring boot with docker
```
docker-compose up -d
```

## Testing
Comming soon ...

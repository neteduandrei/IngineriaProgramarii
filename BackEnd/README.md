#Backend

[![Docker Repository on Quay](https://quay.io/repository/fistinflame/b2formeditor/status "Docker Repository on Quay")](https://quay.io/repository/fistinflame/b2formeditor)

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
 * Change the working directory twhere the BackEnd resources are located:
```
cd /path/to/project/BackEnd
``` 

 * Prepare the release - *this step should be done after each change*
```
(cd b2formeditor && mvn initialize && mvn compile && mvn -Dmaven.test.skip=true package && cd ..) || cd ..
```

 * Deploy the database with docker
```
mkdir database
docker-compose start db
```

 * Run the server
```
bash -c "cd b2formeditor && java -jar target/b2formeditor-0.0.1-SNAPSHOT.jar"
```

### Docker deploy
 * Change the working directory twhere the BackEnd resources are located:
```
cd /path/to/project/BackEnd
``` 

 * Build the docker container with spring - *this step should be done after each change*
```
docker-compose build
```

 * Start the database and spring boot with docker
```
docker-compose up -d
```

## Testing
Comming soon ...

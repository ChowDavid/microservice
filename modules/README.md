# build docker from Dockerfile
```
mvn clean package
docker images
docker push davidchow/account:latest
docker push davidchow/card:latest
docker push davidchow/loan:latest
docker push davidchow/configserver:latest
```

run all
```
../docker-compose/docker_compose up -d
```
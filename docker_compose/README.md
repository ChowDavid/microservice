```
docker build account\ -t davidchow/account
docker build loan\ -t davidchow/loan
docker build card\ -t davidchow/card

docker push davidchow/account
docker push davidchow/loan
docker push davidchow/card
```

## docker-compose up
```
docker-compose up
docker-compose scale accounts=3
docker-compose ps
```

## docker-compose create more then one instance ports allocation
```
ports:
  - "8080-8084:8080"
  
```

## docker compose pass service discovery to account 
```
services:
  discovery:
  ...
  accounts:
    environment:
      EUREKA_SERVER: http://discovery:8070/eureka/
 ```
 ### then in account the env variable will be pass in application.yml as 
 ```
  eureka.client.servieUrl.defautZone: ${EUREKA_SERVER:http://localhost:8070/eureka} ```

### clean up docker image
```
docker system prune
docker image prune
``` 
### running Zipkin
- http://localhost:9411

### Running prometeus
- http://localhost:9090

### Config the Grafana
- start the docker
- localhost:3000
- Config datasource as Prometheus
- import dashboard 11378
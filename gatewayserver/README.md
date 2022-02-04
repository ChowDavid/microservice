# Dependence
- It depend on config server
- It depend on Eureka server

# URL to check the gateway
http://localhost:8072/actuator/gateway/routes

# Routing information path
- user call gateway
- gateway lookup eureka and call the actual URL from eureka.
- example
http://localhost:8072/ACCOUNTS/myAccount

# Build
```
cd microservice
mvn clean package -T 6
```

# run
```
cd docker-compose
cd prod
docker-compose up
```

# Check
- http://localhost:8070
- http://localhost:8072/actuator/gateway/routes

# Test
- run API call account from gateway

```
POST http://localhost:8072/ACCOUNTS/myAccount

{
    "customerId":1
}
Response
{
    "customerId": 1,
    "accountNumber": 123456789,
    "accountType": "Savings",
    "branchAddress": "Mel",
    "createDt": "2022-02-04"
}
```

Or directly from account instance

```
docker ps
(base) Chows-MacBook-Pro:prod david$ docker ps
CONTAINER ID   IMAGE                            COMMAND               CREATED         STATUS                   PORTS                    NAMES
6e6a00edfc6a   davidchow/account:latest         "java -jar run.jar"   5 minutes ago   Up 5 minutes             0.0.0.0:8083->8080/tcp   prod_accounts_1
19e73ea83b8e   davidchow/card:latest            "java -jar run.jar"   5 minutes ago   Up 5 minutes             0.0.0.0:9000->9000/tcp   prod_cards_1
e8c18227d2c9   davidchow/loan:latest            "java -jar run.jar"   5 minutes ago   Up 5 minutes             0.0.0.0:8098->8090/tcp   prod_loans_1
aead6c2dc8bd   davidchow/gatewayserver:latest   "java -jar run.jar"   5 minutes ago   Up 5 minutes (healthy)   0.0.0.0:8072->8072/tcp   prod_gatewayserver_1
9367e5bfd605   davidchow/discovery:latest       "java -jar run.jar"   5 minutes ago   Up 5 minutes (healthy)   0.0.0.0:8070->8070/tcp   prod_discovery_1
e03e12ffc7ec   davidchow/configserver:latest    "java -jar run.jar"   6 minutes ago   Up 6 minutes (healthy)   0.0.0.0:8071->8071/tcp   prod_config_1
(base) Chows-MacBook-Pro:prod david$ 
```

```
PSOT http://localhost:8083/myAccount
{
    "customerId":1
}
{
    "customerId": 1,
    "accountNumber": 123456789,
    "accountType": "Savings",
    "branchAddress": "Mel",
    "createDt": "2022-02-04"
}
```




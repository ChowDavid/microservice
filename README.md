# Build process, create jar and create docker images.
```
mvn clean package -T 5
```
# Run
```
cd docker-compose
cd prod
docker-compose up

```
# Check
```
// Eureke
http://localhost:8070
// Config
http://localhost:8071
// account
http://localhost:8080/actautor
// card
http://localhost:9000/actautor
// loan
http://localhost:8090/actautor
```
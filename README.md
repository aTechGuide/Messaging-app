# Messaging App
This app keeps track of last 5 comments on news and publish new comment to news subscriber. Persistence is done on Redis which maintains track of last 5 comments on news.

# Setting up Redis
Download the Tar from [this](http://download.redis.io/releases/redis-3.2.6.tar.gz) link

**Compiling Redis**
```
Unzip it  
cd redis-3.2.6  
make
```

**Run Redis**
```
cd src  
./redis-server ../redis.conf
```

**To persist the data in Redis DB on multiple startups**  
Open ``` redis.conf ```. Search for 'appendonly' and make its value 'yes'  

# API List
http://localhost:8080/swagger-ui.html#/


# References
https://spring.io/guides/gs/messaging-redis/

https://dzone.com/articles/using-redis-spring

Build Redis ->  https://dzone.com/articles/spring-data-redis-0

CRUD Operations on Object -> http://www.baeldung.com/spring-data-redis-tutorial

Using Redis CLI -> https://examples.javacodegeeks.com/enterprise-java/spring/spring-data-redis-example-2/

Swagger Integration -> http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api  

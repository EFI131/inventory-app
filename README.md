# inventory-app
sptingboot inventory CRUD API demo

## Introduction

A simple Spring boot application running on port 8080 exposing a Spring Data REST+- interface for item management entities. Used for demo purposes.
The program is using swagger-ui 2 therefore entrypoints are visible at localhost:8080/swagger-ui.html
```
Functionalities are as such:
Item Creation.
Deposit of n units of already created item.
Withdrawal of n units of already created item.
Item Deletion.
Single item fetch by id 
Fetch All Items

```
## Building
The sample is built using maven. 
```
## Docker
A docker image named `efisteiner/springboot-inventory-app` is available on [Docker HUB](https://hub.docker.com/repository/docker/efisteiner/springboot-inventory-app).

The docker image can be started using

```
## H2
By default the application uses an H2 database.

## Error massages
Error messages are enabled 

## Swagger
Swagger docs are available at http://localhost:8080/swagger-ui.html


## Testing
Coming Soon...

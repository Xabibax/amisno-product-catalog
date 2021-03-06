# Amisno Catalog Service

Spring Boot Server

## Requirements

* Java  = 1.8.X ([OpenJdk](https://openjdk.java.net/install/) / [Oracle](https://www.oracle.com/fr/java/technologies/javase/javase-jdk8-downloads.html))
* Gradle (optional)
* [Docker](https://docs.docker.com/install/) and [Docker Compose](https://docs.docker.com/compose/install/) installed.


## Overview  

This server was generated by the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project.  
By using the [OpenAPI-Spec](https://github.com/swagger-api/swagger-core), you can easily generate a server stub.  

The underlying library integrating swagger to SpringBoot is [springfox](https://github.com/springfox/springfox)  

Start your server as an simple java application  

You can view the api documentation in swagger-ui by pointing to  
<http://localhost:8090/swagger-ui.html>

Change default port value in src/ressources/application.properties

## Installation

```bash
./gradlew clean build
```

## Launch

```bash
./gradlew bootRun
```

## Docker compose

There is three docker-compose files:

* a docker-compose-desktop to launch in localhost the product-catalog service,
  with grafana and promoteus for monitoring. Launch with :

```bash
docker-compose up -f docker-compose-desktop.yml
```
* a docker-compose-test launch all the stack needed with product-catalog,
  launch with :

```bash
docker-compose up -f docker-compose-test.yml
```

* a docker-compose-monitor to launch only grafana and promoteus, 
  launch with :

```bash
docker-compose up -f docker-compose-monitor.yml
```

## Monitoring with Prometheus and Grafana (OPTIONAL)

### Step 1
Use docker-compose to start Grafana and Prometheus servers.
- In the root folder
```sh
docker-compose -f docker-compose-test.yml up
```
### Step 2
Check the Prometheus server.
- Open http://localhost:9090
- Access status -> Targets, both endpoints must be "UP"

### Step 3
Configure the Grafana.
- Open http://localhost:3000
- **Configure integration with Prometheus**
    - Access configuration
    - Add data source
    - Select Prometheus
    - Use url "http://localhost:9090" and access with value "Browser"
- **Configure dashboard**
    - Access "home"
    - Import dashboard
    - Upload dashboard.json from /docker


## License

Copyright 2019 Robert Winkler

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, 
software distributed under the License is distributed on an "AS IS" BASIS, 
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
See the License for the specific language governing permissions and limitations under the License.
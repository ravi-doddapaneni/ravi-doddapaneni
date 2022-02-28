# Profile Service
The profile microservice is a domain service which fetches the profile details of a logged in customer.

## System requirements
- JDK

## Running the application locally
### Building the application
The project uses Gradle as a build tool. It already contains `./gradlew` wrapper script, so there is no need to install gradle.

To build the project execute the following command

```bash
  ./gradlew build
```

### Running the application
#### Gradle
Run the project with the following command
```bash
  ./gradlew bootrun
```

This will start the app and it can be accessed with the URL below
```bash
  http://localhost:8080
```
#### CloudCode - Skaffold (local build & deploy Kubernetes app)(alternate to DockerHub as DockerHub is licensed now)
- Cloud Code, a GCP extension,  provides a IntelliJ / VSCode extension
to build & deploy Docker apps. For local deployment it uses Skaffold.

- Skaffold provides a simple yaml file configuration. This configuration automates 
building docker images from Docker file & deploying it to a local cluster.Skaffold is the underlying engine that powers Cloud Code, helping you build, push, and deploy your application as well as providing support for creating CI/CD pipelines.

- In this project we are using Dockerfile for image build config. Helm Charts for deployment configs.  
- Installation instructions   
  - Install Cloud Code plugin for IntelliJ / VS code(https://cloud.google.com/code/docs/intellij/install)
    NOTE: Dont install docker-hub, unless the project has acquired license.   
  - Install managed dependencies as mentioned on Cloud Code website(kubectl, minikube, Skaffold) 
  - Install Helm (https://helm.sh/docs/intro/install/)
- Running application
  - In a terminal run "minikube start"
  - On IntelliJ IDE, select Run -> Edit Configuration -> Add new config -> CloudCode:Kubernetees
  - It should get auto config to use Skaffold.yml to build & run the app


#### Docker
Create a docker image

```bash
  docker build -t services-profile .
```

Create a container from the docker image
```bash
  docker run -d -p 8080:8080 --name profile services-profile
```

## Dependencies used
The following plugins are used in this project
- Swagger
- Spring Boot Actuator
- Spring Boot Dev Tools
- Lombok
- Flogger

## Features
1. The service is able to fetch profile data of the customer

## Releases
1. 0.0.1-SNAPSHOT: Fetch customer's profile data from Data API

## Copyright
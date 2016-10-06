Blueprint Rest Template
===

The Blueprint Rest Template provides a starting point for creating a restful microservice that conforms to the core
tenets of Nike's Cloud Native Architecture.

This template provides the following functionality:

* Base Karyon Service Implementation
* Common Error Code Structure
* Common ExceptionMapper
* Default Jackson Provider
* Default Cache Control Handling
* Default Edge Control Handling
* Default GZip Support

##Running The Service

```
$ ./run.sh
```

##Initial Endpoints
The template application exposes the following endpoints which you can visit on your running instance:

###Service Interface
* GET http://localhost:8080/rcfsabrixjobstatus/v1/example

###Healthcheck
* GET http://localhost:8077/healthcheck

###Administration Console
* GET http://localhost:8077/admin
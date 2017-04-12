# Simple Spring Boot http server with http/2

A very simple and dumb webserver. Based on spring boot, configured to use Undertow as its servlet container.

The server uses the version 2 of the http protocol.

After starting the server, visit [https://localhost:8443/greeting?name=JavaLand](https://localhost:8443/greeting?name=JavaLand)

## run

This example needs JDK 1.8.0_60 or newer and Maven 3.0 or newer.

Start the server:

1. Checkout project
1. Type `$ mvn clean package`
1. Type `$ ./script/run.sh HTTP2 8443`
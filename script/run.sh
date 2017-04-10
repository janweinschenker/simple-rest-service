#!/bin/bash
httpversion=$1
serverport=$2
java -Xbootclasspath/p:./lib/jetty-alpn-agent-2.0.5.jar -jar target/simple-rest-service-1.0-SNAPSHOT.jar --http.version=$httpversion --server.port=$serverport

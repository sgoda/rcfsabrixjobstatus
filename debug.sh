#!/bin/bash

echo "Waiting for debugger connection on port 5005 ..."
./gradlew jettyRun -Dorg.gradle.jvmargs='-Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=5005,suspend=n'

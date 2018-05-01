#!/bin/bash
# author: Andre Wolden


mvn clean install -DskipTests
java -jar target/temp-1.0-SNAPSHOT.jar

# END

#!/bin/bash

mvn -am -pl war,bom -DskipTests -Dspotbugs.skip clean install
mvn -pl war jetty:run

#! /bin/bash
rm -r target/
rm -r ~/.m2/repository/*
mvn clean
mvn compile
mvn install


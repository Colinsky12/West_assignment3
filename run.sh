#!/bin/bash
rm -rf bin
mkdir bin
javac -d bin src/*.java
java -cp bin BinarySearchTreeDriver
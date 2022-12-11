#!/bin/bash

mkdir testRun
cd testRun
git clone https://github.com/Helgi-cell/HashStringAlphabetical -b long-hash-version
cd HashStringAlphabetical
java -jar target/hash-string-0.0.1-SNAPSHOT.jar
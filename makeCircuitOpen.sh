#!/bin/bash
echo "Bash version ${BASH_VERSION}..."
for i in {0..100..1}; do
  curl -X GET "http://localhost:8090/v2/phone" -H "accept: application/xml"
done

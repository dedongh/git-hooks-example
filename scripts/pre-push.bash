#!/bin/bash
echo “Running pre-commit hook”
echo “run linter:”
mvn checkstyle:check
if [ $? -ne 0 ]; then
 echo “warning: lint failed.”
fi
echo “run tests:”
mvn clean test
if [ $? -ne 0 ]; then
 echo “Tests must pass before push!”
 exit 1
fi
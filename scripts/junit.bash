#!/bin/bash
#
# NAME
#     junit - run JUnit tests with ease
#
# USAGE
#     junit [FILE... | CLASS... | DIR]
#
# EXAMPLES
#     junit
#     junit inf101/v16/tests
#     junit inf101/v16/lab1/StackTest.java
#     junit inf101.v16.lab1.StackTest
#
# AUTHOR
#     Adrian Dvergsdal (atmoz.net)
#/Users/eoasiamah/.m2/repository/junit/junit/4.13.2/junit-4.13.2.jar!/junit
JUNIT_HOME=/Users/eoasiamah/.m2/repository/junit/junit/4.13.2/junit-4.13.2.jar!/junit
CLASSPATH=.:$JUNIT_HOME/junit.jar:$JUNIT_HOME/hamcrest-core.jar

tmpArgs=($@)

# Use current directory by default
if [ ${#tmpArgs[@]} -eq 0 ]; then
    tmpArgs=(".")
fi

# Expand directory arguments with files
for arg in ${tmpArgs[@]}; do
    if [ -d "$arg" ]; then
        # If dir: add *.java files having @Test
        files=($(grep "@Test" --include "*.java" -rsl "$arg"))
        args=(${args[@]} ${files[@]})
    else
        args=(${args[@]} $arg)
    fi
done

# Build path and class arrays
for arg in ${args[@]}; do
    if [[ "$arg" == *".java" ]]; then
        path="$arg"
        path="${path#./}" # Remove ./ if present
        class="${path//\//\.}" # Replaces / with .
        class="${class%.java}" # Removes .java
    else
        class="$arg"
        path="${class//\./\/}" # Replaces . with /
        path+=".java"
    fi

    if [ ! -f "$path" ]; then
        echo "The file \"$path\" does not exist!"
        exit 1
    fi

    pathArray=(${pathArray[@]} "$path")
    classArray=(${classArray[@]} "$class")
done

# Check results
if [ ${#pathArray[@]} -eq 0 ]; then
    echo "Found no tests!"
    exit 1
else
    echo "Found ${#pathArray[@]} files with tests:"
    for path in ${pathArray[@]}; do
        echo " - $path"
    done
    echo # new line
fi

# Compile and run tests
javac ${pathArray[@]} && exec java -cp $CLASSPATH org.junit.runner.JUnitCore ${classArray[@]}
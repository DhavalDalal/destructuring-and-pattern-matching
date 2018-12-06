#!/bin/sh
if [ -f "$1" ]; then
  # echo "Compiling ${1}..."
	FILENAME=$(echo "$1" | rev | cut -f 1 -d '/' | rev)
	javac -classpath .:./lib/* "${FILENAME}"
	CLASSNAME=$(echo "$FILENAME" | cut -f 1 -d '.')
  # echo "Running ${CLASSNAME}"
	java -classpath .:./lib/* "${CLASSNAME}"
	rm *.class
else
  echo "usage: ./run.sh <file-containing-main.java>"
	exit 0
fi


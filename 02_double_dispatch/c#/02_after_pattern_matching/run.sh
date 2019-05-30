#!/bin/sh
if [ -f "$1" ]; then
  # echo "Compiling ${1}..."
  REFERENCES="System.data.dll,System.Numerics.dll"
  REFERENCES+=`find . -maxdepth 1 -name "*.dll" | tr "\n" ","`
  # Run csc (supports C# 7.0)
  FILENAME=$1
  csc /nologo /langVersion:7.3 -reference:$REFERENCES /target:exe /recurse:"*.cs"
  file="${FILENAME%.*s}".exe
  echo | mono $file
  rm $file
  
else
  echo "usage: ./run.sh <file-containing-main.cs>"
	exit 0
fi

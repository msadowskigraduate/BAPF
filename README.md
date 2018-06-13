# BAPF [![Build Status](https://travis-ci.org/msadowskigraduate/BAPF.svg?branch=feature%2Fdfs)](https://travis-ci.org/msadowskigraduate/BAPF)

Bridge and Articulation Point Finder

### Installation

The application is a console based solution operating on Gradle.

It may be run using Gradle wrapper by running command: 

``gradlew run`` 

in the project directory.

Tested on Windows 10 using JDK 1.8.

### Usage

Once the application is started, use one of possible operating modes:

- [1] Find bridges in the given graph;
- [2] Find articulation points for given graph;

Then input the path to the graph file into the console:
example for Windows:

`C:/<USER>/Documents/mygraphfile.txt`

(Unix based operating systems were untested but may or may not work)

The graph for analysis has to be in the following format:
```
7   <Number of vertices>
    <Vertex 1 has no adjecent vertices of label lesser than 1>
1   <Vertex 2 is adjacent with Vertex 1>
    <Vertex 3 has no adjecent vertices with label <3 >
2 3 <Vertex 4 is adjecent with vertices 2 & 3 >
1
1 5
3 4
```
Where line 0 is the number of vertices in the graph;
Every next line _i_ is the list of adjacent vertices vertex _i_ where labels of adjacent vertices are < _i_.


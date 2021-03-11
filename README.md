# KeyFilter
An interview task for Junior Java Developer position.
Author: Igor Khokhlov

## Task description
- Create a static function with input arguments:
  + String string - variable containing keys inflated with spaces and separated by any number of commas;
  + String[] array - array consists of strings of same format;
- Filter array elements leaving only those that contain all keys in given string.
- Return filtered array as a list of strings.
  
## Input & Output examples
## Test 1
#### Input
```java
string: ",T1000,  T1001, ,, ,"
array: [
  ",T1001, T1000,,,,  T1002, ,, ,", 
  ",T1000,  , ,, ,", 
  ",T1001, T1002 , ,, ,",
  ""
]
```
#### Output
```java
result: [
  ",T1001, T1000,,,,  T1002, ,, ,"
]
```

## Test 2
#### Input
```java
string: " ,, T1000, ,,, ,, ,"
array: [
  ",T1001, T1000,,,,  T1002, ,, ,", 
  ",T1000,  , ,, ,", 
  ",T1001, T1002 , ,, ,",
  ""
]
```
#### Output
```java
result: [
  ",T1001, T1000,,,,  T1002, ,, ,", 
  ",T1000,  , ,, ,"
]
```

## Test 3
#### Input
```java
string: ",, ,, ,"
array: [
  ",T1001, T1000,,,,  T1002, ,, ,", 
  ",T1000,  , ,, ,", 
  ",T1001, T1002 , ,, ,",
  ""
]
```
#### Output
```java
result: []
```

## Suggested solution
To solve the task there were several options available:
  - single-way iteration through string from start to finish, removing extra commas and spaces if needed;
  - iteration from both ends doing exactly the same thing;
  - replace groupped commas with unique instances, removing spaces, splitting what is left by commas;
  - use regex to find keys in given string;
  - split string by regex separators.

First and second option are the first things that come to mind. But without explanation those methods are hard to comprehand with single glance. 
Third option is mildly inefficient, because each and every time we iterate through string replacing given occurencies, 
we have no idea how many times we need to repeat such a process.
It means that in worse case scenario we'll have to remove commas enormous amount of times even if there is only one key. This make this method unreasonable to use. 
Fifth option is elegant and versatile solution. Combine it with clean readable code and it becomes the best solution so far. 
It can also be modified to use more symbols as separators than commas. This makes all the difference in the world when you decide between last two solutions. 
It can be implemented by adding symbols to separating regex. 
To modify fourth option to do the same you need to generate endless combination of key regex and different pairs of separators.


Our solution implements **Strategy** design pattern to provide two various strategies for you to decide between keeping spaces if 
you need keys to contain them or removing them if they should be ignored.

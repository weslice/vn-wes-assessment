# vn-wes-assessment
VN Assessment


This project uses Java version 17, so in order to run you need to configure and use Java version 17 at the project configuration. 
For each exercise there is a folder in the project root. 
  For exercice 1 - the folder exercise-1  
  For exercice 2 - the folder exercise-2
  
Everything was coded to be up to production level quality. 
The tests was done for each of the exercise.
```  
The Exercise 1:
  I created a method that contains an algorithm that prints the whole integer number in the console. 
  The default operation is to print from number 1 to number 100.
  For that I created a java constant for the start number and the limit number to be printed.
  So if has any need to change the default behavior, you just need to change the value in the constant.
The rules:
  If the number to be printed is divisible by 3 should print the value "Visual" instead of the number itself.
  If the number to be printed is divisible by 5 should print the value "Nuts" instead of the number itself.
  If the number to be printed is divisible by 3 and by 5 should print the value "Visual Nuts" instead of the number itself.

And how to keep the code safe from bugs? or in the future when a developer has the needs to make small feature adjusments? 
  For that I implemented the Chain of Responsibility Design Pattern in Java. It also respects the Open-closed Principle (OCP) of SOLID. 
  The class responsible to print is NumberService it recives a PrintableResource class that is the Chain of Responsibility. 
  If a new condition/rule has to be implemented like:
    If the number is divisible by 7 sould print something else,
    you just need to implement a new Chain of Responsibility instead of modifying the service class itself.
 ```
 
 In the main class of exercise-1 has the method implemented. 

  
The Exerciese 2:
  You have a JSON data describing official languages spoken by countries:
```
[
  {
    "country":"US",
    "languages": ["en"]
  },
  {
    "country":"LU",
    "languages": ["lu", "fr", "de"]
  },
  {
    "country":"BE",
    "languages": ["nl","fr","de"]
  },
  {
    "country":"NL",
    "languages": ["nl","fy"]
  },
  {
    "country":"DE",
    "languages": ["de"]
  },
  {
    "country":"ES",
    "languages": ["es"]
  }
]
```

I modified the Json and add a new country to test the functions.
I implemented a method for each request
```
- returns the number of countries in the world
- finds the country with the most official languages, where they officially speak German (de).
- that counts all the official languages spoken in the listed countries.
- to find the country with the highest number of official languages.
- to find the most common official language(s), of all countries.
```

In the main class of exercise-2, you have the methods called. And in the test folders the tests for each request. 
    


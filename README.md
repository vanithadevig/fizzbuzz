# FizzBuzz

FizzBuzz is a web service to print out a range of numbers. 
For multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. 
For numbers which are multiples of both three and five print “FizzBuzz”.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

```
Git
maven
Java 8
```

### Installation Instructions

A step by step series of examples that tell you have to get a development env running

 Clone the repository from the github :

```
git clone https://github.com/vanithadevig/fizzbuzz.git
```

 Build the project

```
mvn clean install
```

 Run FizzBuzz webapp

```
mvn tomcat7:run
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

```
mvn verify
```

curl commands :

```
curl http://localhost:8889/fizzbuzz/15
```

## Authors

* **Vanitha Devi Govindaswamy** 



# GreenHouseApplication
GreenHouseApplication is a lab to test json transfer data with android. The application sends two values (humidity and temperature)
 when it arrives at web server, this check if the conditions are optimal for cultivate a cucumber plant, if is not the case
 the status of a fan, lamp and sprinkler will change depending on the input values. 
 The status of the greenhouse can be shown at press the *check info* button inside of the application.

The server was made with django and the code can be found 
[here](https://github.com/oalberto96/GreenHouse)

![Screenshot](/Images/demo.gif)


## Setup
In the file 
`/app/src/main/java/com/computomovilyubicuo/audiosender/utilities/NetworkUtils.java`
change constants **HOST** and **HOST_GET** with your local ip

Example:

```java
public static final String HOST = "http://10.0.0.2/arduinodata";
public static final String HOST_GET = "http://10.0.0.2/android-actuators";
```

# speacking-clock-wisdom-leaf
Wisdom Leaf Task

1.	Given a 24-hour clock convert the current time into words e.g. "08:34" should be converted to "It's eight thirty four" 
2.	Make another controller to handle input from user in the format “11:25”
3.	Return Midday and Midnight as "It's Midday" and "It's Midnight"


The Program has two layers:
1. Controller
2. Service -> ServiceImpl
The controller layer handles all the requests and there is only one mapping.
port number: default(8080)
URL to get the time in words: http://localhost:8080/get?time=HH:MM
HH:MM time should be in this format to get the correct output or else it will return an error message which has been handled in the program.

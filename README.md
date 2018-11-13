This is a program that meets the following Criteria.


Babysitter Kata  
Background  
This kata simulates a babysitter working and getting paid for one night. The rules are pretty straight forward.  

Feature  
As a babysitter  
In order to get paid for 1 night of work  
I want to calculate my nightly charge  

Requirements  
The babysitter:  

starts no earlier than 5:00PM  
leaves no later than 4:00AM  
only babysits for one family per night  
gets paid for full hours (no fractional hours)  
should be prevented from mistakes when entering times (e.g. end time before start time, or outside of allowable work hours)  
The job:  

Pays different rates for each family (based on bedtimes, kids and pets, etc...)  
Family A pays $15 per hour before 11pm, and $20 per hour the rest of the night  
Family B pays $12 per hour before 10pm, $8 between 10 and 12, and $16 the rest of the night  
Family C pays $21 per hour before 9pm, then $15 the rest of the night  
The time ranges are the same as the babysitter (5pm through 4am)  
Deliverable:  

Calculate total pay, based on babysitter start and end time, and a family.  

Inputs are given by the user in the console, all improper inputs for specific reasons will display an error, and the exact
reason the input was rejected. It will continually ask until proper inputs are given. Once the proper input is given, it will display the wage. To test it with different data simply rerun the program. Input should be in the format of the 12 hour format for example the following  

4:00 PM  
5:35 AM
9:23 PM etc.  



RUNNING THE PROGRAM   
--------------------------

1. Clone the Repo to Desktop  

2. Import Project into the IDE, and run the main class. 




RUNNING THE PROGRAM FROM CMD/TERMINAL  
-------------------------------------  

To run the program from the CMD/Terminal   
  
1. Open up command prompt/Terminal  
  
2. Type CD and switch to the directory of the java project.  
  
3. Compile the files using javac TimeAnalyzer.java Babysitter.java WageCalculator.java  
  
4. Run the main class by typing java Babysitter.java

5. It's much easier to do the first one.

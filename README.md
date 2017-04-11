# Team1793RobotBase
**A framework for easily building robot code for the FIRST Robotics Competition**

# How does it work?
   This framework is built off of  [GradleRIO](https://github.com/Open-RIO/GradleRIO)
    and [Strongback](https://github.com/strongback/strongback-java) 
   
   Through the use of a custom gradle script to pull libraries from Maven Central and GradleRIO's 
    Hosted WPILib and CTR Talon natives this framework can be built without the use of 
    the Ant build system provided by FIRST.
    
# How to install it?  
   Simple clone this project and import the `build.gradle` into your favorite IDE
        Intellij IDEA will take care of initializing the script
        as for Eclipse or other IDEs I do not know, if necessary 
        run `./gradlew` on Unix or `gradlew.bat` on Windows
        
# How to use it? 
  The Robot class provided can be built from to create your robot
  Once you program your robot to push the code to the RoboRIO   
    1. Establish Communications with the RoboRIO through Ethernet (Also works through Radio) or USB-B connector (Printer cable)
    2. Then simply run two gradle task through command or via your IDE
        Linux: `./gradlew build deploy`
        Windows: `gradlew.bat build deploy`
        
        
# Creating your Robot

# Unit Tests



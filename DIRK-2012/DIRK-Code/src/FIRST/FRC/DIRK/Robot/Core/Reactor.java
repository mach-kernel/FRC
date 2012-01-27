/*
 * DIRK's "brain"
 * Reactor va1
 * 
 * This class manages the initialization of DIRK and
 * subsequently forks off different tasks to other 
 * components of the program.
 * 
 * Author: David Stancu (et al.)
 * FRC Team 3645 "Runtime Error"
 * 
 * Licensed under the GNU/GPL License v2
 * 
 */
package FIRST.FRC.DIRK.Robot.Core;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.camera.AxisCamera;

public class Reactor extends IterativeRobot 
{
    
    RobotDrive driveSystem = new RobotDrive(1,2);
    Joystick leftJoy = new Joystick(1);
    Joystick rightJoy = new Joystick(2);
    AxisCamera camera; 

    // Use me to predeclare a drive type on init.
    int type = 0;
    
    public void robotInit()
    {
        System.out.println("DIRK initializing: (powered by Reactor v1.272012)");
        System.out.println("Reactor is running on JRE " + System.getProperty("java.version"));
        System.out.println("Squawk VM Version: " + System.getProperty("vm.version"));
        System.out.println("Going to use Drive Type: " + type);
        
        camera = AxisCamera.getInstance();
        camera.writeResolution(AxisCamera.ResolutionT.k320x240);
        camera.writeBrightness(0);
    }
    
    public void autonomousPeriodic()
    {
        
    }
    
    public void teleopInit()
    {
        System.out.println("Select a drive type with left 4 or 5");
        System.out.println("4: Tank Drive");
        System.out.println("5: Arcade Drive");
        System.out.println("3: Clear values");
    }
    
//    public int driveType()
//    {
//         
//    }
    
    public void teleopPeriodic()
    {
        DriverStationLCD.getInstance(updateLCD);

    }
    
    public void teleopContinuous()
    {   
        if (leftJoy.getRawButton(4))
        {
            System.out.println("Tank Drive");
            type = 1;
        }  
        else if (leftJoy.getRawButton(5))
        {
            System.out.println("Arcade Drive");
            type = 2;
        }
        else if (leftJoy.getRawButton(3))
        {
            System.out.println("No Drive");
            type = 0; 
        }     
        
        if (type == 1)
        {
            driveSystem.tankDrive(leftJoy, rightJoy);
        }
        else if (type == 2)
        {
            driveSystem.arcadeDrive(leftJoy);
        }
        else 
        {
            System.out.println("Silly goose, set a drive type!");
        }

    }
}

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

public class Reactor extends IterativeRobot {
    
    private void coreInit()
    {
        System.out.println("DIRK initializing (powered by Reactor 1)");
        System.out.println("Reactor is running on JRE " + System.getProperty("java.version"));
        
    }
    
    public void robotInit()
    {
        
    }
    
    public void autonomousPeriodic()
    {
        
    }
    
    public void teleopPeriodic()
    {
        
    }
}

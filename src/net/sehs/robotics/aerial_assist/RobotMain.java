/* 
 * TEAM 2172 2014
 */

/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/*
 * RobotMain.java
 * The main body of code for the Robot
 * This file may be changed by the user (although only primarily in autonomous() 
 * and operatorControl())
 */
    
   /*
    * Axis Designations for Xbox 360 Controller
    * 1: Left Stick X
    * 2: Left Stick Y
    * 3: Triggers (Z axis)
    * 4: Right Stick X
    * 5: Right Stick Y
    */

package net.sehs.robotics.aerial_assist;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.camera.AxisCameraException;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class RobotMain extends IterativeRobot
{
    /******************************** Objects *********************************/
    Joystick joystick; // Joystick
    //Joystickps3; // PS3 Controller
    Drivetrain drivetrain;
    //RangeFinderSettings rangeFinger = new RangeFinderSettings(10);
    
    /******************************* Variables ********************************/

 
    /**************************** Initialization ******************************/
    public void robotInit()
    {
        joystick = new Joystick(1);
        //ps3 = new Joystick(2);
        drivetrain = new Drivetrain(Ports.drivetrain[0], Ports.drivetrain[1],
                Ports.drivetrain[2], Ports.drivetrain[3]);
    }

    /**************************** Autonomous function/loop ********************/
    public void autonomousInit()
    {
        while (isAutonomous() && isEnabled()) { 
        
        }
    }

    /*********************** Tele-operated Function/loop***********************/
    public void teleopInit()
    {
        System.out.println("Robot Enabled.");
    }
    
    public void teleopPeriodic()
    {
        drivetrain.joyDrive(joystick);

    }
       
    /*********************** Disabled method **********************************/
    public void disabledInit()
    {
        System.out.println("Robot disabled.");
    }
   
    public void disabledPeriodic()
    {
        drivetrain.stopMoving();
    }
}
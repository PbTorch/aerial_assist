/*
 * Drivetrain Class
 * Location of all things relevant to the movement of the robot.
 */
package net.sehs.robotics.aerial_assist;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 * @author Shullick and Renner
 */
public class Drivetrain {
    
    // Select jaguar configuration
    //Jaguar[] jag = new Jaguar[8]; 
    Jaguar[] wheelJags = new Jaguar[4];
    public RobotDrive ourRobot;
    
    public Gyro gyro = new Gyro(Ports.gyro);

    public Drivetrain(int frontLeft, int rearLeft, int frontRight, int rearRight) {
        
        wheelJags[0] = new Jaguar(frontLeft);
        wheelJags[1] = new Jaguar(rearLeft);
        wheelJags[2] = new Jaguar(frontRight);
        wheelJags[3] = new Jaguar(rearRight);

        ourRobot = new RobotDrive(wheelJags[0], wheelJags[1], wheelJags[2], wheelJags[3]);
      
        /** Other options **/
        
        // These invert the direction that the specified motors will spin.
        ourRobot.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
    }
    
    // Primary driving function -- options for tank/arcade drive commented out
    public void joyDrive(Joystick joystick) {
        
        if (joystick.getRawButton(5)) { // Kill switch
            if (joystick.getRawButton(3)) {
                //myRobot.arcadeDrive(0, -.5);
                ourRobot.mecanumDrive_Cartesian(joystick.getX(), joystick.getY(), -0.3, gyro.getAngle());
            }
            else if (joystick.getRawButton(2)) {
                //myRobot.arcadeDrive(0, .5);
                ourRobot.mecanumDrive_Cartesian(joystick.getX(), joystick.getY(), 0.3, gyro.getAngle());
            }
            else {
                //myRobot.arcadeDrive(joystick.getY(), joystick.getX());
                ourRobot.mecanumDrive_Cartesian(joystick.getX(), joystick.getY(), 0, gyro.getAngle());
            }
        }
        else
            stopMoving();
    }
    
    public void stopMoving()
    {
        ourRobot.mecanumDrive_Cartesian(0, 0, 0, 0);
    }
    
    public void rotateClockwise(double speed)
    {
        ourRobot.mecanumDrive_Cartesian(0, 0, -speed, 0);
    }
    
    public void rotateCounterCl(double speed)
    {
        ourRobot.mecanumDrive_Cartesian(0, 0, speed, 0);
    }
}

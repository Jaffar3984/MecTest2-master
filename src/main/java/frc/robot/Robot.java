/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.GenericHID;// <-- Needed for xbox style controllers
import edu.wpi.first.wpilibj.TimedRobot;// <-- New for 2019, takes over for the depricated Iteritive robot
import edu.wpi.first.wpilibj.XboxController;// <-- For using a gamepad controller
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.MecanumDrive;// <-- Needed for the drive base.
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;// <-- For writing data back to the drivers station.
import frc.robot.commands.DriveManuallyCommand;
import frc.robot.subsystems.DriveManuallySubsystem;


/**
 * This is a demo program showing how to use Mecanum control with the RobotDrive
 * class.  It's been modifed to call the WPI_Spark controllers, which use the can bus, 
 * instead of PWM.  
 */
public class Robot extends TimedRobot {
  // These will need to be updated to the CAN Ids of the WPI_Spark's
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  public static OI m_oi;

  public static DriveManuallySubsystem m_subsystem = new DriveManuallySubsystem();
  
  public static final int kFrontLeftChannel = 2;
  public static final int kRearLeftChannel = 3;
  public static final int kFrontRightChannel = 1;
  public static final int kRearRightChannel = 0;

  // What ever USB port we have the controller plugged into.
  public static final int kGamePadChannel = 0;

  //Lets map out the buttons
  public static final int kXboxButtonA = 1;
  public static final int kXboxButtonB = 2;
  public static final int kXboxButtonX = 3;
  public static final int kXboxButtonY = 4;

  public static final int kXboxButtonLB = 5; // <-- Left Button
  public static final int kXboxButtonRB = 6; // <-- Right Button
  public static final int kXboxButtonLT = 2; // <-- Left Trigger
  public static final int kXboxButtonRT = 3; // <-- Right Trigger

  public static final double kRampUpRate = 0.0; // The rate that the motor controller will speed up to full;
  public static final NeutralMode K_MODE = NeutralMode.Brake; // Setting the talons neutralmode to brake

  private MecanumDrive m_robotDrive;

  private GenericHID m_controllerDriver;

  public DeadBand m_stick;


  
  /**
   * This function if called when the robot boots up.
   * It creates the objects that are called by the other robot functions.
   */
  @Override
  public void robotInit() {
    m_oi = new OI();
    m_chooser.setDefaultOption("Default Auto", new DriveManuallyCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);

  


    // Invert the left side motors.
    // You may need to change or remove this to match your robot.
    

    // m_controllerDriver = new Joystick(kJoystickChannel);
    
    m_controllerDriver = new XboxController(kGamePadChannel);

    /**
     * Added to test out setting talon config some settings internal
     * to the Sparks
     */

    m_stick = new DeadBand();
  
  } // *********************** End of roboInit **********************************
  
  /**
   * When in teleop this function is called periodicly
   */
  @Override
  public void teleopPeriodic() {
    // Need to come up with a way to tone down the joysticks

    // If I did this right, this should allow for direction of travel to be set by using the left joystick
    // while the rotation of the robot is set by the right stick on the controller.
    m_robotDrive.driveCartesian(m_stick.SmoothAxis(m_controllerDriver.getRawAxis(1)), 
                                m_stick.SmoothAxis(m_controllerDriver.getRawAxis(0)), 
                                m_stick.SmoothAxis(m_controllerDriver.getRawAxis(4)));



    
  } // ************************** End of teleopPeriodic *************************
    
  /**
   * testPeriodic function is called periodicly when the DS is 
   * in test mode.
   */
  @Override
  public void testPeriodic(){
  // Ok, so how do we read that a button has been pressed?  Also can we output it to a dashboard?
  //  public static final String ButtonStatus = "Button Pressed:";

    //This block of code should be moved down to
    if (m_controllerDriver.getRawButtonPressed(1)){
      System.out.println("Button A Pressed");
      SmartDashboard.putString("Button A = ", "I was pushed");
    }
    else if (m_controllerDriver.getRawButtonReleased(1)){
      System.out.println("Button A Released");
      SmartDashboard.putString("Button A = " , "I was released");
    }
    

  } // ************************ End of testPeriodic **************************

/**
 * @return the m_robotDrive
 */
public MecanumDrive getM_robotDrive() {
	return m_robotDrive;
}

/**
 * @param m_robotDrive the m_robotDrive to set
 */
public void setM_robotDrive(MecanumDrive m_robotDrive) {
	this.m_robotDrive = m_robotDrive;
}

/**
 * @return the m_controllerDriver
 */
public GenericHID getM_controllerDriver() {
	return m_controllerDriver;
}

/**
 * @param m_controllerDriver the m_controllerDriver to set
 */
public void setM_controllerDriver(GenericHID m_controllerDriver) {
	this.m_controllerDriver = m_controllerDriver;
}

/**
 * @return the m_stick
 */
public DeadBand getM_stick() {
	return m_stick;
}

/**
 * @param m_stick the m_stick to set
 */
public void setM_stick(DeadBand m_stick) {
	this.m_stick = m_stick;
}

}

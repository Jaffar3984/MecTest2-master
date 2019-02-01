/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

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

  public MecanumDrive m_robotDrive;

  public GenericHID m_controllerDriver;

  public DeadBand m_stick;
  public static int backRight =  3;
  public static int frontRight = 2;
  public static int frontLeft = 0;
  public static int backLeft = 1;

  public static int Joystickport = 0;



  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveManuallyCommand;

/**
 * Add your docs here.
 */
public class DriveManuallySubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Spark backRightMotor = new Spark(RobotMap.backRight);
  void setInverted(boolean backRightMotor){
    
  }
  public Spark frontRightMotor = new Spark(RobotMap.frontRight);
  public Spark backLeftMotor = new Spark(RobotMap.backLeft);
  public Spark frontLeftMotor = new Spark(RobotMap.frontLeft);
 
  //add speed controller groups
  SpeedControllerGroup leftSpeedControllerGroup = new SpeedControllerGroup(frontLeftMotor, backLeftMotor);
  SpeedControllerGroup rightSpeedControllerGroup = new SpeedControllerGroup(frontRightMotor, backRightMotor);

  public DifferentialDrive DriveThing = new DifferentialDrive(leftSpeedControllerGroup, rightSpeedControllerGroup);

  

  public void manualDrive(double move, double turn){
    //deadband joystick 
    if (move < 0.2){
      move = 0;
    } 
    if (turn < 0.2){
      turn = 0;
    }
    DriveThing.arcadeDrive(move, turn);

    
  }


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveManuallyCommand());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }


/**
 * @return the backRightMotor
 */
public Spark getBackRightMotor() {
	return backRightMotor;
}


/**
 * @param backRightMotor the backRightMotor to set
 */
public void setBackRightMotor(Spark backRightMotor) {
	this.backRightMotor = backRightMotor;
}


/**
 * @return the frontRightMotor
 */
public Spark getFrontRightMotor() {
	return frontRightMotor;
}


/**
 * @param frontRightMotor the frontRightMotor to set
 */
public void setFrontRightMotor(Spark frontRightMotor) {
	this.frontRightMotor = frontRightMotor;
}


/**
 * @return the backLeftMotor
 */
public Spark getBackLeftMotor() {
	return backLeftMotor;
}


/**
 * @param backLeftMotor the backLeftMotor to set
 */
public void setBackLeftMotor(Spark backLeftMotor) {
	this.backLeftMotor = backLeftMotor;
}


/**
 * @return the frontLeftMotor
 */
public Spark getFrontLeftMotor() {
	return frontLeftMotor;
}


/**
 * @param frontLeftMotor the frontLeftMotor to set
 */
public void setFrontLeftMotor(Spark frontLeftMotor) {
	this.frontLeftMotor = frontLeftMotor;
}


/**
 * @return the leftSpeedControllerGroup
 */
public SpeedControllerGroup getLeftSpeedControllerGroup() {
	return leftSpeedControllerGroup;
}


/**
 * @param leftSpeedControllerGroup the leftSpeedControllerGroup to set
 */
public void setLeftSpeedControllerGroup(SpeedControllerGroup leftSpeedControllerGroup) {
	this.leftSpeedControllerGroup = leftSpeedControllerGroup;
}


/**
 * @return the rightSpeedControllerGroup
 */
public SpeedControllerGroup getRightSpeedControllerGroup() {
	return rightSpeedControllerGroup;
}


/**
 * @param rightSpeedControllerGroup the rightSpeedControllerGroup to set
 */
public void setRightSpeedControllerGroup(SpeedControllerGroup rightSpeedControllerGroup) {
	this.rightSpeedControllerGroup = rightSpeedControllerGroup;
}


/**
 * @return the driveThing
 */
public DifferentialDrive getDriveThing() {
	return DriveThing;
}


/**
 * @param driveThing the driveThing to set
 */
public void setDriveThing(DifferentialDrive driveThing) {
	DriveThing = driveThing;
}
}

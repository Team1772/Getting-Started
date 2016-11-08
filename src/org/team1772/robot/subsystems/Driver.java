package org.team1772.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Driver extends Subsystem {
	// Components
	private Talon leftMotor, leftMotorB;
	private Talon rightMotor, rightMotorB;
    public Encoder leftEncoder, rightEncoder;
    public PIDController leftPID, rightPID;
    public ADXRS450_Gyro gyro;
    
    public Driver () {

    	// Set PWMs
    	leftMotor    = new Talon(0);
    	leftMotorB   = new Talon(1);
    	rightMotor   = new Talon(2);
    	rightMotorB  = new Talon(3);

    	rightMotor.setInverted(true);
    	rightMotorB.setInverted(true);
    	
    	gyro = new ADXRS450_Gyro();

    	leftEncoder  = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
    	rightEncoder = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
    	
    	// (Wheel Size Inches * Math.PI) / Encoder Counts Per Revolution
    	rightEncoder.setDistancePerPulse(24.25 / 4844);
    	leftEncoder.setDistancePerPulse(24.25 / 4842);

    	// Set PIDs type
    	leftEncoder.setPIDSourceType(edu.wpi.first.wpilibj.PIDSourceType.kDisplacement);
        rightEncoder.setPIDSourceType(edu.wpi.first.wpilibj.PIDSourceType.kDisplacement);
    }

    public void setInputSpeed(double leftSpeed, double rightSpeed) {
    	rightMotor.set(rightSpeed);
    	rightMotorB.set(rightSpeed);
    	leftMotor.set(leftSpeed);
    	leftMotorB.set(leftSpeed);
    }
    
    public boolean setPoint(double inches, double speed) {
    	setInputSpeed(speed, speed);
    	return Math.abs(leftEncoder.getDistance()) > Math.abs(inches) && Math.abs(rightEncoder.getDistance()) > Math.abs(inches);
    }

    public boolean setRotation(double inches, double speed) {
    	setInputSpeed(speed, -speed);
    	return Math.abs(leftEncoder.getDistance()) > Math.abs(inches) && Math.abs(rightEncoder.getDistance()) > Math.abs(inches);
    }

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}

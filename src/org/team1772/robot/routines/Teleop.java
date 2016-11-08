package org.team1772.robot.routines;

import org.team1772.Core.util.XboxControl;
import org.team1772.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;

public enum Teleop {
	INSTANCE;

	private XboxControl copilot;
	private Joystick pilotRight;
	private Joystick pilotLeft;
	
    public void init() {
    	copilot       = new XboxControl(0);
    	pilotRight    = new Joystick(1);
    	pilotLeft     = new Joystick(2);
    }

    public void periodic() {
    	//Pilot
    	Robot.driver.setInputSpeed(pilotRight.getY(), pilotLeft.getY());
    	
    	//Copilot
    	// Set intake speed
    	if (copilot.getButtonX()) {
    		//Intake.getInstance().catchBall(true);
		} else {
			if (copilot.getButtonA()) {
				//Intake.getInstance().setSpeed(true);
			} else {
				//Intake.getInstance().setReverseSpeed(copilot.getButtonB());
			}
			//Intake.getInstance().setIntake(!copilot.getButtonY());
		}

    	// Set launcher speed
    	//Shooter.getInstance().setSpeed(copilot.getButtonR1());
    	// Change status to low bar
    	//Shooter.getInstance().setHighGoal(copilot.getButtonL1());
    	// HardStopping
    	// Arm
    	Robot.arm.go(pilotRight.getRawButton(9));
    }
}

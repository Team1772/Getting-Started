package org.team1772.Core.util;

public class XboxControl extends edu.wpi.first.wpilibj.Joystick {

	public XboxControl(int port) {
		super(port);
	}
	
	/* AXIS */
	public double getAxisLeftY() {
		return this.getY();
	}
	
	public double getAxisLeftX() {
		return this.getX();
	}
	
	public double getAxisRightY() {
		return this.getRawAxis(5);
	}
	
	public double getAxisRightX() {
		return this.getRawAxis(4);
	}
	
	public double getAxisZRight() {
		return this.getRawAxis(3);
	}
	
	public double getAxisZLeft() {
		return this.getRawAxis(2);
	}
	
	/* BUTTONS */
	public boolean getButtonA() {
		return this.getRawButton(1);
	}
	
	public boolean getButtonX() {
		return this.getRawButton(3);
	}
	
	public boolean getButtonY() {
		return this.getRawButton(4);
	}
	
	public boolean getButtonB() {
		return this.getRawButton(2);
	}
	
	public boolean getButtonL1() {
		return this.getRawButton(5);
	}
	
	public boolean getButtonR1() {
		return this.getRawButton(6);
	}
	
	public boolean getButtonStart() {
		return this.getRawButton(8);
	}
	
	public boolean getButtonSelect() {
		return this.getRawButton(7);
	}
	
	public boolean getButtonL3() {
		return this.getRawButton(9);
	}
	
	public boolean getButtonR3() {
		return this.getRawButton(10);
	}

}

package org.team1772.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends Subsystem {
	private Solenoid armSolenoid;
	
	public Arm() {
		armSolenoid = new Solenoid(4);
	}
	
	public void go(boolean goUpOrDown) {
		SmartDashboard.putBoolean("arm", goUpOrDown);
		armSolenoid.set(goUpOrDown);
	}
	
	// Singleton
	/*private static Arm instance;
	public static Arm getInstance() {
		if(instance == null) {
			instance = new Arm();
		}
		return instance;
	}*/

	@Override
	protected void initDefaultCommand() {
	}

}
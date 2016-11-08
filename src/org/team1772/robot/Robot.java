
package org.team1772.robot;

import org.team1772.robot.routines.Teleop;
import org.team1772.robot.subsystems.*;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {

	private Compressor compressor;
	public static Arm arm;
	public static Driver driver;
	
    public void robotInit() {
    	compressor = new Compressor();
    	arm        = new Arm();
    	driver     = new Driver();

    	compressor.enabled();
    }

    public void autonomousInit() {
    }
    
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    }
    
    public void teleopInit() {
    	Teleop.INSTANCE.init();
    }

    public void teleopPeriodic() {
    	Teleop.INSTANCE.periodic();
    }
}
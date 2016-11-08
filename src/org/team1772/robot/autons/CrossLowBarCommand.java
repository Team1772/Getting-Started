package org.team1772.robot.autons;

import org.team1772.Core.auton.Autonomous;
import org.team1772.robot.Robot;

public class CrossLowBarCommand extends Autonomous {
	public CrossLowBarCommand() {
		super();

		addStep(() -> Robot.driver.setPoint(50, 0.5));
		
		addParallelStep(() -> {
			Robot.arm.go(true);
			return timeOut(0.5);
		});
	}
}
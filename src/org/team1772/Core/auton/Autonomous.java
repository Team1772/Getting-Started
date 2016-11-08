package org.team1772.Core.auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {
	private int indexer;
	private Timer timer;
	
	public Autonomous() {
		indexer = 0;
		timer = new Timer();
	}
	
	public boolean timeOut(double seconds) {
		timer = timer == null ? new Timer() : timer;
		timer.start();

		if (timer.get() > seconds) {
			timer.reset();
			
			return true;
		}
		return false;
	}
	
	/* COMMAND BASED AUTONOMOUS */
	public void addStep(IStep step) {
		super.addSequential(this.toCommand(indexer++, step));
	}
	public void addParallelStep(IStep step) {
		super.addParallel(this.toCommand(indexer++, step));
	}
	
	private Command toCommand(int stepNumber, IStep step) {
		return new Command() {
			@Override
			protected boolean isFinished() {
				return step.run();
			}
			
			@Override
			protected void execute() {
			}
			
			@Override
			protected void interrupted() {
				System.out.println(stepNumber + " Interrupted");
			}
			
			@Override
			protected void initialize() {
				System.out.println(stepNumber + " Initialize");
			}
			
			@Override
			protected void end() {
				System.out.println(stepNumber + " End");
			}
		};
	}
}

package org.team1772.Core.components;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

public class GearBox {
	private SpeedController leftMotor, rightMotor;
    private Encoder leftEncoder, rightEncoder;

	public GearBox(int m1, int m2, int encAa, int encAb, int encBa, int encBb) {
    	// Set PWMs
    	leftMotor    = new Talon(0);
    	rightMotor   = new Talon(2);

    	leftEncoder  = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
    	rightEncoder = new Encoder(2, 3, true, Encoder.EncodingType.k4X);
    	
    	// (Wheel Size Inches * Math.PI) / Encoder Counts Per Revolution
    	rightEncoder.setDistancePerPulse(24.25 / 4844);
    	leftEncoder.setDistancePerPulse(24.25 / 4842);

    	// Set PIDs type
    	leftEncoder.setPIDSourceType(edu.wpi.first.wpilibj.PIDSourceType.kDisplacement);
        rightEncoder.setPIDSourceType(edu.wpi.first.wpilibj.PIDSourceType.kDisplacement);
	}

}

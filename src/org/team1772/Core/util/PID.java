package org.team1772.Core.util;

public class PID{
	
	double error, sample, lastSample;
	double kP, kI, kD;      
	double P, I, D, pid;
	double setPoint, minOut, maxOut;
	long lastProcess;
	float deltaTime;
	
	public PID(double _kP, double _kI, double _kD){
		kP = _kP;
		kI = _kI;
		kD = _kD;
	}
	public void setOutputRange(double min, double max){
		this.minOut = min;
		this.maxOut = max;
	}

	//S - Adiciona nova amostra (valor do encoder)
	public void addNewSample(double _sample){
		this.sample = _sample;
	}
	
	//S - Ponto de ajuste
	public void setSetPoint(double _setPoint){
		this.setPoint = _setPoint;
	}
	
	public boolean isDone(double sample, double setPoint, double tolerance) {
		System.out.println("PID isDone -> sample: " +sample+" setPoint: "+setPoint+" tolerance: "+tolerance);
		return sample >= setPoint - tolerance;
	}
	
	public double calc(double sample, double setPoint){
		error = setPoint - sample;
		deltaTime = (float)((System.currentTimeMillis() - lastProcess) / 1000.0);
		lastProcess = System.currentTimeMillis();
		
		//P
		P = error * kP;
		
		//I
		I = I + (error * kI) * deltaTime;
		
		//D
		D = (lastSample - sample) * kD / deltaTime;
		lastSample = sample;
		
		// Soma tudo
		pid = (P + I + D) / 100;//pid = P + I + D;
		
		return Math.min(Math.max(minOut, pid), maxOut);
	}
	public double calc(){
		return calc(this.sample, this.setPoint);
	}
}
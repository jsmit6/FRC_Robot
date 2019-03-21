package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import frc.robot.RobotMap;
import frc.robot.commands.Wrist;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class WristSubsystem extends Subsystem {

    private Spark wristMotor;
    public final boolean ENABLED;

    private Potentiometer pot = new AnalogPotentiometer(RobotMap.wristPotentiometer);

    public WristSubsystem(boolean enabled) {
        ENABLED = enabled;
        if(enabled){
            wristMotor = new Spark(RobotMap.wristMotorID);
            wristMotor.setInverted(false);
            SmartDashboard.putString("Wrist Subsystem", "Online");
        } else {
            SmartDashboard.putString("Wrist Subsystem", "Offline");
        }
    }

    @Override
    public void initDefaultCommand() {
        if(ENABLED){
            setDefaultCommand(new Wrist());
        }
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Wrist Pot", getPotValue());
    }

    public void rotate(double yAxis){
        wristMotor.set(yAxis);
    }

    private int getPotValue(){
        return (int) (pot.get() * 100);
    }

    public void rotateToPosition(int potentiometerValue){
        int potValue = getPotValue();
        if(potValue < potentiometerValue){
            // Rotate wrist certain direction
        }else{
            // Rotate wrist other direction
        }
    }

    public void stop(){
        wristMotor.stopMotor();
    }
}
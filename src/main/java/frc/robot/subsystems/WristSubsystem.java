package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.Wrist;

public class WristSubsystem extends Subsystem {

    private Spark wristMotor;
    public final boolean ENABLED;
    private boolean isejected;

    private DoubleSolenoid eject = new DoubleSolenoid(1, 0);

    private Potentiometer pot = new AnalogPotentiometer(RobotMap.wristPotentiometer);

    public WristSubsystem(boolean enabled) {
        ENABLED = enabled;
        if(enabled){
            wristMotor = new Spark(RobotMap.wristMotorID);
            wristMotor.setInverted(false);
            eject.set(Value.kReverse);
            SmartDashboard.putString("Wrist Subsystem", "Online");
        } else {
            SmartDashboard.putString("Wrist Subsystem", "Offline");
        }
        isejected = false;
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

    public void ejectDisc(){
        if(isejected){
            eject.set(Value.kReverse);
            isejected = false;
            Timer.delay(0.5);
        } else {
            eject.set(Value.kForward);
            isejected = true;
            Timer.delay(0.5);
        }
    }

    public void rotate(double yAxis){
        wristMotor.set(yAxis);
    }

    private int getPotValue(){
        return (int) (pot.get() * 1000);
    }

    public void rotateToPosition(int potentiometerValue){
        int potValue = getPotValue();
        System.out.println(potValue);
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
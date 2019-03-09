package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Wrist;
import edu.wpi.first.wpilibj.Timer;

public class WristSubsystem extends Subsystem {

    private Spark wristMotor;
    public final boolean ENABLED;
    private boolean isejected;

    private DoubleSolenoid eject = new DoubleSolenoid(2, 3);

    public WristSubsystem(boolean enabled) {
        ENABLED = enabled;
        if(enabled){
            wristMotor = new Spark(RobotMap.wristMotorID);
            wristMotor.setInverted(false);
            eject.set(Value.kReverse);
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
        // Put code here to be run every loop
    }

    public void ejectDisc(){
        /*System.out.println("Ejecto");
        eject.set(Value.kForward);
        Timer.delay(0.1);
        eject.set(Value.kReverse);
        Timer.delay(0.1);
        eject.set(Value.kOff);*/
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

    public void stop(){
        wristMotor.stopMotor();
    }
}
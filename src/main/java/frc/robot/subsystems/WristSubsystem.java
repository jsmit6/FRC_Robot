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

    private DoubleSolenoid eject = new DoubleSolenoid(2, 3);

    public WristSubsystem(boolean enabled) {
        ENABLED = enabled;
        if(enabled){
            wristMotor = new Spark(RobotMap.wristMotorID);
            wristMotor.setInverted(false);
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
        // Put code here to be run every loop
    }

    public void ejectDisc(){
        System.out.println("Ejecto");
        eject.set(Value.kForward);
        Timer.delay(1);
        eject.set(Value.kReverse);
        Timer.delay(1);
        eject.set(Value.kOff);
    }

    public void rotate(double yAxis){
        wristMotor.set(yAxis);
    }

    public void stop(){
        wristMotor.stopMotor();
    }
}
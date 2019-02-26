package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Wrist;

public class WristSubsystem extends Subsystem {

    private Spark wristMotor;
    public final boolean ENABLED;

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

    public void rotate(double yAxis){
        wristMotor.set(yAxis);
    }

    public void stop(){
        wristMotor.stopMotor();
    }
}
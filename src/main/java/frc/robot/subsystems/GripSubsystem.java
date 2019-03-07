package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.RobotMap;

public class GripSubsystem extends Subsystem {

    private DoubleSolenoid leftGripSol;


    private DoubleSolenoid.Value isSqueezed;


    public final boolean ENABLED;
    public GripSubsystem(boolean enabled) {
        ENABLED = enabled;
        if(ENABLED){
            leftGripSol = new DoubleSolenoid(RobotMap.gripForwardChannel, RobotMap.gripBackwardChannel);
            
            isSqueezed = leftGripSol.get();
        }
    }

    @Override
    public void initDefaultCommand() {
        
    }

    @Override
    public void periodic() {

    }

    public boolean isSqueezing(){
        return isSqueezed == Value.kForward;
    }

    public void squeeze(){
        if((leftGripSol.get() != Value.kForward)){
            stop();
            leftGripSol.set(Value.kForward);
            Timer.delay(1);
            stop();
            isSqueezed = leftGripSol.get();
        }    
    }

    public void unsqueeze(){
        if(leftGripSol.get() != Value.kReverse){
            stop();
            leftGripSol.set(Value.kReverse);
            Timer.delay(1);
            stop();
            isSqueezed = leftGripSol.get();
        }
    }

    public void stop(){
        leftGripSol.set(Value.kOff);
    }
}
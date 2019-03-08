package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class GripSubsystem extends Subsystem {

    private DoubleSolenoid gripSol;


    public final boolean ENABLED;
    public GripSubsystem(boolean enabled) {
        ENABLED = enabled;
        if(ENABLED){
            gripSol = new DoubleSolenoid(RobotMap.gripForwardChannel, RobotMap.gripBackwardChannel);
        }
    }

    @Override
    public void initDefaultCommand() {
        
    }

    @Override
    public void periodic() {

    }

    public boolean isSqueezing(){
        return gripSol.get() == Value.kForward;
    }

    public void squeeze(){
        if((gripSol.get() != Value.kForward)){
            gripSol.set(Value.kForward);
            isSqueezed = gripSol.get();
        }    
    }

    public void unsqueeze(){
        if(gripSol.get() != Value.kReverse){
            gripSol.set(Value.kReverse);
            isSqueezed = gripSol.get();
        }
    }
    public void stop(){
        gripSol.set(Value.kOff);
    }
}
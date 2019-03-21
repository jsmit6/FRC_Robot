package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class GripSubsystem extends Subsystem {

    private DoubleSolenoid gripSol;


    public final boolean ENABLED;
    public GripSubsystem(boolean enabled) {
        ENABLED = enabled;
        if(ENABLED){
            gripSol = new DoubleSolenoid(RobotMap.gripForwardChannel, RobotMap.gripBackwardChannel);
            SmartDashboard.putString("Grip Subsystem", "Online");
        } else {
            SmartDashboard.putString("Grip Subsystem", "Offline");
        }
        SmartDashboard.putString("Grip Mode", "I'm just waiting.");
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
        }    
        updateSmartDashboard();
    }

    public void unsqueeze(){
        if(gripSol.get() != Value.kReverse){
            gripSol.set(Value.kReverse);
        }
        updateSmartDashboard();
    }

    public void stop(){
        gripSol.set(Value.kOff);
    }

    private void updateSmartDashboard(){
        if(isSqueezing()){
            SmartDashboard.putString("Grip Mode", "Squeezing as best I can :)");
        } else {
            SmartDashboard.putString("Grip Mode", "Stopped squeezing :(");
        }
    }
}
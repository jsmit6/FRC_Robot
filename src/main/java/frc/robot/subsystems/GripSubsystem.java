package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.RobotMap;

<<<<<<< HEAD

=======
>>>>>>> master
public class GripSubsystem extends Subsystem {

    private DoubleSolenoid leftGripSol;


    private boolean isSqueezed;


    public final boolean ENABLED;
    public GripSubsystem(boolean enabled) {
        ENABLED = enabled;
        if(ENABLED){
            leftGripSol = new DoubleSolenoid(RobotMap.gripForwardChannel, RobotMap.gripBackwardChannel);
<<<<<<< HEAD
            
            isSqueezed = leftGripSol.get();
=======

            isSqueezed = true;
>>>>>>> master
        }
    }

    @Override
    public void initDefaultCommand() {
        
    }

    @Override
    public void periodic() {

    }

    public boolean isSqueezing(){
        return isSqueezed;
    }

    public void squeeze(){
<<<<<<< HEAD
        if((leftGripSol.get() != Value.kForward)){
=======
        if(!isSqueezed){
>>>>>>> master
            stop();
            leftGripSol.set(Value.kForward);
            Timer.delay(1);
            stop();
            isSqueezed = !isSqueezed;
        }    
    }

    public void unsqueeze(){
<<<<<<< HEAD
        if(leftGripSol.get() != Value.kReverse){
=======
        if(isSqueezed){
>>>>>>> master
            stop();
            leftGripSol.set(Value.kReverse);
            Timer.delay(1);
            stop();
            isSqueezed = !isSqueezed;
        }
    }

    public void stop(){
        leftGripSol.set(Value.kOff);
    }
}
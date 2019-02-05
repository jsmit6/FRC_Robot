package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Timer;


public class GripSubsystem extends Subsystem {

    private DoubleSolenoid leftGripSol;
    private int leftGripSolForwardChannel;
    private int leftGripSolBackwardChannel;

    private DoubleSolenoid rightGripSol;
    private int rightGripSolForwardChannel;
    private int rightGripSolBackwardChannel;

    private boolean isSqueezed;

    private GripSubsystem gripInstance;

    public GripSubsystem() {
        if(gripInstance == null){
            gripInstance = this;
        }
        leftGripSol = new DoubleSolenoid(leftGripSolForwardChannel, leftGripSolBackwardChannel);
        rightGripSol = new DoubleSolenoid(rightGripSolForwardChannel, rightGripSolBackwardChannel);

        isSqueezed = true;
    }

    @Override
    public void initDefaultCommand() {
        
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public boolean isSqueezing(){
        return isSqueezed;
    }

    public void squeeze(){
        if(!isSqueezed){
            stop();
            leftGripSol.set(Value.kForward);
            rightGripSol.set(Value.kForward);
            Timer.delay(1);
            stop();
        }    
    }

    public void unsqueeze(){
        if(isSqueezed){
            stop();
            leftGripSol.set(Value.kReverse);
            rightGripSol.set(Value.kReverse);
            Timer.delay(1);
            stop();
        }
    }

    public void stop(){
        leftGripSol.set(Value.kOff);
        rightGripSol.set(Value.kOff);
    }
}
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Timer;

import static frc.robot.RobotMap.leftGripForwardChannel;
import static frc.robot.RobotMap.leftGripBackwardChannel;

import static frc.robot.RobotMap.rightGripForwardChannel;
import static frc.robot.RobotMap.rightGripBackwardChannel;

public class GripSubsystem extends Subsystem {

    private DoubleSolenoid leftGripSol;

    private DoubleSolenoid rightGripSol;

    private boolean isSqueezed;

    public GripSubsystem() {
        leftGripSol = new DoubleSolenoid(leftGripForwardChannel, leftGripBackwardChannel);
        rightGripSol = new DoubleSolenoid(rightGripForwardChannel, rightGripBackwardChannel);

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
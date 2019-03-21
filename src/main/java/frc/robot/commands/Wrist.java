package frc.robot.commands;

import static frc.robot.XBoxControllerMap.B;
import static frc.robot.XBoxControllerMap.RightJoystickY;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class Wrist extends Command {

    private Joystick controller = OI.xboxControllerD2;
    private double threshold = 0.05;

    public Wrist() {
        requires(Robot.wristSubsystem);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double yAxis = controller.getRawAxis(RightJoystickY);

        if(Math.abs(yAxis) > threshold){
            Robot.wristSubsystem.rotate(-yAxis / 2);
        }
        if(controller.getRawButton(B)){
            Robot.wristSubsystem.ejectDisc();
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if(Math.abs(controller.getRawAxis(RightJoystickY)) < threshold){
                return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        if(isFinished()){
            Robot.wristSubsystem.stop();
        } 
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {

    }
}
package frc.robot.commands;

import static frc.robot.XBoxControllerMap.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class Shoot extends Command {

    private Joystick controller = OI.xboxControllerD1;

    public Shoot() {
        requires(Robot.shootSubsystem);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        boolean input = controller.getRawButton(LB);
        boolean output = controller.getRawButton(RB);

        if(input){
            Robot.shootSubsystem.input();
        } else if(output){
            Robot.shootSubsystem.output();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if(!controller.getRawButton(LB) && !controller.getRawButton(RB)){
                return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        if(isFinished()){
            Robot.shootSubsystem.stop();
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {

    }
}
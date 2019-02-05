package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.OI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import static frc.robot.XBoxControllerMap.*;


public class Arm extends Command {

    private Joystick controller = OI.xboxController;
    private double threshold = 0.05;

    public Arm() {
        requires(Robot.armSubsystem);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double rTrigger = controller.getRawAxis(RB);
        double lTrigger = controller.getRawAxis(LB);
        //If either axes is less than threshold don't use them.
        if(Math.abs(rTrigger) < threshold){
            rTrigger = 0;
        }
        if(Math.abs(lTrigger) < threshold){
            lTrigger = 0;
        }
        if(lTrigger > 0 && rTrigger > 0){
            lTrigger = 0;
            rTrigger = 0;
        }
        Robot.driveSubsystem.drive(rTrigger, lTrigger);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if(controller.getRawAxis(LB)  < threshold  
            && controller.getRawAxis(RB) < threshold){
                return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        if(isFinished()){
            Robot.armSubsystem.stop();
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {

    }
}
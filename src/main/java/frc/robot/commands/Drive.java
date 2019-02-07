package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.OI;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.XBoxControllerMap.*;

public class Drive extends Command {

    private Joystick controller = OI.xboxController;
    private double threshold = 0.2;

    public Drive() {
        requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double yAxis = controller.getRawAxis(LeftJoystickY);
        double xAxis = controller.getRawAxis(RightJoystickX);
        //If either axes is less than threshold don't use them.
        if(Math.abs(xAxis) < threshold){
            xAxis = 0;
        }
        if(Math.abs(yAxis) < threshold){
            yAxis = 0;
        }
        Robot.driveSubsystem.drive(xAxis, yAxis);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if(Math.abs(controller.getRawAxis(LeftJoystickY))  < threshold  
            && Math.abs(controller.getRawAxis(RightJoystickX)) < threshold){
                return true;
        }
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        if(isFinished()){
            Robot.driveSubsystem.stop();
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {

    }
}
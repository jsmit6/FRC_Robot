package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.XBoxController;
import frc.robot.OI;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {

    private Joystick controller = OI.xboxControllerD1;

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
        double yAxis = XBoxController.leftJoystickY(controller);
        double xAxis = XBoxController.rightJoystickX(controller);
        Robot.driveSubsystem.drive(xAxis, yAxis);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return XBoxController.leftJoystickY(controller) == 0 &&
               XBoxController.rightJoystickX(controller) == 0;
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
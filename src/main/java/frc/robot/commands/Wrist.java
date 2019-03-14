package frc.robot.commands;

import static frc.robot.XBoxControllerMap.RightJoystickY;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.XBoxController;

public class Wrist extends Command {

    private Joystick controller = OI.xboxController;
    private double deadZone = 0.05;

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
        double yAxis = XBoxController.rightJoystickY(controller, deadZone);
        Robot.wristSubsystem.rotate(-yAxis / 2);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return XBoxController.rightJoystickY(controller, deadZone) == 0;
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
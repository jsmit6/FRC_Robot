package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.XBoxController;
import frc.robot.OI;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {

    private Joystick controller = OI.xboxController;
    private final double DEAD_ZONE = 0.2;

    public Drive() {
        requires(Robot.driveSubsystem);
    }

    private double getControllerXAxis(){
        return XBoxController.leftJoystickY(controller, DEAD_ZONE);
    }

    private double getControllerYAxis(){
        return XBoxController.rightJoystickX(controller, DEAD_ZONE);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double yAxis = getControllerXAxis();
        double xAxis = getControllerYAxis();
        Robot.driveSubsystem.drive(xAxis, yAxis);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return getControllerXAxis() == 0 && getControllerYAxis() == 0;
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
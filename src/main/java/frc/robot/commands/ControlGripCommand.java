package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class ControlGripCommand extends Command {

  private final GripAction action;
  public ControlGripCommand(GripAction action) {
    this.action = action;
    requires(Robot.gripSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(action == GripAction.SQUEEZE){
      Robot.gripSubsystem.squeeze();
    } else if(action == GripAction.UNSQUEEZE){
      Robot.gripSubsystem.unsqueeze();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.gripSubsystem.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

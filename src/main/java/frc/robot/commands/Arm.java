package frc.robot.commands;

import static frc.robot.XBoxControllerMap.LT;
import static frc.robot.XBoxControllerMap.RT;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class Arm extends Command {

    private Joystick controller = OI.xboxController;
    private double threshold = 0.05;

    DigitalInput upLimitSwitch = new DigitalInput(0);
    DigitalInput downLimitSwitch = new DigitalInput(1);
    Counter upCounter = new Counter(upLimitSwitch);
    Counter downCounter = new Counter(downLimitSwitch);

    public Arm() {
        requires(Robot.armSubsystem);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        initializeLimitSwitches();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double rTrigger = controller.getRawAxis(RT);
        double lTrigger = controller.getRawAxis(LT);
        //If either axes is less than threshold don't use them.
        if(Math.abs(rTrigger) < threshold || isUpSwitchSet()){
            rTrigger = 0;
        }
        if(Math.abs(lTrigger) < threshold || isDownSwitchSet()){
            lTrigger = 0;
        }
        if(lTrigger > 0 && rTrigger > 0){
            lTrigger = 0;
            rTrigger = 0;
        }
        Robot.armSubsystem.lift(rTrigger, lTrigger);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if(controller.getRawAxis(LT)  < threshold  
            && controller.getRawAxis(RT) < threshold){
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

    protected void initializeLimitSwitches(){
        upCounter.reset();
        downCounter.reset();
    }

    public boolean isUpSwitchSet() {
        return upCounter.get() > 0 || !upLimitSwitch.get();
    }

    public boolean isDownSwitchSet() {
        return downCounter.get() > 0 || !downLimitSwitch.get();
    }
}
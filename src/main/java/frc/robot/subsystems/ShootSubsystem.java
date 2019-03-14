package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Shoot;

public class ShootSubsystem extends Subsystem {

    private Spark shootMotor;
    public final boolean ENABLED;

    public ShootSubsystem(boolean enabled) {
        ENABLED = enabled;
        if(enabled){
            shootMotor = new Spark(RobotMap.shootMotorID);
            shootMotor.setInverted(false);
        }
    }

    @Override
    public void initDefaultCommand() {
        if(ENABLED){
            setDefaultCommand(new Shoot());
        }
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }

    public void output(){
        shootMotor.set(-1.0);
    }

    public void input(){
        shootMotor.set(1.0);
    }

    public void stop(){
        shootMotor.stopMotor();
    }
}
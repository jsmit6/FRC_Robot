package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

public class ShootSubsystem extends Subsystem {

    private Spark shootMotor;
    public final boolean ENABLED;

    public ShootSubsystem(boolean enabled) {
        ENABLED = enabled;
        if(enabled){
            shootMotor = new Spark(RobotMap.shootMotorID);
            shootMotor.setInverted(false);
            SmartDashboard.putString("Shoot Subsystem", "Online");
        } else {
            SmartDashboard.putString("Shoot Subsystem", "Offline");
        }
    }

    @Override
    public void initDefaultCommand() {
        
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
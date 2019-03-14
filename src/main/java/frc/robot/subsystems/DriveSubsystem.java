package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.Drive;


public class DriveSubsystem extends Subsystem {

    private SpeedControllerGroup leftMotors;
    private SpeedControllerGroup rightMotors;

    private DifferentialDrive arcadeDrive;
    public final boolean ENABLED;

    public DriveSubsystem(boolean enabled) {
        ENABLED = enabled;
        if(enabled){            
            leftMotors = RobotMap.initializeLeftMotors();
            rightMotors = RobotMap.initializeRightMotors();       

            arcadeDrive = new DifferentialDrive(leftMotors, rightMotors);
            arcadeDrive.setSafetyEnabled(false);
        }
    }

    @Override
    public void initDefaultCommand() {
        if(ENABLED){
            setDefaultCommand(new Drive());
        }
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
        RobotMap.updateAllSparks();
    }

    public void drive(double xAxis, double yAxis){
        arcadeDrive.arcadeDrive(-yAxis * Constants.Y_SPEED, xAxis * Constants.ROTATION_SPEED);
    }

    public void stop(){
        rightMotors.stopMotor();
        leftMotors.stopMotor();
    }
}
package frc.robot.subsystems;

import frc.robot.Constants;

import static frc.robot.RobotMap.frontLeftMotorID;
import static frc.robot.RobotMap.frontRightMotorID;
import static frc.robot.RobotMap.rearLeftMotorID;
import static frc.robot.RobotMap.rearRightMotorID;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.Drive;


public class DriveSubsystem extends Subsystem {


    private CANSparkMax frontLeft;
    private CANSparkMax rearLeft;
    private SpeedControllerGroup leftMotors;

    private CANSparkMax frontRight;
    private CANSparkMax rearRight;
    private SpeedControllerGroup rightMotors;

    private DifferentialDrive arcadeDrive;
    public final boolean ENABLED;

    public DriveSubsystem(boolean enabled) {
        ENABLED = enabled;
        if(enabled){
            frontLeft = new CANSparkMax(frontLeftMotorID, MotorType.kBrushless);
            frontLeft.setInverted(false);
            
            rearLeft = new CANSparkMax(rearLeftMotorID, MotorType.kBrushless);
            rearLeft.setInverted(false);
            
            leftMotors = new SpeedControllerGroup(frontLeft, rearLeft);
            
            
            frontRight = new CANSparkMax(frontRightMotorID, MotorType.kBrushless);
            frontRight.setInverted(false);
            
            rearRight = new CANSparkMax(rearRightMotorID, MotorType.kBrushless);
            rearRight.setInverted(false);
            
            rightMotors = new SpeedControllerGroup(frontRight, rearRight);        

            arcadeDrive = new DifferentialDrive(leftMotors, rightMotors);
            arcadeDrive.setSafetyEnabled(false);

            updateAllSparks(frontLeft);
            updateAllSparks(frontRight);
            updateAllSparks(rearLeft);
            updateAllSparks(rearRight);
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
        
        updateAllSparks(frontLeft);
        updateAllSparks(frontRight);
        updateAllSparks(rearLeft);
        updateAllSparks(rearRight);
    }

    public void drive(double xAxis, double yAxis){
        arcadeDrive.arcadeDrive(-yAxis * Constants.Y_SPEED, xAxis * Constants.ROTATION_SPEED);
    }

    public void stop(){
        rightMotors.stopMotor();
        leftMotors.stopMotor();
    }

    public void updateAllSparks(CANSparkMax spark) {
        spark.setSmartCurrentLimit(35);
        spark.setOpenLoopRampRate(Constants.DRIVE_RAMP_RATE_SECONDS);
        spark.setMotorType(MotorType.kBrushless);
    }

}
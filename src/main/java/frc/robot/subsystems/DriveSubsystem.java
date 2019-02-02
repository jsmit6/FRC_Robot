package frc.robot.subsystems;


import frc.robot.commands.Drive;

import com.revrobotics.CANSparkMax;
import static com.revrobotics.CANSparkMaxLowLevel.*;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class DriveSubsystem extends Subsystem {

    private CANSparkMax frontLeft;
    private CANSparkMax rearLeft;
    private SpeedControllerGroup leftMotors;

    private CANSparkMax frontRight;
    private CANSparkMax rearRight;
    private SpeedControllerGroup rightMotors;

    private DifferentialDrive arcadeDrive;


    public DriveSubsystem() {
        frontLeft = new CANSparkMax(1, MotorType.kBrushless);
        addChild("FrontLeft",(Sendable) frontLeft);
        frontLeft.setInverted(false);
        
        rearLeft = new CANSparkMax(2, MotorType.kBrushless);
        addChild("RearLeft",(Sendable) rearLeft);
        rearLeft.setInverted(false);
        
        leftMotors = new SpeedControllerGroup(frontLeft, rearLeft  );
        addChild("LeftMotors",leftMotors);
        
        
        frontRight = new CANSparkMax(3, MotorType.kBrushless);
        addChild("FrontRight",(Sendable) frontRight);
        frontRight.setInverted(false);
        
        rearRight = new CANSparkMax(4, MotorType.kBrushless);
        addChild("RearRight",(Sendable) rearRight);
        rearRight.setInverted(false);
        
        rightMotors = new SpeedControllerGroup(frontRight, rearRight  );
        addChild("RightMotors",rightMotors);
        

        arcadeDrive = new DifferentialDrive(leftMotors, rightMotors);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public void drive(double xAxis, double yAxis){
        arcadeDrive.arcadeDrive(xAxis, yAxis);
    }

    public void stop(){
        rightMotors.stopMotor();
        leftMotors.stopMotor();
    }

}
package frc.robot.subsystems;


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


    public DriveSubsystem() {
        frontLeft = new CANSparkMax(1, MotorType.kBrushless);
        frontLeft.setInverted(false);
        
        rearLeft = new CANSparkMax(2, MotorType.kBrushless);
        rearLeft.setInverted(false);
        
        leftMotors = new SpeedControllerGroup(frontLeft, rearLeft  );
        
        
        frontRight = new CANSparkMax(3, MotorType.kBrushless);
        frontRight.setInverted(false);
        
        rearRight = new CANSparkMax(4, MotorType.kBrushless);
        rearRight.setInverted(false);
        
        rightMotors = new SpeedControllerGroup(frontRight, rearRight  );        

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
        arcadeDrive.arcadeDrive(-yAxis, xAxis);
    }

    public void stop(){
        rightMotors.stopMotor();
        leftMotors.stopMotor();
    }

}
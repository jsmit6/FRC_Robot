package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;

public class DriveSubsystem extends Subsystem {

    private static CANSparkMax frontLeft;
    private static CANSparkMax rearLeft;
    private static SpeedControllerGroup leftMotors;

    private static CANSparkMax frontRight;
    private static CANSparkMax rearRight;
    private static SpeedControllerGroup rightMotors;

    private DifferentialDrive arcadeDrive;
    public final boolean ENABLED;

    public DriveSubsystem(boolean enabled) {
        ENABLED = enabled;
        if (enabled) {
            initializeLeftMotors();
            initializeRightMotors();

            arcadeDrive = new DifferentialDrive(leftMotors, rightMotors);
            arcadeDrive.setSafetyEnabled(true);
            SmartDashboard.putString("Drive Subsystem", "Online");
        }
    }

    @Override
    public void initDefaultCommand() {
        if (ENABLED) {
            setDefaultCommand(new Drive());
        }
    }

    @Override
    public void periodic() {
        updateSpark(frontLeft);
        updateSpark(frontRight);
        updateSpark(rearLeft);
        updateSpark(rearRight);
    }

    public void drive(double xAxis, double yAxis) {
        arcadeDrive.arcadeDrive(-yAxis * Constants.Y_SPEED, xAxis * Constants.ROTATION_SPEED);
    }

    public void stop() {
        rightMotors.stopMotor();
        leftMotors.stopMotor();
    }

    private SpeedControllerGroup initializeLeftMotors() {
        frontLeft = new CANSparkMax(RobotMap.frontLeftMotorID, MotorType.kBrushless);
        frontLeft.setInverted(false);

        rearLeft = new CANSparkMax(RobotMap.rearLeftMotorID, MotorType.kBrushless);
        rearLeft.setInverted(false);

        leftMotors = new SpeedControllerGroup(frontLeft, rearLeft);
        return leftMotors;
    }

    private SpeedControllerGroup initializeRightMotors() {
        frontRight = new CANSparkMax(RobotMap.frontRightMotorID, MotorType.kBrushless);
        frontRight.setInverted(false);

        rearRight = new CANSparkMax(RobotMap.rearRightMotorID, MotorType.kBrushless);
        rearRight.setInverted(false);

        rightMotors = new SpeedControllerGroup(frontRight, rearRight);
        return rightMotors;
    }

    private void updateSpark(CANSparkMax spark) {
        spark.setSmartCurrentLimit(Constants.VOLTAGE_LIMIT);
        spark.setMotorType(MotorType.kBrushless);
        //spark.setOpenLoopRampRate(Constants.RAMP_UP_VALUE);
    }
}
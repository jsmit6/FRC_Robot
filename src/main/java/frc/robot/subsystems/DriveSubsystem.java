package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
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
            arcadeDrive.setSafetyEnabled(false);
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
        updateAllSparks(frontLeft);
        updateAllSparks(frontRight);
        updateAllSparks(rearLeft);
        updateAllSparks(rearRight);
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

    private void updateAllSparks(CANSparkMax spark) {
        // spark.setSmartCurrentLimit(60);
        spark.setMotorType(MotorType.kBrushless);
    }
}
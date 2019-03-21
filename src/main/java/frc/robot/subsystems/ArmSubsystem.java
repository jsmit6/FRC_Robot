package frc.robot.subsystems;

import static frc.robot.RobotMap.armMotorID;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.Arm;

public class ArmSubsystem extends Subsystem {
    public final boolean ENABLED;

    private CANSparkMax liftMotor;
    private Potentiometer pot = new AnalogPotentiometer(RobotMap.armPotentiometer);

    private DoubleSolenoid brakeSol = new DoubleSolenoid(4, 5);
    private boolean brakeEngaged = true;

    public ArmSubsystem(boolean enabled) {
        ENABLED = enabled;
        if (enabled) {
            liftMotor = new CANSparkMax(armMotorID, MotorType.kBrushless);
            liftMotor.setSmartCurrentLimit(Constants.VOLTAGE_LIMIT);
            liftMotor.setInverted(false);
            SmartDashboard.putString("Arm Subsystem", "Online");
        } else {
            SmartDashboard.putString("Arm Subsystem", "Offline");
        }
        SmartDashboard.putBoolean("Arm Override", false);
    }

    @Override
    public void initDefaultCommand() {
        if (ENABLED) {
            setDefaultCommand(new Arm());
        }
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Arm Potentiometer", getPotValue());
    }

    private int getPotValue() {
        return (int) (pot.get() * 100);
    }

    private void unbrake() {
        brakeSol.set(Value.kReverse);
        brakeEngaged = false;
    }

    private void brake() {
        brakeSol.set(Value.kForward);
        brakeEngaged = true;
    }

    public void lift(double lTrigger, double rTrigger, boolean override) {
        int potValue = getPotValue();
        SmartDashboard.putBoolean("Arm Override", override);
        WristSubsystem wrist = Robot.wristSubsystem;
        if (brakeEngaged) {
            unbrake();
            Timer.delay(0.2);
        }
        if (!brakeEngaged) {
            if (potValue <= Constants.MIN_ARM_LOWER_POT && override
                    && potValue >= Constants.OVERRIDE_MAX_ARM_RAISE_POT) {
                wrist.rotateToPosition(Constants.WRIST_MIN_LIMIT);
                liftMotor.set(lTrigger);
            } else if (potValue >= Constants.MIN_ARM_LOWER_POT) {
                liftMotor.set(-rTrigger);
            } else {
                liftMotor.set((lTrigger - rTrigger));
            }
        }
    }

    public void stop() {
        liftMotor.stopMotor();
        brake();
    }
}
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.commands.Arm;

import static frc.robot.RobotMap.*;

public class ArmSubsystem extends Subsystem {

    private CANSparkMax liftMotor;
    public ArmSubsystem() {
        liftMotor = new CANSparkMax(armMotorID, MotorType.kBrushless);
        liftMotor.setInverted(false);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new Arm());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public void lift(double rTrigger, double lTrigger){
        liftMotor.set(rTrigger - lTrigger);
    }

    public void stop(){
        liftMotor.stopMotor();
    }
}
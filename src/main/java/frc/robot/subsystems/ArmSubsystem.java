package frc.robot.subsystems;

import static frc.robot.RobotMap.armMotorID;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.Arm;

public class ArmSubsystem extends Subsystem {
    public final boolean ENABLED;

    private CANSparkMax liftMotor;
    private Potentiometer pot = new AnalogPotentiometer(RobotMap.armPotentiometer);

    public ArmSubsystem(boolean enabled) {
        ENABLED = enabled;
        if(enabled){
            liftMotor = new CANSparkMax(armMotorID, MotorType.kBrushless);
            liftMotor.setSmartCurrentLimit(Constants.VOLTAGE_LIMIT);
            liftMotor.setInverted(false);
            SmartDashboard.putString("Arm Subsystem", "Online");
        } else {
            SmartDashboard.putString("Arm Subsystem", "Offline");
        }
    }

    @Override
    public void initDefaultCommand() {
        if(ENABLED){
            setDefaultCommand(new Arm());
        }
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public void lift(double lTrigger, double rTrigger, boolean override){
        int potValue = (int) (pot.get() * 100);
        System.out.println(potValue + " " + override);
        WristSubsystem wrist = Robot.wristSubsystem;
        
        if(potValue <= Constants.MIN_ARM_LOWER_POT && override && potValue >= Constants.OVERRIDE_MAX_ARM_RAISE_POT){
            wrist.rotateToPosition(Constants.WRIST_MIN_LIMIT);
            liftMotor.set(lTrigger);
        }else if(potValue >= Constants.MIN_ARM_LOWER_POT){
            liftMotor.set(-rTrigger);
        }else{
            liftMotor.set((lTrigger - rTrigger));
        }
    }

    public void stop(){
        liftMotor.stopMotor();
    }
}
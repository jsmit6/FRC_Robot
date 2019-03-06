package frc.robot.subsystems;

import static frc.robot.RobotMap.armMotorID;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
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
            liftMotor.setInverted(false);
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

    public void lift(double rTrigger, double lTrigger){
        int potValue = (int) (pot.get() * 100);
        System.out.println(potValue);

        if(potValue <= 11){
            // Stop lifting
        }else if(potValue >= 18){
            // Stop Lowering
        }else{
            liftMotor.set(rTrigger - lTrigger);
        }
    }

    public void stop(){
        liftMotor.stopMotor();
    }
}
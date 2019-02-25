package frc.robot.subsystems;

import static frc.robot.RobotMap.armMotorID;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Arm;

public class ArmSubsystem extends Subsystem {

    private CANSparkMax liftMotor;
    public final boolean ENABLED;
    CANEncoder encoder;

    private final int ARM_MAX_VALUE = 110;
    private final int ARM_MIN_VALUE = -1;


    public ArmSubsystem(boolean enabled) {
        ENABLED = enabled;
        if(enabled){
            liftMotor = new CANSparkMax(armMotorID, MotorType.kBrushless);
            encoder = new CANEncoder(liftMotor);
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
        double encoderOutput = encoder.getPosition();
        boolean armLifting = (rTrigger - lTrigger) < 0? false: true;

        if(encoderOutput < ARM_MIN_VALUE && !armLifting){
            System.out.println("BLOCKING LOWER " + encoderOutput + " : " + (rTrigger - lTrigger));
            liftMotor.stopMotor();
        }else if (encoderOutput >  ARM_MAX_VALUE && armLifting){
            System.out.println("BLOCKING RAISE " + encoderOutput + " : " + (rTrigger - lTrigger));
            liftMotor.stopMotor();
        }else{
            System.out.println(encoderOutput + " : " + (rTrigger - lTrigger));
            liftMotor.set(rTrigger - lTrigger);
        }
        
    }

    public void stop(){
        liftMotor.stopMotor();
    }
}
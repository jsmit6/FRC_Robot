package frc.robot.subsystems;

import static frc.robot.RobotMap.armMotorID;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

//import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.interfaces.Potentiometer;
//import frc.robot.RobotMap;
import frc.robot.commands.Arm;

public class ArmSubsystem extends Subsystem {
    public final boolean ENABLED;

    private CANSparkMax liftMotor;
    /*private Potentiometer pot = new AnalogPotentiometer(RobotMap.armPotentiometer);


    private final int MAX_ARM_RAISE_POT = 24;
    private final int MIN_ARM_LOWER_POT = 31;
    private final int OVERRIDE_MAX_ARM_RAISE_POT = 19;*/


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

    public void lift(double lTrigger, double rTrigger, boolean override){
        //int potValue = (int) (pot.get() * 100);
        //System.out.println(potValue + " " + override);
        
        /*if(potValue <= MIN_ARM_LOWER_POT && override && potValue >= OVERRIDE_MAX_ARM_RAISE_POT){
            liftMotor.set(lTrigger);
        }else if(potValue >= 31){
            // Stop Lowering
            liftMotor.set(-rTrigger);
        }else{*/
            liftMotor.set((lTrigger - rTrigger));
        //}
    }

    public void stop(){
        liftMotor.stopMotor();
    }
}
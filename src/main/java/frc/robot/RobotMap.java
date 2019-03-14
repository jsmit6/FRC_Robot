package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  /**************DRIVE SUBSYSTEM****************/

  /* Left Drive Motors */
  private static final int frontLeftMotorID = 1;
  private static final int rearLeftMotorID = 2;

  /* Right Drive Motors */
  private static final int frontRightMotorID = 3;
  private static final int rearRightMotorID = 4;

  /*************END DRIVE SUBSYSTEM**************/

  /**********ARM SUBSYSTEM*********************/

  /* Arm Motor */
  public static final int armMotorID = 5;

  /* Arm Digital Sensors */
  public static final int armUpSwitchID = 0;
  public static final int armDownSwitchID = 1;

  /* Left Grip Pneumatics */
  public static int gripForwardChannel = 0;
  public static int gripBackwardChannel = 1;

  /* Right Grip Pneumatics */
  //public static int rightGripForwardChannel = 3;
  //public static int rightGripBackwardChannel = 4;

  /************END ARM SUBSYSTEM******************/

  /**********WRIST SUBSYSTEM*******************/

  public static final int wristMotorID = 0;
  public static final int shootMotorID = 1;

  /**********END WRIST SUBSYSTEM***************/

  /**********SENSORS*******************/
  public static final int armPotentiometer = 0;
  /**********END SENSORS***************/
  

  private static CANSparkMax frontLeft;
  private static CANSparkMax rearLeft;
  private static SpeedControllerGroup leftMotors;

  private static CANSparkMax frontRight;
  private static CANSparkMax rearRight;
  private static SpeedControllerGroup rightMotors;

  public static SpeedControllerGroup initializeLeftMotors(){
    frontLeft = new CANSparkMax(frontLeftMotorID, MotorType.kBrushless);
    frontLeft.setInverted(false);
            
    rearLeft = new CANSparkMax(rearLeftMotorID, MotorType.kBrushless);
    rearLeft.setInverted(false);
            
    leftMotors = new SpeedControllerGroup(frontLeft, rearLeft);
    return leftMotors;
  }

  public static SpeedControllerGroup initializeRightMotors(){
    frontRight = new CANSparkMax(frontRightMotorID, MotorType.kBrushless);
    frontRight.setInverted(false);
            
    rearRight = new CANSparkMax(rearRightMotorID, MotorType.kBrushless);
    rearRight.setInverted(false);
            
    rightMotors = new SpeedControllerGroup(frontRight, rearRight);   
    return rightMotors;
  }

  public static void updateAllSparks() {
    updateAllSparks(frontLeft);
    updateAllSparks(frontRight);
    updateAllSparks(rearLeft);
    updateAllSparks(rearRight);
  }

  private static void updateAllSparks(CANSparkMax spark){
    //spark.setSmartCurrentLimit(60);
    spark.setMotorType(MotorType.kBrushless);

  }
}

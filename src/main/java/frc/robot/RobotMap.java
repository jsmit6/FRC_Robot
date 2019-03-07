package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  /**************DRIVE SUBSYSTEM****************/

  /* Left Drive Motors */
  public static final int frontLeftMotorID = 1;
  public static final int rearLeftMotorID = 2;

  /* Right Drive Motors */
  public static final int frontRightMotorID = 3;
  public static final int rearRightMotorID = 4;

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
}

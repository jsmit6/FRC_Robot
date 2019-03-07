package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ControlGripCommand;
import frc.robot.commands.GripAction;
public class OI {
  

  public static Joystick xboxControllerD1;

  public static JoystickButton squeezeGripButton;
  public static JoystickButton unsqueezeGripButton;

  public OI(){
    xboxControllerD1 = new Joystick(0);
    //xboxController = new Joystick(1);

    if(Robot.gripSubsystem.ENABLED){
      squeezeGripButton = new JoystickButton(xboxControllerD1, XBoxControllerMap.LB);
      squeezeGripButton.whenPressed(new ControlGripCommand(GripAction.SQUEEZE));

      unsqueezeGripButton = new JoystickButton(xboxControllerD1, XBoxControllerMap.RB);
      unsqueezeGripButton.whenPressed(new ControlGripCommand(GripAction.UNSQUEEZE));
    }
  }
}

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ControlGripCommand;
import frc.robot.commands.GripAction;
public class OI {
  

  public static Joystick xboxController;

  public static JoystickButton squeezeGripButton;
  public static JoystickButton unsqueezeGripButton;

  public OI(){
    xboxController = new Joystick(0);

    if(Robot.gripSubsystem.ENABLED){
      squeezeGripButton = new JoystickButton(xboxController, XBoxControllerMap.LB);
      squeezeGripButton.whenPressed(new ControlGripCommand(GripAction.SQUEEZE));

      unsqueezeGripButton = new JoystickButton(xboxController, XBoxControllerMap.RB);
      unsqueezeGripButton.whenPressed(new ControlGripCommand(GripAction.UNSQUEEZE));
    }
  }
}

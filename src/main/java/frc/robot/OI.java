package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.ControlGripCommand;
import frc.robot.commands.EjectCommand;
import frc.robot.commands.GripAction;
import frc.robot.commands.PickupCommand;
import frc.robot.commands.SpitoutCommand;

public class OI {

  public static Joystick xboxController;

  public static JoystickButton squeezeGripButton;
  public static JoystickButton unsqueezeGripButton;

  public static JoystickButton pickupButton;
  public static JoystickButton spitOutButton;

  public static JoystickButton toggleEjectButton;

  private final Command ejectCommand = new EjectCommand();

  public OI() {
    xboxController = new Joystick(0);

    if (Robot.gripSubsystem.ENABLED) {
      squeezeGripButton = new JoystickButton(xboxController, XBoxControllerMap.BACK);
      squeezeGripButton.whenPressed(new ControlGripCommand(GripAction.SQUEEZE));

      unsqueezeGripButton = new JoystickButton(xboxController, XBoxControllerMap.START);
      unsqueezeGripButton.whenPressed(new ControlGripCommand(GripAction.UNSQUEEZE));
    }

    pickupButton = new JoystickButton(xboxController, XBoxControllerMap.Y);
    pickupButton.whileHeld(new PickupCommand());

    spitOutButton = new JoystickButton(xboxController, XBoxControllerMap.A);
    spitOutButton.whileHeld(new SpitoutCommand());

    toggleEjectButton = new JoystickButton(xboxController, XBoxControllerMap.B);
    toggleEjectButton.whenPressed(ejectCommand);

  }
}

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.XBoxControllerMap;

public class XBoxController {
    public static double leftJoystickY(Joystick controller, double deadZone){
        double yValue = controller.getRawAxis(XBoxControllerMap.LeftJoystickY);
        if(Math.abs(yValue) > deadZone){
            return yValue;
        }
        return 0;
    }

    public static double leftJoystickX(Joystick controller, double deadZone){
        double xValue = controller.getRawAxis(XBoxControllerMap.LeftJoystickX);
        if(Math.abs(xValue) > deadZone){
            return xValue;
        }
        return 0;
    }

    public static double rightJoystickY(Joystick controller, double deadZone){
        double yValue = controller.getRawAxis(XBoxControllerMap.RightJoystickY);
        if(Math.abs(yValue) > deadZone){
            return yValue;
        }
        return 0;
    }

    public static double rightJoystickX(Joystick controller, double deadZone){
        double xValue = controller.getRawAxis(XBoxControllerMap.RightJoystickX);
        if(Math.abs(xValue) > deadZone){
            return xValue;
        }
        return 0;
    }
}
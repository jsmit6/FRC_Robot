package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.XBoxControllerMap;

public class XBoxController {
    public static final double DEAD_ZONE = 0.2;

    public static double leftJoystickY(Joystick controller){
        double yValue = controller.getRawAxis(XBoxControllerMap.LeftJoystickY);
        if(Math.abs(yValue) > DEAD_ZONE){
            return yValue;
        }
        return 0;
    }

    public static double leftJoystickX(Joystick controller){
        double xValue = controller.getRawAxis(XBoxControllerMap.LeftJoystickX);
        if(Math.abs(xValue) > DEAD_ZONE){
            return xValue;
        }
        return 0;
    }

    public static double rightJoystickY(Joystick controller){
        double yValue = controller.getRawAxis(XBoxControllerMap.RightJoystickY);
        if(Math.abs(yValue) > DEAD_ZONE){
            return yValue;
        }
        return 0;
    }

    public static double rightJoystickX(Joystick controller){
        double xValue = controller.getRawAxis(XBoxControllerMap.RightJoystickX);
        if(Math.abs(xValue) > DEAD_ZONE){
            return xValue;
        }
        return 0;
    }
}
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.XBoxControllerMap;

public class XBoxController {

    public static double leftJoystickY(Joystick controller, double deadZone) {
        double yValue = controller.getRawAxis(XBoxControllerMap.LeftJoystickY);
        return deadZoneCheck(yValue, deadZone);
    }

    public static double leftJoystickX(Joystick controller, double deadZone) {
        double xValue = controller.getRawAxis(XBoxControllerMap.LeftJoystickX);
        return deadZoneCheck(xValue, deadZone);
    }

    public static double rightJoystickY(Joystick controller, double deadZone) {
        double yValue = controller.getRawAxis(XBoxControllerMap.RightJoystickY);
        return deadZoneCheck(yValue, deadZone);
    }

    public static double rightJoystickX(Joystick controller, double deadZone) {
        double xValue = controller.getRawAxis(XBoxControllerMap.RightJoystickX);
        return deadZoneCheck(xValue, deadZone);
    }

    public static double RT(Joystick controller, double deadZone) {
        double rtValue = controller.getRawAxis(XBoxControllerMap.RT);
        return deadZoneCheck(rtValue, deadZone);
    }

    public static double LT(Joystick controller, double deadZone) {
        double ltValue = controller.getRawAxis(XBoxControllerMap.LT);
        return deadZoneCheck(ltValue, deadZone);
    }

    private static double deadZoneCheck(double value, double deadZone) {
        return Math.abs(value) > deadZone ? value : 0;
    }
}
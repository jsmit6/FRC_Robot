package frc.robot;

public interface PlaystationControllerMap{
    //Digital Controls
    public static final int TRIANGLE = 1;
    public static final int CIRCLE = 2;
    public static final int X = 3;
    public static final int SQUARE = 4;

    public static final int L1 = 5;
    public static final int R1 = 6;

    public static final int L2 = 7;
    public static final int R2 = 8;

    public static final int SELECT = 9;
    public static final int START = 10;

    public static final int L3 = 11;
    public static final int R3 = 12;

    //Analog Controls
    public static final int LeftJoystickX = 0;
    public static final int LeftJoystickY = 1;
    
    public static final int RightJoystickX = 2;
    public static final int RightJoystickY = 3;

    //POV Directions
	public static final int NORTH = 0;
	public static final int NORTHEAST = 45;
	public static final int EAST = 90;
	public static final int SOUTHEAST = 135;
	public static final int SOUTH = 180;
	public static final int SOUTHWEST = 225;
	public static final int WEST = 270;
	public static final int NORTHWEST = 315;
}
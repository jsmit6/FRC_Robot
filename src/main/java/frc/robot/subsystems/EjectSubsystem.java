/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class EjectSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private boolean isEjected = false;
  private DoubleSolenoid eject = new DoubleSolenoid(RobotMap.ejectForwardChannel, RobotMap.ejectReverseChannel);

  public EjectSubsystem() {
    eject.set(Value.kReverse);
    isEjected = false;
    SmartDashboard.putString("Eject Subsystem", "Online");
    SmartDashboard.putBoolean("Ejectocito Cuz", isEjected);
  }

  @Override
  public void periodic() {
  }

  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new EjectCommand());
  }

  public void toggleSystem() {
    if (isEjected) {
      eject.set(Value.kReverse);
      isEjected = false;
    } else {
      eject.set(Value.kForward);
      isEjected = true;
    }
    SmartDashboard.putBoolean("Ejectocito Cuz", isEjected);
  }
}

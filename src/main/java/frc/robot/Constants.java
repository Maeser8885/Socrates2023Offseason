// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class MotorConstants{
    public static final int kfrMotorPort = 0;
    public static final int kflMotorPort = 1;
    public static final int kbrMotorPort = 2;
    public static final int kblMotorPort = 3;
  }

  //TODO Change these 
  public static class AutonomousConstants{
    public static final double kWaitBetweenCommands = 1.0;
    public static final double kMaxSpeed = 1.0;
  }

  public static class RotationConstants{
    public static final double kDegTimeRatio = 1.0;
    public static double kRotationSpeed = 1.0;
  }
}

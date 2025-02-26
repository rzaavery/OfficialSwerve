package frc.robot;

import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import frc.lib.configs.SwerveModuleConstants;

//test commit

public final class Constants {

  public static final class Swerve {
    public static final double stickDeadband = 0.1;

    public static final int pigeonID = 14;
    public static final boolean invertGyro = false; // Always ensure Gyro is CCW+ CW-

    /* Drivetrain Constants */
    public static final double trackWidth = Units.inchesToMeters(21.73);
    public static final double wheelBase = Units.inchesToMeters(21.73);
    public static final double wheelDiameter = Units.inchesToMeters(4.0);
    public static final double wheelCircumference = wheelDiameter * Math.PI;

    public static final double openLoopRamp = 0.25;
    public static final double closedLoopRamp = 0.0;

    public static final double driveGearRatio = (6.75 / 1.0); // 6.75:1
    public static final double angleGearRatio = (12.8 / 1.0); // 12.8:1

    public static final SwerveDriveKinematics swerveKinematics =
        new SwerveDriveKinematics(
            new Translation2d(wheelBase / 2.0, trackWidth / 2.0),
            new Translation2d(wheelBase / 2.0, -trackWidth / 2.0),
            new Translation2d(-wheelBase / 2.0, trackWidth / 2.0),
            new Translation2d(-wheelBase / 2.0, -trackWidth / 2.0));

    /* Swerve Voltage Compensation */
    public static final double voltageComp = 12.0;

    /* Swerve Current Limiting */
    public static final int angleContinuousCurrentLimit = 20;
    public static final int driveContinuousCurrentLimit = 80;

    /* Angle Motor PID Values */
    public static final double angleKP = 0.01;
    public static final double angleKI = 0.0;
    public static final double angleKD = 0.0;
    public static final double angleKFF = 0.0;

    /* Drive Motor PID Values */
    public static final double driveKP = 0.1;
    public static final double driveKI = 0.0;
    public static final double driveKD = 0.0;
    public static final double driveKFF = 0.0;

    /* Drive Motor Characterization Values */
    public static final double driveKS = 0.667;
    public static final double driveKV = 2.44;
    public static final double driveKA = 0.27;

    /* Drive Motor Conversion Factors */
    public static final double driveConversionPositionFactor =
        (wheelDiameter * Math.PI) / driveGearRatio;
    public static final double driveConversionVelocityFactor = driveConversionPositionFactor / 60.0;
    public static final double angleConversionFactor = 360.0 / angleGearRatio;

    /* Swerve Profiling Values */
    public static final double maxSpeed = 4.5; // meters per second
    public static final double maxAngularVelocity = 11.5;

    /* Neutral Modes */
    public static final IdleMode angleNeutralMode = IdleMode.kBrake;
    public static final IdleMode driveNeutralMode = IdleMode.kBrake;

    /* Motor Inverts */
    public static final boolean driveInvert = false;
    public static final boolean angleInvert = false;

    /* Angle Encoder Invert */
    public static final boolean canCoderInvert = false;

    /* Module Specific Constants */
    /* Front Left Module - Module 0 */
    public static final class Mod0 {
      public static final int driveMotorID = 1;
      public static final int angleMotorID = 2;
      public static final int canCoderID = 10;
      public static final double MagnetOffset = -0.52001953125;
      public static final double angleOffset = -90;
      public static final SwerveModuleConstants constants =
          new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, MagnetOffset, angleOffset);
    }

    /* Front Right Module - Module 1 */
    public static final class Mod1 {
      public static final int driveMotorID = 3;
      public static final int angleMotorID = 4;
      public static final int canCoderID = 12;
      public static final double MagnetOffset = 0.347900390625;
      public static final double angleOffset = 0;
      public static final SwerveModuleConstants constants =
          new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, MagnetOffset, angleOffset);
    }

    /* Back Left Module - Module 2 */
    public static final class Mod2 {
      public static final int driveMotorID = 5;
      public static final int angleMotorID = 6;
      public static final int canCoderID = 13;
      public static final double MagnetOffset = -0.980712890625;
      public static final double angleOffset = 180;
      public static final SwerveModuleConstants constants =
          new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, MagnetOffset, angleOffset);
    }

    /* Back Right Module - Module 3 */
    public static final class Mod3 {
      public static final int driveMotorID = 7;
      public static final int angleMotorID = 8;
      public static final int canCoderID = 11;
      public static final double MagnetOffset = -0.060546875;
      public static final double angleOffset = 90;
      public static final SwerveModuleConstants constants =
          new SwerveModuleConstants(driveMotorID, angleMotorID, canCoderID, MagnetOffset, angleOffset);
    }
  }

  public static final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;
    public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
    public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;

    public static final double kPXController = 1;
    public static final double kPYController = 1;
    public static final double kPThetaController = 1;

    // Constraint for the motion profilied robot angle controller
    public static final TrapezoidProfile.Constraints kThetaControllerConstraints =
        new TrapezoidProfile.Constraints(
            kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
  }

  public static final class DrivingConstants{
    public static final int driverPort = 0;
  }

  public static final class OperatingConstants{
    public static final int OperatingPort = 1;
  }

  public static final class CANPort{
    public static final int LeftLiftPort = 15;
    public static final int RightLiftPort = 16;
    public static final int ElevationPort = 17;
    public static final int SpinnerPort = 18;
    public static final int WenchPort = 19;
    public static final int ElevatorPort = 20;
    public static final int FlippyPort = 21;
  }

  public static final class PWMPort{
    public static final int LeftIntakePort = 0;
    public static final int RightIntakePort = 1;
    public static final int ExtensionPort = 2;
  }

  public static final class StringPotLimits{
    public static final double LeftLiftMin = 0;
    public static final double LeftLiftMax = 0;
    public static final double RightLiftMin = 0;
    public static final double RightLiftMax = 0;
    public static final double ElevationMin = 0;
    public static final double ElevationMax = 0;
    public static final double WenchMin = 0;
    public static final double WenchMax = 0;
    public static final double ElevatorMin = 0;
    public static final double ElevatorMax = 0;
    public static final double ExtensionMin = 0;
    public static final double ExtensionMax = 0;
    public static final double FlippyMin = 0;
    public static final double FlippyMax = 0;
  }

  static AnalogPotentiometer LeftLiftPot = new AnalogPotentiometer(0);
  static AnalogPotentiometer RightLiftPot = new AnalogPotentiometer(1);
  static AnalogPotentiometer ElevationPot = new AnalogPotentiometer(2);
  static AnalogPotentiometer WenchPot = new AnalogPotentiometer(3);
  static AnalogPotentiometer ElevatorPot = new AnalogPotentiometer(4);
  static AnalogPotentiometer ExtensionPot = new AnalogPotentiometer(5);
  static AnalogPotentiometer FlippyPot = new AnalogPotentiometer(6);

  public static double StringPot(int PotID){
    double potValue = 0;

    switch(PotID){
      case 0:
        potValue = LeftLiftPot.get();
      break;
      case 1:
        potValue = RightLiftPot.get();
      break;
      case 2:
        potValue = ElevationPot.get();
      break;
      case 3:
        potValue = WenchPot.get();
      break;
      case 4:
        potValue = ElevatorPot.get();
      break;
      case 5:
        potValue = ExtensionPot.get();
      break;
      case 6:
        potValue = FlippyPot.get();
      break;
    }
    return potValue;
  }

  public static double SPDif(int PotID, double targetValue){
    return(targetValue - StringPot(PotID));
  }
}

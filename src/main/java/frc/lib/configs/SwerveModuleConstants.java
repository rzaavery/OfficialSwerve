package frc.lib.configs;

import edu.wpi.first.math.geometry.Rotation2d;

public class SwerveModuleConstants {
  public final int driveMotorID;
  public final int angleMotorID;
  public final int cancoderID;
  public final double angleOffset;
  public final double MagnetOffset;

  /**
   * Swerve Module Constants to be used when creating swerve modules.
   *
   * @param driveMotorID
   * @param angleMotorID
   * @param canCoderID
   * @param MagnetOffset
   * @param angleOffset
   */
  public SwerveModuleConstants(
      int driveMotorID, int angleMotorID, int canCoderID, double MagnetOffset, double angleOffset) {
    this.driveMotorID = driveMotorID;
    this.angleMotorID = angleMotorID;
    this.cancoderID = canCoderID;
    this.MagnetOffset = MagnetOffset;
    this.angleOffset = angleOffset;
  }
}

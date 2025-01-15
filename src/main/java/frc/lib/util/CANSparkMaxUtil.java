package frc.lib.util;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel;
import com.ctre.phoenix6.hardware.core.*;
import frc.robot.CTREConfigs;
import frc.robot.Robot;

/** Sets motor usage for a Spark Max motor controller */
public class CANSparkMaxUtil {
  public enum Usage {
    kAll,
    kPositionOnly,
    kVelocityOnly,
    kMinimal
  };

  /**
   * This function allows reducing a Spark Max's CAN bus utilization by reducing the periodic status
   * frame period of nonessential frames from 20ms to 500ms.
   *
   * <p>See
   * https://docs.revrobotics.com/sparkmax/operating-modes/control-interfaces#periodic-status-frames
   * for a description of the status frames.
   *
   * @param motor The motor to adjust the status frame periods on.
   * @param usage The status frame feedack to enable. kAll is the default when a CANSparkMax is
   *     constructed.
   * @param enableFollowing Whether to enable motor following.
   */
  public static void setCANSparkMaxBusUsage(
      SparkMax motor, Usage usage, boolean enableFollowing) {
    if (enableFollowing) {
      Robot.ctreConfigs.config.signals.primaryEncoderPositionPeriodMs(10);
      motor.configure(Robot.ctreConfigs.config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
    } else {
      Robot.ctreConfigs.config.signals.primaryEncoderPositionPeriodMs(500);
      motor.configure(Robot.ctreConfigs.config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    if (usage == Usage.kAll) {
      Robot.ctreConfigs.config.signals
        .primaryEncoderVelocityPeriodMs(20)
        .primaryEncoderPositionPeriodMs(20)
        .analogVoltagePeriodMs(50);

    } else if (usage == Usage.kPositionOnly) {
      Robot.ctreConfigs.config.signals
        .primaryEncoderVelocityPeriodMs(500)
        .primaryEncoderPositionPeriodMs(20)
        .analogVoltagePeriodMs(500);

    } else if (usage == Usage.kVelocityOnly) {
      Robot.ctreConfigs.config.signals
        .primaryEncoderVelocityPeriodMs(20)
        .primaryEncoderPositionPeriodMs(500)
        .analogVoltagePeriodMs(500);
    } else if (usage == Usage.kMinimal) {
      Robot.ctreConfigs.config.signals
        .primaryEncoderVelocityPeriodMs(500)
        .primaryEncoderPositionPeriodMs(500)
        .analogVoltagePeriodMs(500);
    }
  }

  /**
   * This function allows reducing a Spark Max's CAN bus utilization by reducing the periodic status
   * frame period of nonessential frames from 20ms to 500ms.
   *
   * <p>See
   * https://docs.revrobotics.com/sparkmax/operating-modes/control-interfaces#periodic-status-frames
   * for a description of the status frames.
   *
   * @param motor The motor to adjust the status frame periods on.
   * @param usage The status frame feedack to enable. kAll is the default when a CANSparkMax is
   *     constructed.
   */
  public static void setCANSparkMaxBusUsage(SparkMax motor, Usage usage) {
    setCANSparkMaxBusUsage(motor, usage, false);
  }
}

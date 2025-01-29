package frc.robot;


//import com.ctre.phoenix6.sensors.AbsoluteSensorRange;
//import com.ctre.phoenix6.sensors.SensorInitializationStrategy;
//import com.ctre.phoenix6.sensors.SensorTimeBase;
import com.ctre.phoenix6.signals.SensorDirectionValue;
import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.revrobotics.spark.config.SparkMaxConfig;

public class CTREConfigs {
    public CANcoderConfiguration swerveCANcoderConfig;
    public SparkMaxConfig config;

    public CTREConfigs(){
        swerveCANcoderConfig = new CANcoderConfiguration();
        config = new SparkMaxConfig();
        /** Swerve CANCoder Configuration */
        swerveCANcoderConfig.MagnetSensor.SensorDirection = SensorDirectionValue.CounterClockwise_Positive;
        
        //swerveCanCoderConfig.absoluteSensorRange = AbsoluteSensorRange.Unsigned_0_to_360;
        //swerveCanCoderConfig.initializationStrategy =
            //SensorInitializationStrategy.BootToAbsolutePosition;
        //swerveCanCoderConfig.sensorTimeBase = SensorTimeBase.PerSecond;
    }
}

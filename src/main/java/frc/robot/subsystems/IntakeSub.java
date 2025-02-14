package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSub extends SubsystemBase{
    private final static Talon LeftIntake = new Talon(Constants.PWMPort.LeftIntakePort);
    private final static Talon RightIntake = new Talon(Constants.PWMPort.RightIntakePort);
    private final static SparkMax Spinner = new SparkMax(Constants.CANPort.SpinnerPort, MotorType.kBrushed);
    
    public static void runMotor(int motorNumber, double incomingPower){
        switch(motorNumber){
            case 0:
                LeftIntake.set(-incomingPower);
                RightIntake.set(incomingPower);
            break;
            case 2:
                Spinner.set(incomingPower);
            break;
        }
    }
}
package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkLowLevel;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.Arm;
import frc.robot.Constants;

public class ArmSub extends SubsystemBase {
    //Wolverine = ; Prof = ; Storm = ; Rogue = ;
    public static boolean autoComplete = false;
    private static double m_axisOutput = RobotContainer.sendAxisValue(0, 2);
    //private final static SparkMax Wolverine = new SparkMax(Constants.Swerve.WolvePort, MotorType.kBrushless);
    private final static SparkMax Prof = new SparkMax(Constants.Swerve.ProfPort, MotorType.kBrushless);
    //private final static SparkMax Storm = new SparkMax(Constants.Swerve.StormPort, MotorType.kBrushless);
    //private final static CANSparkMax Rogue = new CANSparkMax(Constants.Swerve.RoguePort);

    public static boolean liftStringPot(double incomingPower){
        if ((m_axisOutput > 0.01)&&(m_axisOutput < 0.07)){
            Prof.set(RobotContainer.sendAxisValue(0, 2));
            autoComplete = true;
        }
        else{
            Prof.set(0);
        }
        return autoComplete;
    }

    public static boolean algaeStringPot(double incomingPower){
        if((incomingPower < Constants.Swerve.StringPotMin) && (incomingPower > Constants.Swerve.StringPotMax)){
            //Wolverine.set(incomingPower);
            //Storm.set(incomingPower);
            autoComplete = true;
        }
        return autoComplete;
    }
    /* 
    public static boolean runMotor(double incomingPower) {
        if((incomingPower < Constants.Swerve.StringPotMin) && (incomingPower > Constants.Swerve.StringPotMax)){
            Wolverine.set(incomingPower);
            Prof.set(incomingPower);
            Storm.set(incomingPower);
            //Rogue.set(incomingPower);

            autoComplete = true;
        }
        else{
            SmartDashboard.putString("StringPot Return","Sorry that power is not allowed...");
        }
        return autoComplete;
    } */
}
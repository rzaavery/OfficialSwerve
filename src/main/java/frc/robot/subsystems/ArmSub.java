package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkLowLevel;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.Arm;

public class ArmSub extends SubsystemBase {
    //Wolverine = ; Prof = ; Storm = ; Rogue = ;
    public static boolean autoComplete = false;
    private final static SparkMax Wolverine = new SparkMax(Constants.Swerve.WolvePort, MotorType.kBrushless);
    private final static SparkMax Prof = new SparkMax(Constants.Swerve.ProfPort, MotorType.kBrushless);
    private final static SparkMax Storm = new SparkMax(Constants.Swerve.StormPort, MotorType.kBrushless);
    private final static SparkMax Rogue = new SparkMax(Constants.Swerve.RoguePort, MotorType.kBrushless);

    public static boolean runMotor(int StormNumber, double incomingPower) {
        if((incomingPower < Constants.Swerve.StringPotMin) && (incomingPower > Constants.Swerve.StringPotMax)){
            Wolverine.set(incomingPower);
            Prof.set(incomingPower);
            Storm.set(incomingPower);
            Rogue.set(incomingPower);

            autoComplete = true;
        }
        else{
            SmartDashboard.putString("StringPot Return","Sorry that power is not allowed...");
        }
        return autoComplete;
    }
}
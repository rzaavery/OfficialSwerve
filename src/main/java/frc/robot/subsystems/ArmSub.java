package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkLowLevel;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.Arm;

public class ArmSub extends SubsystemBase {
    //Wolverine = ; Prof = ; Storm = ; Rogue = ;
    public static boolean autoComplete = false;
    private final static CANSparkMax Wolverine = new CANSparkMax(Constants.Swerve.WolvePort);
    private final static CANSparkMax Prof = new CANSparkMax(Constants.Swerve.ProfPort);
    private final static CANSparkMax Storm = new CANSparkMax(Constants.Swerve.StormPort);
    private final static CANSparkMax Rogue = new CANSparkMax(Constants.Swerve.RoguePort);

    public static boolean runMotor(int StormNumber, double incomingPower) {
        if((this.incomingPower < Constants.Swerve.StringPotMin) && (this.incomingPower > Constants.Swerve.StringPotMax)){
            Wolverine.set(this.incomingPower);
            Prof.set(this.incomingPower);
            Storm.set(this.incomingPower);
            Rogue.set(this.incomingPower);

            autoComplete = true;
        }
        else{
            SmartDashboard.putString("StringPot Return","Sorry that power is not allowed...");
        }
        return autoComplete;
    } */
}
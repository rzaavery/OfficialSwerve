package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSub;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Arm extends CommandBase{
    private final ArmSub localArmSub;
    public static boolean limitStatus = false;
    
    public Arm(ArmSub incomingSub){
        localArmSub = incomingSub;
        addRequirements(localArmSub);
    }

    public void initialize(){
        limitStatus=false;
        localArmSub.autoComplete=false;
    }

    public void execute(){
        localArmSub.runMotor();
    }

    @Override
    public void end(boolean isFinished){}

    @Override
    public boolean isFinished(){
        return false;
    }
}
package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmSub;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Arm extends Command{
    private final ArmSub localArmSub;
    public static boolean limitStatus = false;
    private final int m_type;
    
    public Arm(ArmSub incomingSub, int type){
        localArmSub = incomingSub;
        addRequirements(localArmSub);
        m_type = type;    
    }

    public void initialize(){
        limitStatus=false;
        localArmSub.autoComplete=false;
    }

    @Override 
    public void execute(){
        //arbitrary nums for stormnumber and incomingpower
        localArmSub.runMotor(1,1);
    }

    @Override
    public void end(boolean isFinished){}

    @Override
    public boolean isFinished(){
        return false;
    }
}
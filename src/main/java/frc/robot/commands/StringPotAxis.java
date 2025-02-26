package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.StringPotSub;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class StringPotAxis extends Command{
    private final StringPotSub localStringPotSub;
    private final String type;
    
    public StringPotAxis(StringPotSub incomingSub, String type){
        localStringPotSub = incomingSub;
        addRequirements(localStringPotSub);
        this.type = type;
    }

    public void initialize(){
        localStringPotSub.autoComplete=false;
    }

    @Override 
    public void execute(){
        //localArmSub.runMotor();
        //Motor Number 0: Prof
        /*if (type == "Elevation"){
            localStringPotSub.runMotorAxis(Constants.StringPotLimits.ElevationMin,Constants.StringPotLimits.ElevationMax,0);
        }*/
        /*else if (type == "Wench"){
            localStringPotSub.runMotorAxis(Constants.StringPotLimits.WenchMin, Constants.StringPotLimits.WenchMax, 1);
        }*/
        if (type == "Elevator"){
            localStringPotSub.runMotorAxis(Constants.StringPotLimits.ElevatorMin, Constants.StringPotLimits.ElevatorMax, 2);
        }
        /*else if (type == "Flippy"){
            localStringPotSub.runMotorAxis(Constants.StringPotLimits.FlippyMin, Constants.StringPotLimits.FlippyMax, 3);
        }*/
        if (type == "Extension") {
            localStringPotSub.runMotorAxis(Constants. StringPotLimits.ExtensionMin, Constants.StringPotLimits.ExtensionMax, 3);
        }
    }

    @Override
    public void end(boolean isFinished){}

    @Override
    public boolean isFinished(){
        return false;
    }
}
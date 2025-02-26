package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.StringPotSub;

public class StringPotButton extends Command{
    private final StringPotSub localStringPotSub;
    private final double incomingPower;
    private final String type;

    public StringPotButton(StringPotSub StringPotSub, double incomingPower, String type){
        localStringPotSub = StringPotSub;
        addRequirements(localStringPotSub);
        this.incomingPower = incomingPower;
        this.type = type;
    } 

    public void initialize(){}
    
    @Override 
    public void execute(){
        //Motor Number 0: Rogue
        if (type == "Lift"){
            localStringPotSub.runMotorButton(Constants.StringPotLimits.LeftLiftMin,Constants.StringPotLimits.LeftLiftMax,0,incomingPower);
        }
        else if (type == "Elevator"){
            localStringPotSub.runMotorButton(Constants.StringPotLimits.ElevatorMin, Constants.StringPotLimits.ElevatorMax, 1, incomingPower);
        }
        else if (type == "Flippy"){
            localStringPotSub.runMotorButton(Constants.StringPotLimits.FlippyMin, Constants.StringPotLimits.FlippyMax, 2, incomingPower);
        }
    }

    @Override
    public void end(boolean isFinished){
        if (type == "Lift"){
            localStringPotSub.runMotorButton(Constants.StringPotLimits.LeftLiftMin,Constants.StringPotLimits.LeftLiftMax,0,0);
        }
        else if (type == "Elevator"){
            localStringPotSub.runMotorButton(Constants.StringPotLimits.ElevatorMin, Constants.StringPotLimits.ElevatorMax, 1, 0);
        }
        else if (type == "Flippy"){
            localStringPotSub.runMotorButton(Constants.StringPotLimits.FlippyMin, Constants.StringPotLimits.FlippyMax, 2, 0);
        }
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}

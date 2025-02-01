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
        if (type == "Left Lift"){
            StringPotSub.runMotorButton(Constants.StringPotLimits.LeftLiftMin,Constants.StringPotLimits.LeftLiftMax,0,incomingPower);
        }
        else if (type == "Right Lift"){
            StringPotSub.runMotorButton(Constants.StringPotLimits.RightLiftMin, Constants.StringPotLimits.RightLiftMax, 1, incomingPower);
        }
        else if (type == "Elevator"){
            StringPotSub.runMotorButton(Constants.StringPotLimits.ElevatorMin, Constants.StringPotLimits.ElevatorMax, 2, incomingPower);
        }
        else if (type == "Flippy"){
            StringPotSub.runMotorButton(Constants.StringPotLimits.FlippyMin, Constants.StringPotLimits.FlippyMax, 3, incomingPower);
        }
    }

    @Override
    public void end(boolean isFinished){}

    @Override
    public boolean isFinished(){
        return false;
    }
}

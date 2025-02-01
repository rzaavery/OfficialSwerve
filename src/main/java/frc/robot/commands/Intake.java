package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSub;
import frc.robot.subsystems.StringPotSub;

public class Intake extends Command{
    private final IntakeSub localIntakeSub;
    private final String type;
    private final double incomingPower;
    
    public Intake(IntakeSub localIntakeSub, double incomingPower, String type){
        this.localIntakeSub = localIntakeSub;
        addRequirements(localIntakeSub);
        this.type = type;
        this.incomingPower = incomingPower;
    }

    public void initialize(){}

    @Override 
    public void execute(){
        if (type == "Left Intake"){
            IntakeSub.runMotor(0,incomingPower);
        }
        else if (type == "Right Intake"){
            IntakeSub.runMotor(1,incomingPower);
        }
        else if (type == "Spinner"){
            IntakeSub.runMotor(2, incomingPower);
        }
    }

    @Override
    public void end(boolean isFinished){}

    @Override
    public boolean isFinished(){
        return false;
    }
}

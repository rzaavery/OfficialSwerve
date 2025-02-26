package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSub;

public class EndSpinner extends Command{
    private IntakeSub intakeSub;
    private double incomingPower;

    public EndSpinner(IntakeSub intakeSub, double incomingPower){
        this.intakeSub = intakeSub;
        this.incomingPower = incomingPower;
    }

    public void initialize(){}

    @Override
    public void execute(){
        
        if (RobotContainer.m_sensor.get()) {
            intakeSub.runMotor(2,0);
        }
        
        /*if (RobotContainer.m_sensor.get() == false){
            intakeSub.runMotor(2, incomingPower);
        }
        else {
            intakeSub.runMotor(2, 0);

            isFinished();
        }*/
    }

    @Override
    public void end(boolean isFinished){
        IntakeSub.runMotor(2, 0);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}

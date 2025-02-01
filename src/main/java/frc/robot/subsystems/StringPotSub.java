package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkLowLevel;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.StringPotAxis;
import frc.robot.Constants;

public class StringPotSub extends SubsystemBase {
    //Wolverine = ; Prof = 1; Storm = ; Rogue = ;
    public static boolean autoComplete = false;
    //private final static SparkMax Wolverine = new SparkMax(Constants.Swerve.WolvePort, MotorType.kBrushless);
    private final static SparkMax LeftLift = new SparkMax(Constants.CANPort.LeftLiftPort, MotorType.kBrushless);
    private final static SparkMax RightLift = new SparkMax(Constants.CANPort.RightLiftPort, MotorType.kBrushless);
    private final static SparkMax Elevation = new SparkMax(Constants.CANPort.ElevationPort, MotorType.kBrushless);
    private final static SparkMax Wench = new SparkMax(Constants.CANPort.WenchPort, MotorType.kBrushless);
    private final static SparkMax Elevator = new SparkMax(Constants.CANPort.ElevatorPort, MotorType.kBrushless);
    private final static SparkMax Flippy = new SparkMax(Constants.CANPort.FlippyPort, MotorType.kBrushless);
    private final static Talon Extension = new Talon(Constants.PWMPort.ExtensionPort);


    public static void runMotorAxis(double min, double max, int motorNumber){
        //double setNum = RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort, 1);
        SmartDashboard.putNumber("Raw Axis",RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort, 1));

        switch(motorNumber){
            case 0:
                if ((Constants.StringPot(0) > min) && (Constants.StringPot(0) < max)) {
                    Elevation.set(RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort,1));
                }
                else if ((Constants.StringPot(0) < min)) {
                    if (RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort, 1) > 0) {
                        Elevation.set(RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort,1));
                    }   
                    else {
                        Elevation.set(0);
                    }
                }
                else if ((Constants.StringPot(0) > max)){
                    if (RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort, 1) < 0){
                        Elevation.set(RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort, 1));
                    } 
                    else {
                        Elevation.set(0);
                    }
                }
            break;
            case 1:
                if ((Constants.StringPot(0) > min) && (Constants.StringPot(0) < max)) {
                    Wench.set(RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort,1));
                }
                else if ((Constants.StringPot(0) < min)) {
                    if (RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort, 1) > 0) {
                        Wench.set(RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort,1));
                    }   
                    else {
                        Wench.set(0);
                    }
                }
                else if ((Constants.StringPot(0) > max)){
                    if (RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort, 1) < 0){
                        Wench.set(RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort, 1));
                    } 
                    else {
                        Wench.set(0);
                    }
                }
            break;
            case 2:
                if ((Constants.StringPot(0) > min) && (Constants.StringPot(0) < max)) {
                    Elevator.set(RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort,1));
                }
                else if ((Constants.StringPot(0) < min)) {
                    if (RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort, 1) > 0) {
                        Elevator.set(RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort,1));
                    }   
                    else {
                        Elevator.set(0);
                    }
                }
                else if ((Constants.StringPot(0) > max)){
                    if (RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort, 1) < 0){
                        Elevator.set(RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort, 1));
                    } 
                    else {
                        Elevator.set(0);
                    }
                }
            break;
            case 3:
                if ((Constants.StringPot(0) > min) && (Constants.StringPot(0) < max)) {
                    Extension.set(RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort,1));
                }
                else if ((Constants.StringPot(0) < min)) {
                    if (RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort, 1) > 0) {
                        Extension.set(RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort,1));
                    }   
                    else {
                        Extension.set(0);
                    }
                }
                else if ((Constants.StringPot(0) > max)){
                    if (RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort, 1) < 0){
                        Extension.set(RobotContainer.sendAxisValue(Constants.OperatingConstants.OperatingPort, 1));
                    } 
                    else {
                        Extension.set(0);
                    }
                }
            break;
        }
        //return autoComplete;
    }

    public static void runMotorButton(double min, double max, int motorNumber, double incomingPower){
        switch(motorNumber){
            case 0:
                if ((Constants.StringPot(0) > min) && (Constants.StringPot(0) < max)) {
                    LeftLift.set(incomingPower);
                }
                else if ((Constants.StringPot(0) < min)) {
                    if (incomingPower > 0) {
                        LeftLift.set(incomingPower);
                    }   
                    else {
                        LeftLift.set(0);
                    }
                }
                else if ((Constants.StringPot(0) > max)){
                    if (incomingPower < 0){
                        LeftLift.set(incomingPower);
                    } 
                    else {
                        LeftLift.set(0);
                    }
                }
            break;
            case 1:
                if ((Constants.StringPot(0) > min) && (Constants.StringPot(0) < max)) {
                    RightLift.set(incomingPower);
                }
                else if ((Constants.StringPot(0) < min)) {
                    if (incomingPower > 0) {
                        RightLift.set(incomingPower);
                    }   
                    else {
                        RightLift.set(0);
                    }
                }
                else if ((Constants.StringPot(0) > max)){
                    if (incomingPower < 0){
                        RightLift.set(incomingPower);
                    } 
                    else {
                        RightLift.set(0);
                    }
                }
            break;
            case 2:
                if ((Constants.StringPot(0) > min) && (Constants.StringPot(0) < max)) {
                    Elevator.set(incomingPower);
                }
                else if ((Constants.StringPot(0) < min)) {
                    if (incomingPower > 0) {
                        Elevator.set(incomingPower);
                    }   
                    else {
                        Elevator.set(0);
                    }
                }
                else if ((Constants.StringPot(0) > max)){
                    if (incomingPower < 0){
                        Elevator.set(incomingPower);
                    } 
                    else {
                        Elevator.set(0);
                    }
                }
            break;
            case 3:
                if ((Constants.StringPot(0) > min) && (Constants.StringPot(0) < max)) {
                    Flippy.set(incomingPower);
                }
                else if ((Constants.StringPot(0) < min)) {
                    if (incomingPower > 0) {
                        Flippy.set(incomingPower);
                    }   
                    else {
                        Flippy.set(0);
                    }
                }
                else if ((Constants.StringPot(0) > max)){
                    if (incomingPower < 0){
                        Flippy.set(incomingPower);
                    } 
                    else {
                        Flippy.set(0);
                    }
                }
            break;
        }
    }

    /*public static boolean algaeStringPot(double incomingPower){
        if((incomingPower < Constants.Swerve.StringPotMin) && (incomingPower > Constants.Swerve.StringPotMax)){
            //Wolverine.set(incomingPower);
            //Storm.set(incomingPower);
            autoComplete = true;
        }
        return autoComplete;
    }*/
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
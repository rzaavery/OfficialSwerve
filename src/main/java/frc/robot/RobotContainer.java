// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.autos.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  /* Subsystems */
  private final Swerve s_Swerve = new Swerve();
  private final StringPotSub m_StringPotSub = new StringPotSub();
  private final IntakeSub m_intakeSub = new IntakeSub();

  /* Controllers */
  private final static CommandXboxController driver = new CommandXboxController(Constants.DrivingConstants.driverPort);
  private final static CommandXboxController operator = new CommandXboxController(Constants.OperatingConstants.OperatingPort);

  /* Drive Controls 
  private final int translationAxis = XboxController.Axis.kLeftY.value;
  private final int strafeAxis = XboxController.Axis.kLeftX.value;
  private final int rotationAxis = XboxController.Axis.kRightX.value;*/
  
  /* Driver Buttons 
  private final JoystickButton zeroGyro =
      new JoystickButton(driver, XboxController.Button.kY.value);
  private final JoystickButton robotCentric =
      new JoystickButton(driver, XboxController.Button.kLeftBumper.value);*/

  /*Operator Buttons 
  //Ex button creation: private final JoystickButton stringPotButton = new JoystickButton(operator, XboxController.Button.kA.value);
  private final JoystickButton ArmIntake = 
      new JoystickButton(operator,XboxController.Button.kX.value);
  private final JoystickButton ArmDetake =
      new JoystickButton(operator,XboxController.Button.kY.value);
  private final JoystickButton LiftUp =
      new JoystickButton(operator,XboxController.Button.kA.value);
  private final JoystickButton LiftDown =
      new JoystickButton(operator,XboxController.Button.kB.value);
  private final JoystickButton Spinner =
      new JoystickButton(operator,XboxController.Button.kStart.value);
  private final JoystickButton */
  

  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //m_StringPotSub.setDefaultCommand(new StringPotAxis(m_StringPotSub,"Prof"));
    s_Swerve.setDefaultCommand(
        new TeleopSwerve(
            s_Swerve,
            () -> -driver.getRawAxis(driver.getLeftY()),
            () -> -driver.getRawAxis(driver.getLeftX()),
            () -> -driver.getRawAxis(driver.getRightX()),
            () -> driver.getLeftBumper()));

    // Configure the button bindings
    configureButtonBindings();
  }
  
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    /* Driver Buttons */
    //Prof - Motor 1; Rogue - Motor 2
    //zeroGyro.onTrue(new InstantCommand(() -> s_Swerve.zeroGyro()));
    operator.x().onTrue(new Intake(m_intakeSub,1,"Front Arm"));
    operator.y().onTrue(new Intake(m_intakeSub,-1,"Front Arm"));
    operator.a().onTrue(new StringPotButton(m_StringPotSub,1,"Lift"));
    operator.b().onTrue(new StringPotButton(m_StringPotSub,-1,"Lift"));
    operator.start().onTrue(new Intake(m_intakeSub,1,"Spinner"));
    operator.rightBumper().onTrue(new StringPotButton(m_StringPotSub,1,"Flippy"));
    operator.POVButton(operator,0).onTrue(new StringPotButton(m_StringPotSub,0,"Elevator"));
    operator.POVButton(operator,90).onTrue(new StringPotButton(m_StringPotSub,1,"Elevator"));
    operator.POVButton(operator,270).onTrue(new StringPotButton(m_StringPotSub,2,"Elevator"));
  }
  
  //bounds low: 0.01, high 0.07
  public static double sendAxisValue(int controllerID, int axisNumber){
    double axisOutput = 0;
    //double axisOutput;
    switch(controllerID){
      case 0:
        axisOutput = 0;
      break;
      case 1:
        axisOutput = operator.getRawAxis(axisNumber);
      break;
    }
    return axisOutput;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new exampleAuto(s_Swerve);
  }
}

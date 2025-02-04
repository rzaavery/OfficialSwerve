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
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
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
  private final static XboxController driver = new XboxController(Constants.DrivingConstants.driverPort);
  private final static XboxController operator = new XboxController(Constants.OperatingConstants.OperatingPort);

  /* Drive Controls */
  private final int translationAxis = XboxController.Axis.kLeftY.value;
  private final int strafeAxis = XboxController.Axis.kLeftX.value;
  private final int rotationAxis = XboxController.Axis.kRightX.value;
  
  /* Driver Buttons 
  private final JoystickButton zeroGyro =
      new JoystickButton(driver, XboxController.Button.kY.value);*/
  private final JoystickButton robotCentric =
      new JoystickButton(driver, XboxController.Button.kLeftBumper.value);

  /*Operator Buttons */
  //Ex button creation: private final JoystickButton stringPotButton = new JoystickButton(operator, XboxController.Button.kA.value);
  private final JoystickButton ArmIntake = 
      new JoystickButton(operator,3);
  private final JoystickButton ArmDetake =
      new JoystickButton(operator,4);
  private final JoystickButton LiftUp =
      new JoystickButton(operator,1);
  private final JoystickButton LiftDown =
      new JoystickButton(operator,2);
  private final JoystickButton Spinner =
      new JoystickButton(operator,5);
  private final JoystickButton Flippy =
      new JoystickButton(operator, 6);
  
  private POVButton up = new POVButton(operator, 0);
	private POVButton left = new POVButton(operator, 270);
	private POVButton right = new POVButton(operator, 90);

  Trigger elevationTrigger = new Trigger(() -> operator.getRawAxis(1) != 0);
  Trigger leftWenchTrigger = new Trigger(() -> operator.getRawAxis(2) != 0);
  Trigger rightWenchTrigger = new Trigger(() -> operator.getRawAxis(3) != 0);
  Trigger elevatorTrigger = new Trigger(() -> operator.getRawAxis(5) != 0);
  Trigger extensionTrigger = new Trigger(() -> operator.getRawAxis(4) != 0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //m_StringPotSub.setDefaultCommand(new StringPotAxis(m_StringPotSub,"Prof"));
    s_Swerve.setDefaultCommand(
        new TeleopSwerve(
            s_Swerve,
            () -> -driver.getRawAxis(translationAxis),
            () -> -driver.getRawAxis(strafeAxis),
            () -> -driver.getRawAxis(rotationAxis),
            () -> robotCentric.getAsBoolean()));

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
    ArmIntake.onTrue(new Intake(m_intakeSub,1,"Front Arm"));
    ArmDetake.onTrue(new Intake(m_intakeSub,-1,"Front Arm"));
    LiftUp.onTrue(new StringPotButton(m_StringPotSub,1,"Lift"));
    LiftDown.onTrue(new StringPotButton(m_StringPotSub,-1,"Lift"));
    Spinner.onTrue(new Intake(m_intakeSub,1,"Spinner"));
    Flippy.onTrue(new StringPotButton(m_StringPotSub,1,"Flippy"));
    up.onTrue(new StringPotButton(m_StringPotSub,1,"Elevator"));
    left.onTrue(new StringPotButton(m_StringPotSub, 1, "Elevator"));
    right.onTrue(new StringPotButton(m_StringPotSub, 1, "Elevator"));
    
    elevationTrigger.whileTrue(new StringPotAxis(m_StringPotSub, "Elevation"));
    elevatorTrigger.whileTrue(new StringPotAxis(m_StringPotSub, "Elevator"));
    extensionTrigger.whileTrue(new StringPotAxis(m_StringPotSub, "Extension"));
    leftWenchTrigger.whileTrue(new StringPotAxis(m_StringPotSub, "Wench"));
    rightWenchTrigger.whileTrue(new StringPotAxis(m_StringPotSub, "Wench"));
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

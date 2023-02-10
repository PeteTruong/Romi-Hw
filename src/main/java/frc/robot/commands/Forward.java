// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class Forward extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RomiDrivetrain m_db;
  //Initialize this variable for amount of distance we want later
  private final double distance;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  // The Command takes in the subsystem and the amount of inches the Romi has to move.
  public Forward(RomiDrivetrain db, double inches) {
    //Store these values into the ones previously made to be accessed by global variables.
    m_db = db;
    distance = inches;
  
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(db);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Clears all values and resets it to 0
    m_db.arcadeDrive(0,0);
    m_db.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Takes the y-axis value of the left joystick to move forward and the x-axis value of the right joystick to rotate.
    m_db.arcadeDrive​(RobotContainer.controller.getLeftY(), RobotContainer.controller.getRightX());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_db.arcadeDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //Stops when the amount of distance traveled is reached OR if inputted value is less than 0 or negative.
    return (m_db.getLeftDistanceInch() > distance || distance < 0);
  }


  
}

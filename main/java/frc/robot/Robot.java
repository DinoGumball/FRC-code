// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
//import edu.wpi.first.math.kinematics;

/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;

  private final MotorController m_leftMotor1 = new PWMSparkMax(0);
  private final MotorController m_rightMotor1 = new PWMSparkMax(1);
  private final MotorController m_leftMotor2 = new PWMSparkMax(2);
  private final MotorController m_rightMotor2 = new PWMSparkMax(3);

  private final MotorControllerGroup leftMotorGroup = new MotorControllerGroup( 
    m_leftMotor1,
    m_leftMotor2
    );

  private final MotorControllerGroup rightMotorGroup = new MotorControllerGroup( 
    m_rightMotor1,
    m_rightMotor2
    );

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    rightMotorGroup.setInverted(true);

    m_myRobot = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(m_leftStick.getY(), m_rightStick.getY());
  }
}


package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class Robot extends TimedRobot {
  
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;

  private final MotorController tLeftMotor = new Talon(0);
  private final MotorController tRightMotor = new Talon(1);
  private final MotorController bLeftMotor = new Talon(2);
  private final MotorController bRightMotor = new Talon(3);
  private final MotorControllerGroup leftMotors = new MotorControllerGroup(tLeftMotor, bLeftMotor);
  private final MotorControllerGroup rightMotors = new MotorControllerGroup(tRightMotor, bRightMotor);
  public double 

  public Joystick controller = new Joystick(1);
  public double move = 0;
  public double turn = 0;

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    tRightMotor.setInverted(true);


    
  }
  /** This function is run once each time the robot enters autonomous mode. */
  @Override
  public void autonomousInit() {
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

  }
  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    move = controller.getRawAxis(2)-controller.getRawAxis(3);
    turn = controller.getRawAxis(1);
    if(Math.abs(move) < 0.1){
    move = 0;  
    }
    if(Math.abs(turn) < 0.1){
    turn = 0;  
    }
    leftMotors = move - turn;
    rightMotors = move + turn;
    m_myRobot.tankDrive(m_leftStick.getY(), m_rightStick.getY());
  }
}
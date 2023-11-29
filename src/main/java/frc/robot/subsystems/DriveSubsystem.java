package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class DriveSubsystem extends SubsystemBase{
    //initialize the motors
    Spark frSpark = new Spark(Constants.MotorConstants.kfrMotorPort);
    Spark flSpark = new Spark(Constants.MotorConstants.kflMotorPort);
    Spark brSpark = new Spark(Constants.MotorConstants.kbrMotorPort);
    Spark blSpark = new Spark(Constants.MotorConstants.kblMotorPort);

    //initialize the motorgroups
    MotorControllerGroup rightGroup = new MotorControllerGroup(frSpark, brSpark);
    MotorControllerGroup leftGroup = new MotorControllerGroup(flSpark, blSpark);
    
    DifferentialDrive driver; 

    public DriveSubsystem(){
        rightGroup.setInverted(true);
        driver = new DifferentialDrive(leftGroup, rightGroup);
        this.setDefaultCommand(getArcadeDriveCommand());
    }

    public void arcadeDrive(double xSpeed, double zRotation){
        driver.arcadeDrive(xSpeed, zRotation);
    } 

    public CommandBase getArcadeDriveCommand(){
        return this.run(() -> arcadeDrive(RobotContainer.m_driverController.getLeftY(), RobotContainer.m_driverController.getLeftX()));
    }


}

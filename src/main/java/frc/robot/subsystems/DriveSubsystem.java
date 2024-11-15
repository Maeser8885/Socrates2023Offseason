package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
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
    
    public DifferentialDrive driver; 

    public DriveSubsystem(){
        rightGroup.setInverted(true);
        driver = new DifferentialDrive(leftGroup, rightGroup);
        this.setDefaultCommand(getArcadeDriveCommand());
    }

    public void arcadeDrive(double xSpeed, double zRotation){
        driver.arcadeDrive(xSpeed, zRotation);
    } 

    public Command getArcadeDriveCommand(){
        return this.run(() -> arcadeDrive(RobotContainer.m_driverController.getLeftY(), -RobotContainer.m_driverController.getLeftX()));
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("FL", frSpark.get());
        SmartDashboard.putNumber("FR", flSpark.get());
        SmartDashboard.putNumber("BL", brSpark.get());
        SmartDashboard.putNumber("BR", blSpark.get());
        SmartDashboard.putNumber("Right", rightGroup.get());
        SmartDashboard.putNumber("Left", leftGroup.get());

    }

}

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;

public class RightCommandGroup extends SequentialCommandGroup{
    public RightCommandGroup(DriveSubsystem drive){
        addCommands(
        //TODO change rotationdistance, time, and speed to what they need to be 
        new DriveTimedCommand(3.0,2.0,drive),
        new RotateAmountCommand(90.0, drive),
        new DriveTimedCommand(3.0,3.0, drive));

    }
}

package org.firstinspires.ftc.teamcode.Autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.MechanumDrive;

@Autonomous(name = "Drive Right", group = "Autonomous")
public class DriveRightAuto extends LinearOpMode {
    private MechanumDrive drive;

    @Override
    public void runOpMode() {
        drive = new MechanumDrive(hardwareMap, telemetry);
        waitForStart();
        drive.right(-1);
        sleep(5000);
        drive.stop();

    }

}

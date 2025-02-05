package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Autos.AutonomousRecorder;
import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.Claw;
import org.firstinspires.ftc.teamcode.Subsystems.MechanumDrive;

@TeleOp(name = "Main Drive")
public class RobotContainer extends OpMode {

    private Claw claw;

    private MechanumDrive drive;

    private Arm arm;
    private AutonomousRecorder recorder;

    private ElapsedTime recordingTimer;
    private boolean isRecording = false;

    @Override
    public void init() {
        recorder = new AutonomousRecorder();
        arm = new Arm(hardwareMap, telemetry);
        claw = new Claw(hardwareMap, telemetry);
        drive = new MechanumDrive(hardwareMap, telemetry);

        recordingTimer = new ElapsedTime();

    }

    @Override
    public void loop() {
        if (isRecording && recordingTimer.seconds() >= 35.0) {
            recorder.stopRecording();
            isRecording = false;
            gamepad1.rumble(250);
        }

        if (gamepad1.left_stick_y != 0) {
            drive.forward(gamepad1.left_stick_y);
            recorder.giveCommand("drive.forward(" + gamepad1.left_stick_y + ");");
        } else if (gamepad1.left_stick_x != 0) {
            drive.right(gamepad1.left_stick_x);
            recorder.giveCommand("drive.right(" + gamepad1.left_stick_x + ");");
        } else if (gamepad1.right_stick_x != 0) {
            drive.rotateRight(gamepad1.right_stick_x);
            recorder.giveCommand("drive.rotateRight(" + gamepad1.right_stick_x + ");");
        } else if (gamepad2.left_stick_y != 0) {
            arm.moveUp(gamepad2.left_stick_y);
            recorder.giveCommand("arm.moveUp(" + gamepad2.left_stick_y + ");");
        } else if (gamepad2.left_stick_button) {
            arm.stop();
            recorder.giveCommand("arm.stop();");
        } else if (gamepad1.a) {
            claw.openClaw();
            recorder.giveCommand("claw.openClaw();");
        } else if (gamepad1.b) {
            claw.closeClaw();
            recorder.giveCommand("claw.closeClaw();");
        } else if (gamepad1.x) {
            if (recorder.startRecording()) {
                isRecording = true;
                recordingTimer.reset();
                gamepad1.rumble(250);
            }
        } else {
            drive.stop();
        }


    }


}

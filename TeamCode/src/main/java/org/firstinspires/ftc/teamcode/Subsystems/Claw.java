package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;

public class Claw {
    private final double MAX_SERVO_POSITION = 1.0;
    private final double MIN_SERVO_POSITION = 0.0;
    private Servo claw;
    private org.firstinspires.ftc.robotcore.external.Telemetry telemetry;

    public Claw(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        claw = hardwareMap.get(Servo.class, Constants.ClawConstants.CLAW_SERVO_ID);
        claw.setDirection(Servo.Direction.REVERSE);
        telemetry.addData("Position:", this.getPosition());

    }

    public void openClaw() {
        setPosition(Constants.ClawConstants.OPEN_POSITION);
    }

    public void closeClaw() {
        setPosition(Constants.ClawConstants.CLOSE_POSITION);
    }

    public double getPosition() {
        return claw.getPosition();
    }

    public void setPosition(double position) {
        if (position >= MIN_SERVO_POSITION && position <= MAX_SERVO_POSITION) {
            claw.setPosition(position);
        }
    }
}

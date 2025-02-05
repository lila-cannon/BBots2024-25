package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;

public class MechanumDrive {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    private Telemetry telemetry;


    public MechanumDrive(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        frontLeft = hardwareMap.dcMotor.get(Constants.DriveConstants.FRONT_LEFT_MOTOR_ID);
        frontRight = hardwareMap.dcMotor.get(Constants.DriveConstants.FRONT_RIGHT_MOTOR_ID);
        backLeft = hardwareMap.dcMotor.get(Constants.DriveConstants.BACK_LEFT_MOTOR_ID);
        backRight = hardwareMap.dcMotor.get(Constants.DriveConstants.BACK_RIGHT_MOTOR_ID);

        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeft.setDirection(DcMotor.Direction.REVERSE); //This is why nothing is working. TODO Invert all the stupid FL values >:( -- needs testing
    }


    public void forward(double power) {
        frontLeft.setPower(power);
        backLeft.setPower(power);
        frontRight.setPower(power);
        backRight.setPower(power);
    }

    public void right(double power) {
        frontLeft.setPower(-power);
        backLeft.setPower(power);
        frontRight.setPower(power);
        backRight.setPower(-power);
    }

    public void rotateRight(double power) {
        frontLeft.setPower(-power);
        backLeft.setPower(-power);
        frontRight.setPower(power);
        backRight.setPower(power);
    }

    public void stop() {
        frontLeft.setPower(0);
        backLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
    }

    public void setMotors(double FL, double FR, double BL, double BR) { //Should not be used manually TODO: NEEDS TESTED
        frontLeft.setPower(FL);
        frontRight.setPower(FR);
        backLeft.setPower(BL);
        backRight.setPower(BR);
    }
}

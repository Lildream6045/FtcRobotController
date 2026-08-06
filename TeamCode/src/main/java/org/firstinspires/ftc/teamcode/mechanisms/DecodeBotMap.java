package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class DecodeBotMap {
    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private DcMotor launcher;
    private Servo leftServoPos;
    private Servo rightServoPos;
    private IMU imu;

    public void init(HardwareMap hwMap) {
        leftDrive = hwMap.get(DcMotor.class, "left_drive");
        rightDrive = hwMap.get(DcMotor.class, "right_drive");
        leftServoPos = hwMap.get(Servo.class, "left_Servo");
        rightServoPos = hwMap.get(Servo.class, "right_servo");
        imu = hwMap.get(IMU.class, "imu");
        launcher = hwMap.get(DcMotor.class, "launcher");
        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        launcher.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        launcher.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.LEFT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP
        );

        imu.initialize(new IMU.Parameters(RevOrientation));
    }

    public void setLeftDriveSpeed (double leftDriveSpeed) {
        leftDrive.setPower(leftDriveSpeed);
    }

    public void setRightDriveSpeed (double rightDriveSpeed) {
        rightDrive.setPower(rightDriveSpeed);
    }

    public void setLauncherSpeed (double launcherSpeed) {
        launcher.setPower(launcherSpeed);
    }

    public void setLeftServoPos (double leftServoAngle) {
        leftServoPos.setPosition(leftServoAngle);
    }

    public void setRightServoPos (double rightServoAngle) {
        rightServoPos.setPosition(rightServoAngle);
    }

    public double getHeading () {
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
    }

    public double getLeftDrivePower() {
        return leftDrive.getPower();
    }

    public double getRightDrivePower() {
        return rightDrive.getPower();
    }

    public double getLauncherPower() {
        return launcher.getPower();
    }

}

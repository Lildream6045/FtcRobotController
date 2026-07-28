package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class StrafeBotMap {

    private DcMotor leftFront;
    private double ticksPerRevLeftFront;
    private DcMotor leftBack;
    private double ticksPerRevLeftBack;
    private DcMotor rightFront;
    private double ticksPerRevRightFront;
    private DcMotor rightBack;
    private double ticksPerRevRightBack;


    public void init(HardwareMap hwMap) {
        leftFront = hwMap.get(DcMotor.class, "left_front");
        leftBack = hwMap.get(DcMotor.class, "left_back");
        rightFront = hwMap.get(DcMotor.class, "right_front");
        rightBack = hwMap.get(DcMotor.class, "right_back");
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRevLeftFront = leftFront.getMotorType().getTicksPerRev();
        ticksPerRevLeftBack = leftBack.getMotorType().getTicksPerRev();
        ticksPerRevRightFront = rightFront.getMotorType().getTicksPerRev();
        ticksPerRevRightBack = rightBack.getMotorType().getTicksPerRev();
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setLeftFrontSpeed(double LeftFrontSpeed) {
        leftFront.setPower(LeftFrontSpeed);
    }

    public void setLeftBackSpeed(double LeftBackSpeed) {
        leftBack.setPower(LeftBackSpeed);
    }

    public void setRightFrontSpeed(double RightFrontSpeed) {
        rightFront.setPower(RightFrontSpeed);
    }

    public void setRightBackSpeed(double RightBackSpeed) {
        rightBack.setPower(RightBackSpeed);
    }

    public double getMotorRevsLF() {
        return leftFront.getCurrentPosition() / ticksPerRevLeftFront;
    }

    public double getMotorRevsLB() {
        return leftBack.getCurrentPosition() / ticksPerRevLeftBack;
    }

    public double getMotorRevsRF() {
        return rightFront.getCurrentPosition() / ticksPerRevRightFront;
    }

    public double getMotorRevsRB() {
        return rightBack.getCurrentPosition() / ticksPerRevRightBack;
    }

    public double getMotorPowerLF() {
        return leftFront.getPower();
    }

    public double getMotorPowerLB() {
        return leftBack.getPower();
    }

    public double getMotorPowerRF() {
        return rightFront.getPower();
    }

    public double getMotorPowerRB() {
        return rightBack.getPower();
    }
}

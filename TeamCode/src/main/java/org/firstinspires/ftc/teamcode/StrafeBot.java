package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.StrafeBotMap;

@Disabled
@TeleOp
public class StrafeBot extends OpMode {
    StrafeBotMap strafe = new StrafeBotMap();

    @Override
    public void init() {
        strafe.init(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.left_stick_y < 0) {
            strafe.setLeftFrontSpeed(0.5);
            strafe.setRightFrontSpeed(0.5);
        }
        else if (gamepad1.left_stick_y > 0) {
            strafe.setLeftFrontSpeed(-0.5);
            strafe.setRightFrontSpeed(-0.5);
        }
        else if (gamepad1.right_stick_x > 0) {
            strafe.setLeftFrontSpeed(-0.5);
            strafe.setRightFrontSpeed(0.5);
            strafe.setLeftBackSpeed(-0.5);
            strafe.setRightBackSpeed(0.5);
        }
        else if (gamepad1.right_stick_x < 0) {
            strafe.setLeftFrontSpeed(0.5);
            strafe.setRightFrontSpeed(-0.5);
            strafe.setLeftBackSpeed(0.5);
            strafe.setRightBackSpeed(-0.5);
        }
        else if (gamepad1.left_bumper) {
            strafe.setLeftFrontSpeed(0.5);
            strafe.setRightFrontSpeed(-0.5);
            strafe.setLeftBackSpeed(-0.5);
            strafe.setRightBackSpeed(0.5);
        }
        else if (gamepad1.right_bumper) {
            strafe.setLeftFrontSpeed(-0.5);
            strafe.setRightFrontSpeed(0.5);
            strafe.setLeftBackSpeed(0.5);
            strafe.setRightBackSpeed(-0.5);
        }
        else {
            strafe.setLeftFrontSpeed(0);
            strafe.setRightFrontSpeed(0);
            strafe.setLeftBackSpeed(0);
            strafe.setRightBackSpeed(0);
        }
        telemetry.addData("LF Power", strafe.getMotorPowerLF());
        telemetry.addData("LB Power", strafe.getMotorPowerLB());
        telemetry.addData("RF Power", strafe.getMotorPowerRF());
        telemetry.addData("RB Power", strafe.getMotorPowerRB());
    }
}

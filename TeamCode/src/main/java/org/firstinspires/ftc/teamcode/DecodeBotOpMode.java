package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.DecodeBotMap;

@TeleOp
public class DecodeBotOpMode extends OpMode {
    DecodeBotMap decode = new DecodeBotMap();

    @Override
    public void init() {
        decode.init(hardwareMap);
   }

    @Override
    public void loop() {
        // code for driving
        if (gamepad1.left_stick_y > 0) {
            decode.setLeftDriveSpeed(1);
            decode.setRightDriveSpeed(1);
        }
        else if (gamepad1.left_stick_y < 0) {
            decode.setLeftDriveSpeed(-1);
            decode.setRightDriveSpeed(-1);
        }
        else if (gamepad1.right_stick_x < 0) {
            decode.setLeftDriveSpeed(-1);
            decode.setRightDriveSpeed(1);
        }
        else if (gamepad1.right_stick_x > 0) {
            decode.setLeftDriveSpeed(1);
            decode.setRightDriveSpeed(-1);
        }
        else {
            decode.setLeftDriveSpeed(0);
            decode.setRightDriveSpeed(0);
        }




        // code for shooting modes

        if (gamepad1.dpad_right) {
            decode.setLauncherSpeed(1);
        }
        else if (gamepad1.dpad_left) {
            decode.setLauncherSpeed(0.75);
        }
        else if (gamepad1.dpad_down) {
            decode.setLauncherSpeed(0);
        }

        // code for launch procedure

        if (gamepad1.right_bumper) {
            decode.setLeftServoPos(25);
            decode.setRightServoPos(25);
        }

        // telemetry
        telemetry.addData("Left Motor PWR", decode.getLeftDrivePower());
        telemetry.addData("Right Motor PWR", decode.getRightDrivePower());
        telemetry.addData("Launcher Motor PWR", decode.getLauncherPower());
        telemetry.addData("Servo Left Angle", decode.getLeftServoAngle());
        telemetry.addData("Servo Right Angle", decode.getRightServoAngle());
        telemetry.addData("Heading", decode.getHeading());
    }
}

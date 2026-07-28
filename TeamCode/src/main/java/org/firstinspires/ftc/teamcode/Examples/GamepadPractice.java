package org.firstinspires.ftc.teamcode.Examples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp
public class GamepadPractice extends OpMode {

    @Override
    public void init() {

    }


        public void loop() {
            // runs 50x a second
            double speedForward = -gamepad1.left_stick_y / 2.0;
            double speedRight = gamepad1.left_stick_x / gamepad1.right_stick_x;
        telemetry.addData("left x", gamepad1.left_stick_x);
        telemetry.addData("Left y", speedForward);
        telemetry.addData("Right x", gamepad1.right_stick_x);
        telemetry.addData("Right y", gamepad1.right_stick_y);
        telemetry.addData("Difference", speedRight);

        telemetry.addData("A", gamepad1.a);
        telemetry.addData("B", gamepad1.b);
        telemetry.addData("X", gamepad1.x);
        telemetry.addData("Y", gamepad1.y);

        telemetry.addData("D-Pad up", gamepad1.dpad_up);
        telemetry.addData("D-Pad Down", gamepad1.dpad_down);



    }

    /*
    1. Add telemetry for Right Joystick
    2. Add Telemetry for the all other buttons
    3. Add telemetry to report the Difference between x left Joystick and x right Joystick
    4. Add telemetry to report the Sum of both back triggers
     */
}

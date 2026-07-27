package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class IfPractice extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        double leftY = gamepad1.left_stick_y;
        boolean aButton = gamepad1.a;
        //returns True or False
        if (aButton) {
            telemetry.addData("A Button", "Pressed");
        }
        else if (leftY > 0.5) {
            telemetry.addData("Left Stick Y", leftY );
        }
        else {
            telemetry.addData("A Button", "Not Pressed");
        }
        telemetry.addData("A Button State", aButton);
    }
    /*
    And = && if (leftY < 0.5 && leftY > 0) {
    Or = || if (leftY < 0 || rightY < 0) {
    Not= ! if (!clawClosed) {
     */
}

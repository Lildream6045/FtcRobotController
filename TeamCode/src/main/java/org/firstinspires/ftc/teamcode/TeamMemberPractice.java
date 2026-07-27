package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TeamMemberPractice extends OpMode {

    boolean initfinished;

    @Override
    public void init() {
     telemetry.addData("init", initfinished);
         initfinished = true;
    }

    double squareInputWithSign(double input) {
        double output = input * input;

        if (input < 0) {
            output *= -1;
        }
        return output;
    }

    @Override
    public void loop() {
    telemetry.addData("init", initfinished);

    double yAxis = gamepad1.left_stick_y;

    telemetry.addData("left stick normal", yAxis);

    yAxis = squareInputWithSign(yAxis);
    telemetry.addData("left stick modified", yAxis);

    }
}

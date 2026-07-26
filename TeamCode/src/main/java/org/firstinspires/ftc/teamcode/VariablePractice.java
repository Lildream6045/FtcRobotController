package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class VariablePractice extends OpMode {

    @Override
    public void init() {
        int teamNumber = 31639;
        double motorSpeed = 0.75;
        boolean clawClosed = true;
        String teamName = "Rose City Robotics";
        int servoAngle = 69;

        telemetry.addData("Team Number", teamNumber);
        telemetry.addData("Motor Speed", motorSpeed);
        telemetry.addData("Claw Closed", clawClosed);
        telemetry.addData("Name", teamName);
        telemetry.addData("Servo Angle", servoAngle);
    }

    @Override
    public void loop() {
    /*
    1. Change the string variable name to your team name
    2. Create an int called "servoAngle" and store an angle between 0-180. display this in your init method

    */
    }
}

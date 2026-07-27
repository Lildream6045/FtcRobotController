package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class UseRobotLocationOpMode extends OpMode {
    RobotLocationPractice robotLocationPractice = new RobotLocationPractice(0);


    @Override
    public void init() {
        robotLocationPractice.setAngle(0);
        robotLocationPractice.setX(0);
    }

    @Override
    public void loop() {
        if (gamepad1.a){
            robotLocationPractice.turnRobot(0.1);
        }
        else if (gamepad1.b) {
            robotLocationPractice.turnRobot(-0.1);
        }

        if (gamepad1.dpad_left) {
            robotLocationPractice.changeX(0.1);
        }
        else if (gamepad1.dpad_right) {
            robotLocationPractice.changeX(-0.1);
        }

        if (gamepad1.dpad_up) {
            robotLocationPractice.changeY(0.1);
        }
        else if (gamepad1.dpad_down) {
            robotLocationPractice.changeY(-0.1);
        }

        telemetry.addData("Heading", robotLocationPractice.getHeading());
        telemetry.addData("Angle", robotLocationPractice.getAngle());
        telemetry.addData("X Value", robotLocationPractice.getX());
        telemetry.addData("Y Value", robotLocationPractice.getY());
    }
}

/*

1. Add a double getAngle to your  robotLocationPractice, and display this in your OpMode
2. Inside your location class,
-create a double x
-void changeX(double changeAmount)
-setX(double x)

3. Inside your OpMode
-When Left D-Pad Pressed add 0.1 to x
- when Right D-Pad pressed subtract 0.1 to x
- telemetry, display x value

4. Do same for Y
 */
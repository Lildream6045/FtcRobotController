package org.firstinspires.ftc.teamcode;
// Single Line Comment is the Code being pulled from the base of the FtcRobotController Github
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;



@Autonomous
public class HelloWorld extends OpMode {

    @Override
    public void init() {
        telemetry.addLine("Hello World");
        telemetry.addData("Hello", "Greyson");
    }

    @Override
    public void loop() {
    }


}

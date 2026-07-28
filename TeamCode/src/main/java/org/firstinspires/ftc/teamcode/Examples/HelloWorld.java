package org.firstinspires.ftc.teamcode.Examples;
// Single Line Comment is the Code being pulled from the base of the FtcRobotController GitHub
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@Disabled
@TeleOp
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

package org.firstinspires.ftc.teamcode.Examples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

@TeleOp
public class IMUPractice extends OpMode {
    TestBench bench = new TestBench();

    public void init () {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        telemetry.addData("Robot Angle", bench.getHeading());
    }
}

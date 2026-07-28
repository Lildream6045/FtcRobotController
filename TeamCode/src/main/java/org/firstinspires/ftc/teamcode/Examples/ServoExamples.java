package org.firstinspires.ftc.teamcode.Examples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;

@TeleOp
public class ServoExamples extends OpMode {
    TestBench bench = new TestBench();

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            bench.setServoRot(1);
        }
        else if (gamepad1.b) {
            bench.setServoRot(-1);
        }
        else {
            bench.setServoRot(0);
        }
        telemetry.addData("ServoRotPWR", bench.getServoRotPWR());
    }
}

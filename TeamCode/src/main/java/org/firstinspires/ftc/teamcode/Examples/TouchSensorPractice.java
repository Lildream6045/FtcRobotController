package org.firstinspires.ftc.teamcode.Examples;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.TestBench;
@Disabled
@TeleOp
public class TouchSensorPractice extends OpMode {
    TestBench bench = new TestBench();

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        String touchSensorState = "not Pressed";

        if (bench.isTouchSensorPressed()); {
            touchSensorState = "Pressed";
        }

        telemetry.addData("Touch Sensor State", touchSensorState);
    }
    /*
    1. create a new getter method in your testBench class called isTouchSensorReleased, this will return true if the touch sensor is not pressed
     */
}

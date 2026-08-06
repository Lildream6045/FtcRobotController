package org.firstinspires.ftc.teamcode.mechanisms;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class TestBench {
    NormalizedColorSensor colorSensor;
    private DigitalChannel touchSensor; // touchSensorIntake
    private DcMotor motor ;
    private Servo servoPos;
    private CRServo servoRot;
    private IMU imu;

    public enum DetectedColor {
        RED,
        BLUE,
        Yellow,
        UNKNOWN
    }

    public void init(HardwareMap hwMap) {
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");
        touchSensor.setMode(DigitalChannel.Mode.INPUT);
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        servoRot = hwMap.get(CRServo.class,"servo_cont");
        colorSensor = hwMap.get(NormalizedColorSensor.class, "sensor_color_distance");
        colorSensor.setGain(8);
        imu = hwMap.get(IMU.class, "imu");

        RevHubOrientationOnRobot RevOrientation = new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD
        );

        imu.initialize(new IMU.Parameters(RevOrientation));
    }

    public double getHeading() {
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
    }

    public boolean isTouchSensorPressed() {
        return !touchSensor.getState();
    }

    public boolean isTouchSensorReleased() {
        return touchSensor.getState();
    }

    public void setMotorSpeed(double speed) {
        //this accepts values from -1.0 tp 1.0
        motor.setPower(speed);
    }

    public void setServoPos(double angle) {
        servoPos.setPosition(angle);
    }

    public void setServoRot(double power) {
        servoRot.setPower(power);
    }

    public double getServoRotPWR() {
        return servoRot.getPower();
    }

    public DetectedColor getDetectedColor(Telemetry telemetry) {
        NormalizedRGBA colors = colorSensor.getNormalizedColors(); // return 4 values


        float normred, normgreen, normblue;
        normred = colors.red / colors.alpha;
        normgreen = colors.green / colors.alpha;
        normblue = colors.blue / colors.alpha;

        telemetry.addData("red", normred);
        telemetry.addData("green", normgreen);
        telemetry.addData("blue", normblue);

        // TODO add if statements for specific colors added
        /*
        red, green, blue
        RED = >.35, <.3, <.3
        BLUE = <.2, <.5, >.5
        YELLOW = > .5, >.9, <.6
         */

        if (normred > 0.35 && normgreen <0.3 && normblue <0.3) {
            return DetectedColor.RED;
        }
        else if (normred >0.5 && normgreen >0.9 && normblue <0.6) {
            return DetectedColor.Yellow;
        }
        else if (normred < 0.2 && normgreen <0.5 && normblue >0.5) {
            return DetectedColor.BLUE;
        }
        else  {
            return DetectedColor.UNKNOWN;
        }
    }

}
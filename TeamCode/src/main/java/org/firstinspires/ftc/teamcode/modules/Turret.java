package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Turret {
    private Servo servoAngle;
    private double position = 0.5;
    private static final double STEP = 0.01;  
    private static final double MIN_POS = 0.0;
    private static final double MAX_POS = 1.0;

    public Turret(HardwareMap hardwareMap) {
        servoAngle= hardwareMap.get(Servo.class, "servoAngle");
        servoAngle.setPosition(position);
    }

    public void left() {
        position += STEP;
        if (position >= MAX_POS) position = MAX_POS;
        servoAngle.setPosition(position);
    }

    public void right() {
        position -= STEP;
        if (position <= MIN_POS) position = MIN_POS;
        servoAngle.setPosition(position);
    }
    public void stop() {}
    public double getPosition() {
        return position;
    }


}

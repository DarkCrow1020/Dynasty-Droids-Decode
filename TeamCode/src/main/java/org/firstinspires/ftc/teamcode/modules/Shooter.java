package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


public class Shooter {
    private DcMotor shooter1, shooter2;
    private Servo servoAngle,stopper;
    private boolean shooterOn = false;
    private ElapsedTime timer = new ElapsedTime();

    public Shooter(HardwareMap hardwareMap) {
        shooter1 = hardwareMap.get(DcMotor.class, "shooter1");
        shooter2 = hardwareMap.get(DcMotor.class, "shooter2");

        servoAngle = hardwareMap.get(Servo.class, "servoAngle");
        stopper = hardwareMap.get(Servo.class,"stopper");


    }



    public void toggle() {
        shooterOn = !shooterOn;
        if (shooterOn) timer.reset();
    }


    public void update() {

        if (shooterOn) {
            shooter1.setPower(-1);
            shooter2.setPower(1);
            if (timer.milliseconds() < 1500) {
                stopper.setPosition(0.25);
            } else{
                stopper.setPosition(0);
            }
        } else {
            shooter1.setPower(0);
            shooter2.setPower(0);
            stopper.setPosition(0.25);
        }
    }
    public boolean isOn() { return shooterOn; }

}

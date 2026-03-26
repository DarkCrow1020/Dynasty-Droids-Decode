package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    private DcMotor intake1,intake2;
    private Servo intakeServo1,intakeServo2;
    private int direction = 0;
    private float servoPosition1= 0.4f ,servoPosition2=0.1f;

    public Intake(HardwareMap hardwareMap) {
        intake1 = hardwareMap.get(DcMotor.class, "intake1");
        intake2 = hardwareMap.get(DcMotor.class,"intake2");
        intakeServo1 = hardwareMap.get(Servo.class, "intakeServo1");
        intakeServo2= hardwareMap.get(Servo.class,"intakeServo2");
    }
    public void forward() { direction = 1; }
    public void reverse() { direction = -1; }
    public void servoDown(){servoPosition1=0.1f;servoPosition2=0.4f;}
    public void servoUp(){servoPosition1=0.4f;servoPosition2=0.1f;}
    public void stop()    { direction = 0; }
    public void update() {
        intake1.setPower(direction);
        intake2.setPower(-direction);
        intakeServo1.setPosition(servoPosition1);
        intakeServo2.setPosition(servoPosition2);
    }
}

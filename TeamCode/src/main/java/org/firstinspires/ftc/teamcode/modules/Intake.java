package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake {
    private final DcMotor intake1,intake2;
    private final Servo intakeServo1,intakeServo2;
    private static final double INTAKE_POWER = 1.0;
    private static final double SERVO1_UP = 0.4;
    private static final double SERVO2_UP = 0.1;
    private static final double SERVO1_DOWN = 0.1;
    private static final double SERVO2_DOWN = 0.4;
    private double power = 0.0;
    private double servoPosition1 = SERVO1_UP;
    private double servoPosition2 = SERVO2_UP;

    public Intake(HardwareMap hardwareMap) {
        intake1 = hardwareMap.get(DcMotor.class, "intake1");
        intake2 = hardwareMap.get(DcMotor.class,"intake2");
        intakeServo1 = hardwareMap.get(Servo.class, "intakeServo1");
        intakeServo2= hardwareMap.get(Servo.class,"intakeServo2");
        intake1.setDirection(DcMotor.Direction.FORWARD);
        intake2.setDirection(DcMotor.Direction.REVERSE);
        intake1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intake2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        servoUp();
        update();
    }
    public void forward() { power = INTAKE_POWER; }
    public void reverse() { power = -INTAKE_POWER; }
    public void servoDown(){
        servoPosition1=SERVO1_DOWN;
        servoPosition2=SERVO2_DOWN;
    }
    public void servoUp(){
        servoPosition1=SERVO1_UP;
        servoPosition2=SERVO2_UP;
    }
    public void stop()    { power = 0.0; }
    public void update() {
        intake1.setPower(power);
        intake2.setPower(power);
        intakeServo1.setPosition(servoPosition1);
        intakeServo2.setPosition(servoPosition2);
    }
}

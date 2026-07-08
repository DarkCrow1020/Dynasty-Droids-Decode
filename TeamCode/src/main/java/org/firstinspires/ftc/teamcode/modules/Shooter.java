package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


public class Shooter {
    private DcMotor shooter1, shooter2,intake1,intake2;
    private Servo servoAngle1,stopper;
    private boolean shooterOn = false;
    private ElapsedTime timer = new ElapsedTime();
    private int cycle;
    public Shooter(HardwareMap hardwareMap) {
        shooter1 = hardwareMap.get(DcMotor.class, "shooter1");
        shooter2 = hardwareMap.get(DcMotor.class, "shooter2");
        intake1 = hardwareMap.get(DcMotor.class, "intake1");
        intake2 = hardwareMap.get(DcMotor.class, "intake2");

        servoAngle1 = hardwareMap.get(Servo.class, "servoAngle1");
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
            if(cycle==0){
                timer.reset();
                cycle=1;
            }
            if(timer.milliseconds()<1500) {
            intake1.setPower(0);
            intake2.setPower(0);
            return;
            }
            if(timer.milliseconds()<2200){
            intake1.setPower(1);
            intake2.setPower(1);
            return;
            }
            cycle++;
            timer.reset();

            if(cycle>3){
                shooterOn=false;
                intake1.setPower(0);
                intake2.setPower(0);
                shooter2.setPower(0);
                shooter1.setPower(0);
                cycle=0;
            }

        } else {
            shooter1.setPower(0);
            shooter2.setPower(0);
            intake2.setPower(0);
            intake1.setPower(0);
            cycle=0;
        }
    }

    public boolean isOn() { return shooterOn; }
    public void stopper(){
        stopper.setPosition(0);
    }


}


package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.modules.DriveTrain;
import org.firstinspires.ftc.teamcode.modules.Intake;
import org.firstinspires.ftc.teamcode.modules.Turret;
import org.firstinspires.ftc.teamcode.modules.Shooter;

@TeleOp(name = "TestPiese", group = "TeleOp")
public class Piese_test extends OpMode {
    private DriveTrain drive;
    private Shooter shooter;
    private Intake intake1;
     private Turret turret;
    public void init() {
        drive = new DriveTrain(hardwareMap);
         shooter = new Shooter(hardwareMap);
        intake1 = new Intake(hardwareMap);
        turret= new Turret(hardwareMap);

        telemetry.addLine("Initialized");
    }
    public void loop() {
        if(gamepad1.dpad_up){
            intake1.servoUp();
        }
        if(gamepad1.dpad_down){
            intake1.servoDown();
        }
        if(gamepad1.dpad_left){
            turret.left();
        }
        if (gamepad1.dpad_right){
            turret.right();
        }
        if(gamepad1.leftBumperWasPressed()){
            shooter.toggle();
            shooter.isOn();
        }
        if (gamepad1.aWasPressed()) {

        }
        intake1.update();
        shooter.update();
    }
}

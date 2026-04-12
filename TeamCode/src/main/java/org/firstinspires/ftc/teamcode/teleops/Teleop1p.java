package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.modules.DriveTrain;
import org.firstinspires.ftc.teamcode.modules.Intake;
import org.firstinspires.ftc.teamcode.modules.Shooter;
import org.firstinspires.ftc.teamcode.modules.Turret;


@TeleOp(name = "ddTeleOp1P", group = "TeleOp")
public class Teleop1p extends OpMode {
    private DriveTrain drive;
    private Shooter shooter;
    private Intake intake1;
   private Turret turret;
    private boolean lbPrev = false;
    private boolean rbPrev = false;
    private boolean rtPrev = false;

    @Override
    public void init() {
        drive = new DriveTrain(hardwareMap);
        shooter = new Shooter(hardwareMap);
        intake1 = new Intake(hardwareMap);
        turret = new Turret(hardwareMap);

        telemetry.addLine("Initialized");
    }
    @Override
    public void loop() {
        drive.drive(
                -gamepad1.left_stick_y,
                -gamepad1.left_stick_x,
                -gamepad1.right_stick_x
        );
        if (gamepad1.right_trigger>0.1&&!rtPrev) {
            shooter.toggle();
        }
        rtPrev =gamepad1.right_trigger>0.1;
        shooter.update();
        if (gamepad1.left_bumper && !lbPrev) {
            intake1.forward();
        }
        lbPrev = gamepad1.left_bumper;
        if (gamepad1.right_bumper && !rbPrev) {
            intake1.reverse();
            intake1.servoUp();
        }
        rbPrev = gamepad1.right_bumper;
        if (!gamepad1.left_bumper && !gamepad1.right_bumper) {
            intake1.stop();
            intake1.servoDown();
        }
        intake1.update();
        if (gamepad1.dpad_left) {
          turret.left();
       } else if (gamepad1.dpad_right) {
            turret.right();
        } else {
           turret.stop();
        }

        telemetry.update();
    }
}

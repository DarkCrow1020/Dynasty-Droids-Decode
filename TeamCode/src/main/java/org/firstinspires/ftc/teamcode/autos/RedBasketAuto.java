package org.firstinspires.ftc.teamcode.autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.BezierLine;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.Path;
import com.pedropathing.paths.PathChain;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;


@Autonomous(name = "Red Basket Auto", group = "Autonomous")
public class RedBasketAuto extends OpMode {

    private Follower follower;

    private final Pose startPose = new Pose(0, 0, 0);
    private final Pose shootPose = new Pose(24, 0, 0);
    private final Pose parkPose = new Pose(12, 12, Math.toRadians(90));

    private PathChain autoPath;

    @Override
    public void init() {
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(startPose);

        autoPath = follower.pathBuilder()
                .addPath(new Path(new BezierLine(startPose, shootPose)))
                .setLinearHeadingInterpolation(startPose.getHeading(), shootPose.getHeading())

                .addPath(new Path(new BezierLine(shootPose, parkPose)))
                .setLinearHeadingInterpolation(shootPose.getHeading(), parkPose.getHeading())

                .build();
    }

    @Override
    public void start() {
        follower.followPath(autoPath);
    }

    @Override
    public void loop() {
        follower.update();

        telemetry.addData("x", follower.getPose().getX());
        telemetry.addData("y", follower.getPose().getY());
        telemetry.addData("heading", Math.toDegrees(follower.getPose().getHeading()));
        telemetry.addData("busy", follower.isBusy());
        telemetry.update();
    }
}
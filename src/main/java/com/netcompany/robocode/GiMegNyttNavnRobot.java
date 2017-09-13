package com.netcompany.robocode;

import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.RateControlRobot;
import robocode.ScannedRobotEvent;

/**
 * Gi denne klassen et nytt navn: Høyreklikk (over klassenavn) > Refactor > Rename.
 */
public class GiMegNyttNavnRobot extends RateControlRobot {
    private double moveDirection = 1;

    @Override
    public void run() {
        while (true) {
            setVelocityRate(10 * moveDirection);
            setRadarRotationRate(10);
            execute();
        }
    }

    @Override
    public void onScannedRobot(final ScannedRobotEvent event) {
        final double bearing = event.getBearing();
        turnRight(bearing);
        fire(3);
    }

    @Override
    public void onHitWall(final HitWallEvent event) {
        reverseDirection();
    }

    @Override
    public void onHitRobot(final HitRobotEvent event) {
        reverseDirection();
    }

    private void reverseDirection() {
        moveDirection = -1 * moveDirection;
    }
}

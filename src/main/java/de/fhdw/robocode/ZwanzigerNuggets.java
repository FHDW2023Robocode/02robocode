package de.fhdw.robocode;

import java.awt.Color;
import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.Rules;
import robocode.ScannedRobotEvent;

public class ZwanzigerNuggets extends AdvancedRobot {
    boolean isScanned = false;
    double angle = 360.0;
    @Override
    public void run() {

        setBulletColor(Color.red);

        double radius = 100.0;
        double angle = 360.0;

        setAdjustRadarForRobotTurn(true);
        setAdjustRadarForGunTurn(true);
        setAdjustGunForRobotTurn(true);

        while (true) {
            turnLeft(5);
            turnRadarRight(360);
            ahead(80);
            turnRight(40);
//            turnLeft(angle);
//            fireBullet(1);
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        ahead(80);
        setTurnRadarRight(getHeading() - getRadarHeading() + e.getBearing());
        turnGunRight(getRadarHeading() - getGunHeading());
//        turnRadarLeft(5);
        if(getGunHeat() < 40 && getEnergy() > 10 ){
            fire(2);

        }

//        doNothing();
//        ahead(100);
//        fire(2);
    }

    public void onHitByBullet(HitByBulletEvent e) {
//        turnLeft(90 - e.getBearing());
        turnRight(Math.random()*200);
        ahead(100);

    }

    @Override
    public void onHitWall(HitWallEvent event) {
        turnRight(90);
        ahead(-100);
    }
}

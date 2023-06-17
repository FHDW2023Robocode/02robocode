package de.fhdw.robocode;

import java.awt.Color;
import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class ZwanzigerNuggets extends AdvancedRobot {

    @Override
    public void run() {

        setBulletColor(Color.red);

        double radius = 100.0;
        double angle = 360.0;


        while (true) {
            if(this.getAllEvents().isEmpty()) {
                turnLeft(5);
            }
//            turnLeft(angle);
//            fireBullet(1);
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        setTurnLeft(0);
        fireBullet(2);
//        doNothing();
//        ahead(100);
//        fire(2);
    }

    public void onHitByBullet(HitByBulletEvent e) {
//        turnLeft(90 - e.getBearing());
    }

}

package de.fhdw.robocode;

import java.awt.Color;
import robocode.AdvancedRobot;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.RobotDeathEvent;
import robocode.Rules;
import robocode.ScannedRobotEvent;

public class ZwanzigerNuggets extends AdvancedRobot {
    boolean isScanned = false;
    double angle = 360.0;

    String target = "";
    @Override
    public void run() {

        setBulletColor(Color.red);

        double radius = 100.0;
        double angle = 360.0;



        setAdjustRadarForRobotTurn(true);
        setAdjustRadarForGunTurn(true);
        setAdjustGunForRobotTurn(true);

        while (true) {
            setAhead(100);
            setTurnRight(30);
//            ahead(1000);
//            turnLeft(5);
            setTurnRadarRight(360);
            this.execute();
//            turnRight(40);
//            this.execute();
//            turnLeft(angle);
//            fireBullet(1);
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
//        if(this.target == ""){
//            this.target = e.getName();
//        }
//        if(e.getName() == this.target){
        System.out.println(e.getName());
            setTurnRadarRight(getHeading() - getRadarHeading() + e.getBearing());
            this.execute();
            setTurnGunRight(getRadarHeading() - getGunHeading());
        this.execute();
//        turnRadarLeft(5);
            if(getGunHeat() < 40 && getEnergy() > 10 ){
                setFire(2);
                this.execute();
            }
//        }
        this.execute();
//        doNothing();
//        ahead(100);
//        fire(2);

    }

    public void onHitByBullet(HitByBulletEvent e) {
        this.execute();
//        turnLeft(90 - e.getBearing());
//        turnRight(Math.random()*200);

    }

    @Override
    public void onHitWall(HitWallEvent event) {
        setTurnRight(180);
        this.execute();
    }

    @Override
    public void onRobotDeath(RobotDeathEvent event) {
//        if(event.getName() == this.target){
//            this.target = "";
//        }
        this.execute();
    }
}

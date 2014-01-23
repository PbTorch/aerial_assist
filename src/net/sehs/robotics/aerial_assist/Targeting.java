/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sehs.robotics.aerial_assist;

/**
 *
 * @author Luc Chartier
 */
public class Targeting {
    //Final doubles that are set with the creation of CatapultCalculator
    private final double towerH;
    private final double armFrontL;
    private final double armBackL;
    private final double ballW;
    private final double stopA;
    
    //Gravity Constant;
    private final double g = 32.2;
    
    //Mass of the ball;
    private final double ballM;
    
    public Targeting(double tempTowerH, double tempArmFrontL, double tempArmBackL, double tempBallW, double tempStopA){
        towerH = tempTowerH;
        armFrontL = tempArmFrontL;
        armBackL = tempArmBackL;
        ballW = tempBallW;
        stopA = tempStopA;
        ballM = ballW/32.2;
    }
    
    //Find the length of the spring by knowing the angle 'armA' and the two sides 'towerH' and 'armL'.
    //Uses law of Cosines to find the missing side (the length of the spring). Returns a double equal to the lenght of the spring.
    public double findSpringLenght(double armA){
        return (towerH + armBackL - Math.sqrt(2 * towerH * armBackL * Math.cos(Math.toRadians(armA))));
    }
    
    //Calcualtes the velocity needed to hit a target at a given hight 'y' at a given distance 'x' when lanched at the the preset lanch angle 'stopA'.
    public double velocityToHeight(double y, double x){
        //This formula only works when the launch angle 'stopA' is equal to 45 degrees.
        //return ( Math.sqrt( (g * Math.pow(y, 2) * ( ( ( 1 - Math.cos( 2 * Math.toRadians(stopA) ) ) / ( 1 - Math.cos( 2 * Math.toRadians(stopA) ) ) ) + 1 ) ) / ( x * Math.tan( Math.toRadians(stopA) ) - y ) ) / Math.sqrt(2) );
        
        //Testing out this formula (Mr.Hilty helped with its creation). 
        return ( Math.sqrt( 161/10 ) * Math.sqrt( x * ( 1 / Math.cos( Math.toRadians(stopA) ) ) ) / Math.sqrt( x * Math.tan( Math.toRadians(stopA) ) - y ));
    }
    
    //Calculates the force needed to launch a ball at the velocity given from 'velocityToHeight' with 'velocityToEnergy'.
    public double forceToHeight(double h, double s){
        return velocityToEnergy( velocityToHeight(h,s) );
    }
    
    //Using the law of cosines calculates the height of the arm when at the launch angle 'stopA'.
    public double launchHeight(){
        return ( (armFrontL/Math.sin( Math.toRadians(90) )) * Math.sin( Math.toRadians(stopA) ));
    }       
    
    //Calcuates the Energy required to launch the ball with a certaint velocity. 
    public double velocityToEnergy(double v){
        //Math.pow not work?
        //return ((2 * ((Math.pow(v, 2) * (1/2) *ballM ))) + (2 *ballM * g * launchHeight() ));
        return 0.0;
    }
}

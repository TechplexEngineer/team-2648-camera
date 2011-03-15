/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.camera.AxisCamera;

public class FRCLogoTEAM2648 extends SimpleRobot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    Jaguar l1, l2, r1, r2;
    RobotDrive drive;
    Joystick j1;

    public FRCLogoTEAM2648()
    {
        l1 = new Jaguar(1);
        l2 = new Jaguar(2);
        r1 = new Jaguar(3);
        r2 = new Jaguar(4);
        drive = new RobotDrive(l1, l2, r1, r2);
    }

    public void autonomous() {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        CameraSetup.InitializeCameraWhiteBalance(AxisCamera.getInstance());
        while(isOperatorControl())
        {
            drive.arcadeDrive(j1);
        }
    }
}

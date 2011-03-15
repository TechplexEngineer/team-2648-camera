/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;


public class CameraControl {
    Servo servoz;
    Servo servox;

    public CameraControl(Servo servo1, Servo servo2)
    {
        AxisCamera camera = AxisCamera.getInstance();

    }

    public void getImage(){
        while (true) {
            if (AxisCamera.getInstance().freshImage()) {
                System.out.println("Fresh image");
            }
            try {
                ColorImage image = AxisCamera.getInstance().getImage();
            } catch (AxisCameraException e) {
            } catch (NIVisionException e) {
            }
        }
    }

}
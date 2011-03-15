package edu.wpi.first.wpilibj.templates;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.image.*;


/**
 *
 * @author 3419
 */
public class CameraSetup {

    public static void InitializeCameraWhiteBalance(AxisCamera camera)
    {
        while(true)
        {
            ColorImage image = null;
            try
            {
                //camera.writeWhiteBalance(AxisCamera.WhiteBalanceT.automatic);
                //Timer.delay(12);
                //camera.writeWhiteBalance(AxisCamera.WhiteBalanceT.hold);
                image = camera.getImage();
                BinaryImage redMask = image.thresholdRGB(10, 20, 45, 55, 125, 145);
                ParticleAnalysisReport[] redObjects = redMask.getOrderedParticleAnalysisReports();
                int validItems = 0;
                for(int i = 0; i < redObjects.length; i++)
                {
                    if(redObjects[i].particleToImagePercent > 0.0001)
                    {
                        validItems++;
                    }
                    else
                    {
                        break;
                    }
                }
                System.out.println("Found " + validItems + " blue objects.");
                for(int i = 0; i < validItems; i++)
                {
                    System.out.println("Object " + i + " center (x,y):" + redObjects[i].center_mass_x + "," + redObjects[i].center_mass_y);
                }

                Timer.delay(2);

            }
            catch(Exception e)
            {

            }
            finally
            {
                try
                {
                    image.free();
                }
                catch(Exception e)
                {

                }
            }
        }

        /*
        System.out.println("ColorLevel = " + camera.getColorLevel() + ", Brightness = " + camera.getBrightness() + ", Compression = " + camera.getCompression());
        camera.writeWhiteBalance(AxisCamera.WhiteBalanceT.automatic);
        Timer.delay(10);
        camera.writeWhiteBalance(AxisCamera.WhiteBalanceT.hold);
        System.out.println("ColorLevel = " + camera.getColorLevel() + ", Brightness = " + camera.getBrightness() + ", Compression = " + camera.getCompression());
        */

    }

}
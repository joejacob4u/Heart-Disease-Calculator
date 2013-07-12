import java.awt.Frame;
import java.awt.Image;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.GrayFilter;
import javax.swing.JFrame;

import org.openimaj.image.ImageUtilities;
import org.openimaj.video.capture.Device;
import org.openimaj.video.capture.VideoCapture;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamDriver;
import com.github.sarxos.webcam.WebcamPanel;


public class Camera {
	
	
public boolean setStart() throws IOException
{
	List<Device> devices = VideoCapture.getVideoDevices();
    System.out.println(String.format("Found %d devices", devices.size()));

    for (Device device : devices) {

        System.out.println(String.format("Create video capture for device %s %s", device.getNameStr(), device.getIdentifierStr()));
        VideoCapture capture = new VideoCapture(320, 240, device);

        System.out.println("Create buffer");
        int i = 0;
        do {
            capture.getNextFrame();
            System.out.println("wait...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        } while (++i < 3);

        System.out.println("Get image");
        BufferedImage img = ImageUtilities.createBufferedImageForDisplay(capture.getCurrentFrame());
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);  
        ColorConvertOp op = new ColorConvertOp(cs, null);  
        BufferedImage image = op.filter(img, null);
        System.out.println("Stop capture");
        capture.stopCapture();

        System.out.println("Close");
        capture.close();

        System.out.println("Store image in test1.jpg");
        ImageIO.write(image, "JPG", new File("test1.jpg"));
        return true;
}
	return false;
}
}

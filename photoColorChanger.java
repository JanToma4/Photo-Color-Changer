/**
       *  Program 3a
       *  Description: Class that reads he image in the file then change the img 
       *  to Grayscale, Red, BLue, and Green, then it makes a new file with the 
       *  new img and gives it a name appropriate for the color it changed to
       *  CS108-3
       *  3/7/16
       *  @author  Jan Toma
       */
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Prog3a {
	//Program 3a, [Jan Toma], [masc1596]	
	private BufferedImage img = null;
	private String imgReader;
	private String color = null;
	
	//Reads the file and takes the image in it, if there is no file of the name inputted
	//it will throw out and exception
	public void readImage(String imgRead) throws IOException {
		File f1 = null;
		imgReader = imgRead;
		try {
			f1 = new File(imgReader);
			
			if (!f1.canRead())
				throw new IOException("Cannot Read File: " + f1.getPath());
			img = ImageIO.read(f1);
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
		}
	}
	
	//This creates a new file with the newly change image
	public void writeImage() throws IOException {
		File f2 = null;
		try {
			f2 =  new File(appendColorToOutput());
			ImageIO.write(img, "jpg", f2);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	//Tests for RGB
	public void test(int x, int y){
		int p = img.getRGB(x,y);
		
		int red = (p>>16)&0xff;
		int green = (p>>8)&0xff;
		int blue = p&0xff;
		
		System.out.println("RGB: " + red + ", " + green + ", " + blue);
	}
	
	//Changes the color of the img to Grayscale 
	public void toGrayscale() {
		for(int i = 0; i < img.getWidth(); i++) {
			for(int j = 0; j < img.getHeight(); j++) {
				int p = img.getRGB(i,j);
				
				int trans = (p>>24)&0xff;
				int red = (p>>16)&0xff;
				int green = (p>>8)&0xff;
				int blue= p&0xff;
				
				int avg = (red + green + blue) / 3;
				
				p = (trans<<24) | (avg<<16) | (avg<<8) | (avg);
				img.setRGB(i, j, p);
			}
		}
		color = "Grayscale"; 
	}

	//Changes the color of the img to Red
	public void toRed() {
		for(int i = 0; i < img.getWidth(); i++) {
			for(int j = 0; j < img.getHeight(); j++) {
				int p = img.getRGB(i,j);
				p = p & 0xffff0000;
				img.setRGB(i, j, p);
			}
		}
		color = "Red";
	}

	//Changes the color of the img to Green
	public void toGreen() {
		for(int i = 0; i < img.getWidth(); i++) {
			for(int j = 0; j < img.getHeight(); j++) {
				int p = img.getRGB(i,j);
				p = p & 0xff00ff00;
				img.setRGB(i, j, p);
			}
		}
		color = "Green";
	}

	//Changes the color of the img to Blue
	public void toBlue() {
		for(int i = 0; i < img.getWidth(); i++) {
			for(int j = 0; j < img.getHeight(); j++) {
				int p = img.getRGB(i,j);
				p = p & 0xff0000ff;
				img.setRGB(i, j, p);
			}
		}
		color = "Blue";
	}
    
    //Changes the image to Orange
	/**
	 * @toOrange - converts the image into all orange rgb values
	 */
	public void toOrange() {
		for(int i = 0; i < img.getWidth(); i++) {
			for(int j = 0; j < img.getHeight(); j++) {
				int p = img.getRGB(i,j);
				p = p & 0xffff8000;
				img.setRGB(i, j, p);
			}
		}
		color = "Orange";
	}
	//Changes the image to Yellow
	/**
	 * @toYellow - converts the image into all yellow rgb values
	 */
	public void toYellow() {
		for(int i = 0; i < img.getWidth(); i++) {
			for(int j = 0; j < img.getHeight(); j++) {
				int p = img.getRGB(i,j);
				p = p & 0xffffff00;
				img.setRGB(i, j, p);
			}
		}
		color = "Yellow";
	}
	//Changes the image to Purple
	/**
	 * @toPurple - converts the image into all purple rgb values
	 */
	public void toPurple() {
		for(int i = 0; i < img.getWidth(); i++) {
			for(int j = 0; j < img.getHeight(); j++) {
				int p = img.getRGB(i,j);
				p = p & 0xffff00ff;
				img.setRGB(i, j, p);
			}
		}
		color = "Purple";
    }
	
	//Prints out the new name of the file Ex:(imgColor.jpg)
	private String appendColorToOutput() {
		return imgReader.substring(0, imgReader.lastIndexOf("."))
				+ color
				+ imgReader.substring(imgReader.lastIndexOf("."));
	}
}
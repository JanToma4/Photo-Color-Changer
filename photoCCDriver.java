/**
       *  Program EC1 - Driver
       *  Description: Calls the method in RGBConversion and OYPConversion and changes the
       *  image to GrayScale, Red, Green, Blue, Orange, Yellow, and Purple.
       *  CS108-3
       *  3/25/16
       *  @author  Jan Toma
       */
import java.io.IOException;
import java.util.Scanner;

public class OYPConversionClient {
	//Program 3b, [Jan Toma], [masc1596]	
	public static void main(String [] args) throws IOException {
		RGBConversion cc = new RGBConversion();
		OYPConversion ccc = new OYPConversion();
		Scanner input = new Scanner(System.in);
		String imgFile = input.next();
		
		int x = 60;
		int y = 60;
		//Calls the methods in RGBConversion and OYPConversion
		System.out.println("Program EC1, Jan Toma, masc1596");
		cc.readImage(imgFile); //Turns to Grayscale
		cc.test(x, y);
		cc.toGrayscale();
		cc.test(x, y);
		cc.writeImage();
		cc.readImage(imgFile); //Turns to Red
		cc.test(x, y);
		cc.toRed();
		cc.test(x, y);
		cc.writeImage();
		cc.readImage(imgFile); //Turns to Green
		cc.test(x, y);
		cc.toGreen();
		cc.test(x, y);
		cc.writeImage();
		cc.readImage(imgFile); //Turns to Blue
		cc.test(x, y);
		cc.toBlue();
		cc.test(x, y);
		cc.writeImage();
		ccc.readImage(imgFile); //Turns to Orange
		ccc.test(x, y);
		ccc.toOrange();
		ccc.test(x, y);
		ccc.writeImage();
		ccc.readImage(imgFile); //Turns to Yellow
		ccc.test(x, y);
		ccc.toYellow();
		ccc.test(x, y);
		ccc.writeImage();
		ccc.readImage(imgFile); //Turns to purple
		ccc.test(x, y);
		ccc.toPurple();
		ccc.test(x, y);
		ccc.writeImage();
		input.close(); //Closes the Scanner

	}
}

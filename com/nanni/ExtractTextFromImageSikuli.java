/**
 * @author Sunil Jayaprakash aka Nanni Sunil
 * 
 * (sunil.jayaprakash@gmail.com, jinnu.wordpress.com)
 * 
 * Description : Sikuli is a wonderful tool for automating workflows.
 * Sikuli now has OCR functionalities and uses tesseract in the backend.
 * For more Info on Sikuli kindly refer to http://sikuli.org
 * 
 * Problem Background : Sikuli has concept of Region, Pattern, Screen and Match.
 * However, its not possible to create a Virtual Region for an image stored 
 * in file system. It always creates a Region using "Current Screen Co-ordinates".
 * 
 * I wanted to extract text from image stored in file system. It was not possible
 * using the sikuli script. However, I wrote a Java program that uses
 * Sikuli jars and achieve the functionality.
 *
 * 
 * Discussions
 * 
 * https://answers.launchpad.net/sikuli/+question/188121
 * https://answers.launchpad.net/sikuli/+question/188070
 * 
 * Bug Reference - https://bugs.launchpad.net/sikuli/+bug/935946
 * 
 * 
 * @author Sunil Jayaprakash aka Nanni Sunil
 * (sunil.jayaprakash@gmail.com)
 * 
 *  Copyright : Free for commercial and non-commercial usage. Send me a message 
 *  if you want to use. Keep the comments intact. 
 */
package com.nanni;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import org.sikuli.script.TextRecognizer;

public class ExtractTextFromImageSikuli {

	/**
	 * Convert an Image to BufferedImage for feeding into Sikuli OCR.
	 * 
	 * @param image
	 * @return BufferedImage
	 */
	private static BufferedImage getBufferedImageFromImage(Image image) {

		Image temp = new ImageIcon(image).getImage();
		BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null),
				temp.getHeight(null), BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferedImage.createGraphics();
		g.drawImage(temp, 0, 0, null);
		g.dispose();
		return bufferedImage;
	}

	public static void main(String[] args) {

		Image img = Toolkit.getDefaultToolkit().createImage(
				args[0]);
		BufferedImage brimage = getBufferedImageFromImage(img);
		TextRecognizer tr = TextRecognizer.getInstance();
		String s = tr.recognize(brimage);
		System.out.println(s);

	}
}

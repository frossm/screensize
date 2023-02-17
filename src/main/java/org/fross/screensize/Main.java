/******************************************************************************
 * ScreenSize
 * 
 * Retrieves the screen size in pixels
 * 
 *  Copyright (c) 2023 Michael Fross
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *           
 ******************************************************************************/
package org.fross.screensize;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import java.time.Year;
import java.util.Properties;

public class Main {
	// Class Constants
	public static final String PROPERTIES_FILE = "app.properties";
	public static final int CURRENTYEAR = Year.now().getValue();

	// Class Variables
	public static String VERSION;
	public static String COPYRIGHT;

	public static void main(String[] args) {
		// Process application level properties file
		// Update properties from Maven at build time:
		// Ref: https://stackoverflow.com/questions/3697449/retrieve-version-from-maven-pom-xml-in-code
		try {
			InputStream iStream = Main.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE);
			Properties prop = new Properties();
			prop.load(iStream);
			VERSION = prop.getProperty("Application.version");
			COPYRIGHT = "Copyright (C) " + prop.getProperty("Application.inceptionYear") + "-" + CURRENTYEAR + " by Michael Fross";
		} catch (IOException ex) {
			System.out.println("FATAL ERROR:\nUnable to read property file '" + PROPERTIES_FILE + "'");
		}

		// Process the command line
		CommandLineArgs cli = new CommandLineArgs(args);

		// Show Help and Exit
		if (cli.clHelp == true) {
			Help.Display();
			System.exit(0);
		}

		// Version Display
		if (cli.clVersion == true) {
			Help.DisplayVersion();
			System.exit(0);
		}

		// License Display
		if (cli.clLicense == true) {
			Help.DisplayLicense();
			System.exit(0);
		}

		Dimension size = new Dimension();
		try {
			size = Toolkit.getDefaultToolkit().getScreenSize();
		} catch (HeadlessException ex) {
			System.out.println("FATAL ERROR:\nUnable to get screen size information");
			System.exit(1);
		}

		if (cli.clWidth == true) {
			System.out.println(size.width);

		} else if (cli.clHeight == true) {
			System.out.println(size.height);

		} else {
			System.out.println(size.width + " " + size.height);
		}

	}
}

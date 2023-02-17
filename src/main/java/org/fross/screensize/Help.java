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

/**
 * Help(): Display the help page
 * 
 * @author Michael Fross (michael@fross.org)
 *
 */
public class Help {
	/**
	 * Display(): Show help information
	 */
	public static void Display() {
		System.out.println("ScreenSize v" + Main.VERSION);
		System.out.println(Main.COPYRIGHT);

		System.out.println("Default display is the 'width' 'height'");

		System.out.println("\nCommand Line Options:");
		System.out.println(" -x | --width     Display screen width");
		System.out.println(" -y | --height    Display screen height");
		System.out.println(" -h | --help      Show this help information");
		System.out.println(" -v | --version   Display version information as well as latest GitHub release");
		System.out.println(" -L | --license   Display program usage license");

	}

	/**
	 * DisplayVersion(): Show the current version and exit
	 */
	public static void DisplayVersion() {
		System.out.println("v" + Main.VERSION);
		System.exit(0);
	}

	/**
	 * DisplayLicense(): Simply display the software usage license and return
	 * 
	 */
	public static void DisplayLicense() {
		String licenseText = "MIT License\n\n"

				+ "Copyright (c) " + Main.CURRENTYEAR + " Michael Fross\n\n"

				+ "Permission is hereby granted, free of charge, to any person obtaining a copy\n"
				+ "of this software and associated documentation files (the \"Software\"), to deal\n"
				+ "in the Software without restriction, including without limitation the rights\n"
				+ "to use, copy, modify, merge, publish, distribute, sublicense, and/or sell\n"
				+ "copies of the Software, and to permit persons to whom the Software is\n" + "furnished to do so, subject to the following conditions:\n\n"

				+ "The above copyright notice and this permission notice shall be included in all\n" + "copies or substantial portions of the Software.\n\n"

				+ "THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR\n"
				+ "IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,\n"
				+ "FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE\n"
				+ "AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER\n"
				+ "LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,\n"
				+ "OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE\n" + "SOFTWARE.\n";

		System.out.println(licenseText);
	}
}

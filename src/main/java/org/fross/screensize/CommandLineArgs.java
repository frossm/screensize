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

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

public class CommandLineArgs {
	// ---------------------------------------------------------------------------------------------
	// Define command line options that can be used
	// ---------------------------------------------------------------------------------------------

	@Parameter(names = { "-h", "-?", "--help" }, help = true, description = "Display RPNCalc help and exit")
	protected boolean clHelp = false;

	@Parameter(names = { "-v", "--version" }, description = "Show current program version and latest release on GitHub")
	protected boolean clVersion = false;

	@Parameter(names = { "-L", "--license" }, description = "Display program usage license")
	protected boolean clLicense = false;

	@Parameter(names = { "-x", "--width" }, description = "Display the default display width (x)")
	protected boolean clWidth = false;

	@Parameter(names = { "-y", "--height" }, description = "Display the default display height (y)")
	protected boolean clHeight = false;

	// Constructors
	public CommandLineArgs() {
		
	}
	public CommandLineArgs(String[] args) {
		this.ProcessCommandLine(args);
	}

	// ---------------------------------------------------------------------------------------------
	// Process command line parameters with the following methods
	// ---------------------------------------------------------------------------------------------
	public void ProcessCommandLine(String[] argv) {
		JCommander jc = new JCommander();

		// JCommander parses the command line
		try {
			jc.setProgramName("ScreenSize");
			jc = JCommander.newBuilder().addObject(this).build();
			jc.parse(argv);
		} catch (ParameterException ex) {
			System.out.println(ex.getMessage());
			jc.usage();
			System.exit(0);
		}

	}
}
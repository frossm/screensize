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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author Michael Fross (michael@fross.org)
 *
 */
class CommandLineArgsTest {

	/**
	 * Test method for {@link org.fross.rpncalc.CommandLineArgs#ProcessCommandLine(java.lang.String[])}.
	 */
	@Test
	void testShortCommandLineArgs() {
		// Test Short Options
		String[] argv = { "-h", "-v", "-L", "-x", "-y" };

		CommandLineArgs cli = new CommandLineArgs(argv);

		assertTrue(cli.clHelp);
		assertTrue(cli.clVersion);
		assertTrue(cli.clLicense);
		assertTrue(cli.clWidth);
		assertTrue(cli.clHeight);
	}

	@Test
	void testLongCommandLineArgs() {
		// Test Long Options
		String[] argv = { "--help", "--license", "--version", "--width", "--height" };

		CommandLineArgs cli = new CommandLineArgs(argv);

		assertTrue(cli.clHelp);
		assertTrue(cli.clLicense);
		assertTrue(cli.clVersion);
		assertTrue(cli.clWidth);
		assertTrue(cli.clHeight);
	}

	@Test
	void testUnsetFlags() {
		// Test Long Options
		String[] argv = { "-v" };

		CommandLineArgs cli = new CommandLineArgs(argv);

		assertFalse(cli.clHelp);
		assertFalse(cli.clLicense);
		assertTrue(cli.clVersion);
		assertFalse(cli.clWidth);
		assertFalse(cli.clHeight);
	}

	@Test
	void testMixedCommandLineArgs1() {
		// Test Mix of Options
		String[] argv = { "-h", "--width" };

		CommandLineArgs cli = new CommandLineArgs(argv);

		assertTrue(cli.clHelp);
		assertFalse(cli.clLicense);
		assertFalse(cli.clVersion);
		assertTrue(cli.clWidth);
		assertFalse(cli.clHeight);
	}

	@Test
	void testMixedCommandLineArgs2() {
		// Test Mix of Options
		String[] argv = { "-L", "--height", "--help", "-v" };

		CommandLineArgs cli = new CommandLineArgs(argv);

		assertTrue(cli.clLicense);
		assertTrue(cli.clHeight);
		assertTrue(cli.clHelp);
		assertTrue(cli.clVersion);
		assertFalse(cli.clWidth);
	}
}
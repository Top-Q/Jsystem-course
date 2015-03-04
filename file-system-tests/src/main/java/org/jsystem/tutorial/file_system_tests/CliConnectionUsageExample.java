package org.jsystem.tutorial.file_system_tests;

import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;

import org.junit.Before;
import org.junit.Test;

import com.aqua.sysobj.conn.CliCommand;
import com.aqua.sysobj.conn.CliConnectionImpl;

public class CliConnectionUsageExample extends SystemTestCase4 {

	private CliConnectionImpl cliConnection;
	private String commandStr;

	@Before
	public void setUp() throws Exception {
		cliConnection = (CliConnectionImpl) system.getSystemObject("cliConnection");
	}

	@Test
	@TestProperties(name = "Perform cli command 'command'", paramsInclude = { "commandStr" })
	public void performCliCommand() throws Exception {
		CliCommand cliCommand = new CliCommand(commandStr);
		cliConnection.handleCliCommand("Performing command: " + commandStr, cliCommand);
		report.report(String.valueOf(cliConnection.getTestAgainstObject()));
	}

}

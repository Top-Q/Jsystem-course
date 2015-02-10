package org.jsystem.tutorial.file_system_tests;

import java.io.File;
import java.io.IOException;

import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;

import org.junit.Test;

/**
 * Provides building blocks for performing file system operations on local
 * machine
 * 
 * @author Itai Agmon
 *
 */
public class LocalFileSystemOperations extends SystemTestCase4 {

	private String tempFile, prefix, suffix;

	/**
	 * Create temporary file with the specified prefix and suffix. Return the
	 * full path of the newly created file.
	 * 
	 */
	@Test
	@TestProperties(name = "Local - Create temp file with prefix '${prefix}' and suffix '${suffix}'", paramsInclude = {
			"prefix", "suffix" }, returnParam = { "tempFile" })
	public void createTempFile() throws IOException {
		tempFile = File.createTempFile(prefix, suffix).getAbsolutePath();
	}

	public String getPrefix() {
		return prefix;
	}

	@ParameterProperties(description = "Temp file prefix")
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	@ParameterProperties(description = "Temp file suffix")
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getTempFile() {
		return tempFile;
	}

	public void setTempFile(String tempFile) {
		this.tempFile = tempFile;
	}

}

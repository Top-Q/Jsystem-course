package org.jsystem.tutorial.file_system_tests;

import java.io.File;
import java.io.IOException;

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

	private String prefix, suffix;

	/**
	 * Create temporary file with the specified prefix and suffix. Return the
	 * full path of the newly created file.
	 * 
	 */
	@Test
	public void createTempFile() throws IOException {
		File.createTempFile(prefix, suffix);
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

}

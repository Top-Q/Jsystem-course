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

	private static final String REPOSITORY_FOLDER = "c:\\";
	
	private String tempFile, prefix, suffix;


	@Test
	@TestProperties(name = "Local - Create temp file with prefix '${prefix}' and suffix '${suffix}'", paramsInclude = {
			"prefix", "suffix" }, returnParam = { "tempFile" })
	public void createTempFile() throws IOException {
		tempFile = File.createTempFile(prefix, suffix).getAbsolutePath();
	}
	
	public void writeToFile() throws IOException {
//		final Path filePath = Paths.get(file.getAbsolutePath());
//		Files.write(filePath, content.getBytes(), append ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
	}
	
	public void copyFile() throws IOException {
//		Files.copy(Paths.get(sourceFile.getAbsolutePath()), Paths.get(destinationFile.getAbsolutePath()), copyOption);
	}
	
	public void copyFileFromRepository() throws IOException {
//		Path sourcePath = Paths.get(REPOSITORY_FOLDER + "/" + fileFromRepository);
//		Path destinationPath = Paths.get(destinationFile.getAbsolutePath());
//		if (copyOption != null) {
//			Files.copy(sourcePath, destinationPath, copyOption);
//		} else {
//			Files.copy(sourcePath, destinationPath);
//		}
	}
	
	public void createMultipleFiles() throws Exception {
//		for (FileAttributes attr : fileAttributesArr) {
//			Path filePath = Paths.get(attr.getFolder() + "/" + attr.getName());
//			Files.write(filePath, attr.getContent().getBytes(),
//					StandardOpenOption.CREATE);
//			File file = new File(filePath.toString());
//			if (attr.isReadOnly()) {
//				file.setReadOnly();
//			}
//		}

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

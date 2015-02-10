package org.jsystem.file_system_so;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;

import jsystem.framework.system.SystemObjectImpl;

public class LocalFileSystem extends SystemObjectImpl {
	
	/**
	 * The location of the file repository folder. This is the folder that will
	 * be used in the <i>copyFileFromTheRepository</i> method
	 */
	private String repositoryFolder;
	
	public String createTempFile(String prefix, String suffix) throws IOException {
		return null;
	}

	/**
	 * Create multiple files according to user preferences.
	 */
	public void createMultipleFiles(FileAttributes[] fileAttributesArr) throws Exception {
	}

	/**
	 * Write specified content to file.
	 * 
	 */
	public void writeToFile(File file, String content, boolean append) throws IOException {

	}

	/**
	 * Copy the specified source file to the specified destination. Notice that
	 * you can specify additional options.
	 */
	public void copyFile(File sourceFile, File destinationFile, CopyOption copyOption) throws IOException {

	}



	public void copyFileFromRepository(String fileFromRepository, File destinationFile, CopyOption copyOption)
			throws IOException {
	}



	public String getRepositoryFolder() {
		return repositoryFolder;
	}

	public void setRepositoryFolder(String repositoryFolder) {
		this.repositoryFolder = repositoryFolder;
	}
	
	
	
}

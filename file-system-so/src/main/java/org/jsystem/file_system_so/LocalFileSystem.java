package org.jsystem.file_system_so;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import jsystem.framework.report.ReporterHelper;
import jsystem.framework.system.SystemObjectImpl;

public class LocalFileSystem extends SystemObjectImpl {

	/**
	 * The location of the file repository folder. This is the folder that will
	 * be used in the <i>copyFileFromTheRepository</i> method
	 */
	private String repositoryFolder;

	public String createTempFile(String prefix, String suffix) throws IOException {
		report.step("About to create temporary file");
		String tempFile = File.createTempFile(prefix, suffix).getAbsolutePath();
		report.report("Created file with name: " + tempFile);
		return tempFile;
	}

	/**
	 * Create multiple files according to user preferences.
	 */
	public void createMultipleFiles(FileAttributes[] fileAttributesArr) throws Exception {
		report.step("About to create multiple files");
		if (null == fileAttributesArr || fileAttributesArr.length == 0) {
			report.report("No file attributes were specified by user", 2);
			return;
		}
		report.startLevel("Crating multiple files");
		try {
			for (FileAttributes attr : fileAttributesArr) {
				Path filePath = Paths.get(attr.getFolder() + "/" + attr.getName());
				report.report("About to create file " + filePath);
				Files.write(filePath, attr.getContent().getBytes(), StandardOpenOption.CREATE);
				File file = new File(filePath.toString());
				if (attr.isReadOnly()) {
					file.setReadOnly();
				}
				ReporterHelper.copyFileToReporterAndAddLink(report, file, attr.getName());
			}

		} finally {
			report.stopLevel();
		}
	}

	/**
	 * Write specified content to file.
	 * 
	 */
	public void writeToFile(File file, String content, boolean append) throws IOException {
		report.step("About to write content to file");
		report.report("File content", content, true);
		final Path filePath = Paths.get(file.getAbsolutePath());
		Files.write(filePath, content.getBytes(), append ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
	}

	/**
	 * Copy the specified source file to the specified destination. Notice that
	 * you can specify additional options.
	 */
	public void copyFile(File sourceFile, File destinationFile, CopyOption copyOption) throws IOException {
		report.step("About to copy file");
		Files.copy(Paths.get(sourceFile.getAbsolutePath()), Paths.get(destinationFile.getAbsolutePath()), copyOption);
	}

	public void copyFileFromRepository(String fileFromRepository, File destinationFile, CopyOption copyOption)
			throws IOException {
		report.step("About to copy file from the repository");
		Path sourcePath = Paths.get(repositoryFolder + "/" + fileFromRepository);
		Path destinationPath = Paths.get(destinationFile.getAbsolutePath());
		if (copyOption != null) {
			Files.copy(sourcePath, destinationPath, copyOption);
		} else {
			Files.copy(sourcePath, destinationPath);
		}
	}

	public String getRepositoryFolder() {
		return repositoryFolder;
	}

	public void setRepositoryFolder(String repositoryFolder) {
		this.repositoryFolder = repositoryFolder;
	}

}

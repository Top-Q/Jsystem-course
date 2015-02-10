package org.jsystem.tutorial.file_system_tests;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import jsystem.framework.scenario.UseProvider;
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
	
	public enum FileOrFolder {
		FILE, FOLDER
	}
	
	private FileOrFolder fileOrFolder;
	
	private StandardCopyOption copyOption;
	
	private String tempFile, prefix, suffix, content, fileFromRepository;

	private File file, sourceFile, destinationFile;

	private boolean append, emptyBeforeDeleting;

	private FileAttributes[] fileAttributesArr;


	@Test
	@TestProperties(name = "Local - Create temp file with prefix '${prefix}' and suffix '${suffix}'", paramsInclude = {
			"prefix", "suffix" }, returnParam = { "tempFile" })
	public void createTempFile() throws IOException {
		tempFile = File.createTempFile(prefix, suffix).getAbsolutePath();
	}
	
	/**
	 * Write specified content to file.
	 * 
	 */
	@Test
	@TestProperties(name = "Local - Write content to file '${file}'", paramsInclude = { "file", "content", "append" })
	public void writeToFile() throws IOException {
		final Path filePath = Paths.get(file.getAbsolutePath());
		Files.write(filePath, content.getBytes(), append ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);

	}
	
	/**
	 * Copy the specified source file to the specified destination. Notice that
	 * you can specify additional options.
	 */
	@Test
	@TestProperties(name = "Local - Copy file '${sourceFile}' to '${destinationFile}'", paramsInclude = { "sourceFile",
			"destinationFile", "copyOption" })
	public void copyFile() throws IOException {
		Files.copy(Paths.get(sourceFile.getAbsolutePath()), Paths.get(destinationFile.getAbsolutePath()), copyOption);
	}

	
	@Test
	@TestProperties(name = "Local - Copy file '${fileFromRepository}' to '${destinationFile}'", paramsInclude = {
			"fileFromRepository", "destinationFile", "copyOption" })
	public void copyFileFromRepository() throws IOException {
		Path sourcePath = Paths.get(REPOSITORY_FOLDER + "/" + fileFromRepository);
		Path destinationPath = Paths.get(destinationFile.getAbsolutePath());
		if (copyOption != null) {
			Files.copy(sourcePath, destinationPath, copyOption);
		} else {
			Files.copy(sourcePath, destinationPath);
		}
	}
	
	/**
	 * Create multiple files according to user preferences.
	 */
	@Test
	@TestProperties(name = "Local - Create multiple files", paramsInclude = { "fileAttributesArr" })
	public void createMultipleFiles() throws Exception {
		for (FileAttributes attr : fileAttributesArr) {
			Path filePath = Paths.get(attr.getFolder() + "/" + attr.getName());
			Files.write(filePath, attr.getContent().getBytes(),
					StandardOpenOption.CREATE);
			File file = new File(filePath.toString());
			if (attr.isReadOnly()) {
				file.setReadOnly();
			}
		}

	}
	
	
	/**
	 * Delete file with specified name
	 * 
	 */
	@Test
	@TestProperties(name = "Local - Delete file or directory '${file}'", paramsInclude = { "file", "fileOrFolder",
			"emptyBeforeDeleting" })
	public void deleteFileOrDirectory() throws IOException {

	}


	/**** Setters and Getters method ****/

	public String getTempFile() {
		return tempFile;
	}

	public void setTempFile(String tempFile) {
		this.tempFile = tempFile;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public boolean isAppend() {
		return append;
	}

	public void setAppend(boolean append) {
		this.append = append;
	}

	public File getSourceFile() {
		return sourceFile;
	}

	@ParameterProperties(description = "Source file")
	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	public File getDestinationFile() {
		return destinationFile;
	}

	public void setDestinationFile(File destinationFile) {
		this.destinationFile = destinationFile;
	}

	public StandardCopyOption getCopyOption() {
		return copyOption;
	}

	@ParameterProperties(section = "Additional Options")
	public void setCopyOption(StandardCopyOption copyOption) {
		this.copyOption = copyOption;
	}

	public String getFileFromRepository() {
		return fileFromRepository;
	}

	public String[] getFileFromRepositoryOptions() {
		return new File(REPOSITORY_FOLDER).list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir, name).isFile();
			}

		});
	}

	public void setFileFromRepository(String fileFromRepository) {
		this.fileFromRepository = fileFromRepository;
	}

	public FileAttributes[] getFileAttributesArr() {
		return fileAttributesArr;
	}

	@UseProvider(provider = jsystem.extensions.paramproviders.ObjectArrayParameterProvider.class)
	public void setFileAttributesArr(FileAttributes[] fileAttributesArr) {
		this.fileAttributesArr = fileAttributesArr;
	}

	public FileOrFolder getFileOrFolder() {
		return fileOrFolder;
	}

	public void setFileOrFolder(FileOrFolder fileOrFolder) {
		this.fileOrFolder = fileOrFolder;
	}

	public boolean isEmptyBeforeDeleting() {
		return emptyBeforeDeleting;
	}

	public void setEmptyBeforeDeleting(boolean emptyBeforeDeleting) {
		this.emptyBeforeDeleting = emptyBeforeDeleting;
	}

	/*************/

}

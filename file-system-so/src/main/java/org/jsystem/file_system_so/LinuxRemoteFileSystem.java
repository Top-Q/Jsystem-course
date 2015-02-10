package org.jsystem.file_system_so;


/**
 * This system object provides different file system operations over a Possix
 * operating system.
 * 
 * @author Itai Agmon
 *
 */
public class LinuxRemoteFileSystem extends AbstractRemoteFileSystem {

	@Override
	public void copyFile(String sourceFolder, String sourceFile, String destinationFolder, String destinationFile)
			throws Exception {
		//Your implementation comes here
	}
	
	@Override
	public void createNewFile(String folder, String file) throws Exception {
	}

	@Override
	public void writeContentToFile(String folder, String file, String content, boolean append) throws Exception {
	}

	@Override
	public void deleteFile(String folder, String file) throws Exception {
	}

}

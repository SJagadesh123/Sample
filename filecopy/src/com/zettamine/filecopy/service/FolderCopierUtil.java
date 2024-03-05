package com.zettamine.filecopy.service;

import java.io.File;

public abstract class FolderCopierUtil implements FolderCopier {

	public void copyFolder(String sourceFolder, String destinationFolder) {
		
		File sourceDirectory = new File(sourceFolder);
		File destinationDirectory = new File(destinationFolder);
		
		if(!destinationDirectory.exists())
		{
			destinationDirectory.mkdir();
		}
		
		
		File[] files = sourceDirectory.listFiles();
		
		for(File file : files)
		{
		 	if (file.isDirectory()) {
                String sourceSubDir = sourceFolder + File.separator + file.getName();
                String destinationSubDir = destinationFolder + File.separator + file.getName();
                new File(destinationSubDir).mkdirs();
                replicate(sourceSubDir, destinationSubDir);
            } else {
                replicate(file.getAbsolutePath(), destinationFolder + File.separator + file.getName());
            } 
		}

	}
}



package com.zettamine.filecopy.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CharStreamFolderCopier extends FolderCopierUtil {

	@Override
	public void replicate(String sourcePath, String destinationPath) {
		
		 File file = new File(sourcePath);
		 
		 if(file.isDirectory())
		 {
			 copyFolder(sourcePath, destinationPath);
		 }

		try (Reader fis = new FileReader(sourcePath); Writer fos = new FileWriter(destinationPath)) {

			char[] buffer = new char[Integer.MAX_VALUE];

			int data = fis.read(buffer);

			while (data != -1) {
				fos.write(buffer);
				data = fis.read(buffer);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

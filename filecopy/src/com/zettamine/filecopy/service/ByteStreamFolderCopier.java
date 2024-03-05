package com.zettamine.filecopy.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreamFolderCopier extends FolderCopierUtil {

    @Override
    public void replicate(String sourcePath, String destinationPath) {
        File file = new File(sourcePath);

        if (file.isDirectory()) {
            copyFolder(sourcePath, destinationPath);
        } else {
            try (InputStream fis = new FileInputStream(sourcePath);
                 OutputStream fos = new FileOutputStream(destinationPath)) {

                byte[] buffer = new byte[1024];
                int data = fis.read(buffer);

                while (data  != -1) {
                	System.out.println("111");
                    fos.write(buffer, 0, data);
                    data = fis.read(buffer);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

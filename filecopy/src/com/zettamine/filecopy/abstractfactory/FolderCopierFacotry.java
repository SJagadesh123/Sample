package com.zettamine.filecopy.abstractfactory;

import java.util.Optional;

import com.zettamine.filecopy.constants.AppConstants;
import com.zettamine.filecopy.service.ByteStreamFolderCopier;
import com.zettamine.filecopy.service.CharStreamFolderCopier;
import com.zettamine.filecopy.service.FolderCopier;

public class FolderCopierFacotry extends AbstractFactory {

	@Override
	public Optional<FolderCopier> getCopier(String copier) {
		
		if(copier.equalsIgnoreCase(AppConstants.BYTE_STREAM))
		{
			return Optional.of(new ByteStreamFolderCopier());
		}else if(copier.equalsIgnoreCase(AppConstants.CHAR_STREAM))
		{
			return Optional.of(new CharStreamFolderCopier());
		}
		
		
		return Optional.empty();
	}

	

	
}

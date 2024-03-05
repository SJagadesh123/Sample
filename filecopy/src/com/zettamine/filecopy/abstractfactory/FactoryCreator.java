package com.zettamine.filecopy.abstractfactory;

import java.util.Optional;

import com.zettamine.filecopy.constants.AppConstants;

public class FactoryCreator {
	
	 public static Optional<AbstractFactory> getFactory(String choice)
	 {
		 
		 if(choice.equalsIgnoreCase(AppConstants.FOLDER_COPIER))
		 {
			 return Optional.of(new FolderCopierFacotry());
		 }
		 return Optional.empty();
	 }

}

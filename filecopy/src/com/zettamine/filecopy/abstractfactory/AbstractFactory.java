package com.zettamine.filecopy.abstractfactory;

import java.util.Optional;

import com.zettamine.filecopy.service.FolderCopier;


public abstract class AbstractFactory {

	public abstract Optional<FolderCopier> getCopier(String string);
}

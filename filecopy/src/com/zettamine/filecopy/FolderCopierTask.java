package com.zettamine.filecopy;

import java.util.Optional;

import com.zettamine.filecopy.abstractfactory.AbstractFactory;
import com.zettamine.filecopy.abstractfactory.FactoryCreator;
import com.zettamine.filecopy.service.FolderCopier;

public class FolderCopierTask implements Runnable {

	private String[] args;

	public FolderCopierTask(String[] args) {
		super();
		this.args = args;
	}

	@Override
	public void run() {

		Optional<AbstractFactory> factoryOpt = FactoryCreator.getFactory("folder copier");

		if (factoryOpt.isEmpty()) {
			System.out.println("There is no factory present with 'folder copier'");
			return;
		}
		AbstractFactory abstractFactory = factoryOpt.get();

		Optional<FolderCopier> copierOpt = abstractFactory.getCopier("byte stream");

		if (copierOpt.isEmpty()) {
			System.out.println("There is no copier present with 'byte stream'");
			return;
		}

		FolderCopier folderCopier = copierOpt.get();

		System.out.println(args[0]);
		System.out.println(args[1]);
		folderCopier.replicate(args[0], args[1]);

		System.out.println("completed");
	}

}

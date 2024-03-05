package com.zettamine.filecopy;



public class DriverProgram {

	public static void main(String[] args) {

		if(args.length < 2)
		{
			System.out.println("Provide 2 arguments..");
			return;
		}
		
		Runnable task = new FolderCopierTask(args);
		
		Thread thread1 = new Thread(task);
		
		thread1.start();
		
		System.out.println("End of main method");
	}
}

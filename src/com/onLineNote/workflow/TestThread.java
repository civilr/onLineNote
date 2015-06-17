package com.onLineNote.workflow;

public class TestThread {
	
	public static void main(String[] args)
	{
		String[] array = new String[]{"a","b","c","d","e"};
		
		for(int i=0;i<array.length;i++)
		{
			SqlThread sqlThread = new SqlThread();
			
			sqlThread.setCount(i);
			
			Thread thread = new Thread(sqlThread,array[i]);
			
			thread.start();
			
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("end");
	}
	

}

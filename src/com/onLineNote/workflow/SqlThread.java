package com.onLineNote.workflow;


public class SqlThread implements Runnable {
	
	private int count;
	
	private boolean flag;

	public int getCount() {
		return count;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public synchronized void setCount(int count) {
		this.count = count;
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName());
		
		System.out.println(count);
		
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

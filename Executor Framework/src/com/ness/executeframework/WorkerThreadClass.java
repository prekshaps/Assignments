package com.ness.executeframework;

public class WorkerThreadClass implements Runnable {
	private String message;

	public WorkerThreadClass(String s) {
		this.message = s;
	}

	@Override
	public void run() { // TODO Auto-generated method stub
		System.out.println("Start: " + message);
		processmessage();
		System.out.println("End: " + message);

	}

	private void processmessage() {
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

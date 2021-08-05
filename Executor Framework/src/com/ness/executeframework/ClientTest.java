package com.ness.executeframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientTest {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		
			for (int i = 1; i <= 5; i++) {
				Runnable workerThrd = new WorkerThreadClass("Thread_"+i);
				executorService.execute(workerThrd);
			}
	

		executorService.shutdown();

		while (!executorService.isTerminated()) {
		}
		System.out.println("Finished all Threads");

	}

}

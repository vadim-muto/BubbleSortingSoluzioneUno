package application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import model.GameThread;

public class ThreadHandler {

	private static ThreadHandler instance = null;
	
	private ExecutorService executor;
	
	private ThreadHandler() {
		executor = Executors.newCachedThreadPool();
	}
	
	public static ThreadHandler getInstance() {
		if (instance == null)
			instance = new ThreadHandler();
		return instance;
	}
	
	public void addThread() {
		executor.submit(new GameThread());
	}
	
}

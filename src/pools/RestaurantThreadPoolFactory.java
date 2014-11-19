package pools;

import java.util.concurrent.ThreadFactory;


public class RestaurantThreadPoolFactory implements ThreadFactory {


	private int numThreadsCreated;
	private String name;

	
	public RestaurantThreadPoolFactory(String name) {
		this.name = name;
		this.numThreadsCreated = 1;
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setName(name+" #"+numThreadsCreated);
		numThreadsCreated++;
		return thread;
	}
	
}

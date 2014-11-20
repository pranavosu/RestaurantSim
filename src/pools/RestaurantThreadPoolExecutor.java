package pools;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class RestaurantThreadPoolExecutor extends ThreadPoolExecutor {

	public RestaurantThreadPoolExecutor(String name, int corePoolSize,
						int maximumPoolSize, long keepAliveTime, TimeUnit unit,
						BlockingQueue<Runnable> workQueue) {
		
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit,
			  workQueue, new RestaurantThreadPoolFactory(name));
		
	}

}

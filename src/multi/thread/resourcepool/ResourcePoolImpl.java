package multi.thread.resourcepool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ResourcePoolImpl<T> implements ResourcePool<T> {

	private static final String POOL_CLOSED = "ResourcePool is closed";

	// volatile variable to check if pool is open or not
	private volatile boolean open = false;

	// blockingqueue to add resources to pool
	private BlockingQueue<T> available = new LinkedBlockingQueue<T>();

	// concurrent map to keep aquiredResources, countdownlatch is used to keep threads waiting till resource is not released
	private ConcurrentMap<T, CountDownLatch> aquiredResources = new ConcurrentHashMap<T, CountDownLatch>();

	public T acquire() throws Exception {
		if (!isOpen()) {
			throw new Exception(POOL_CLOSED);
		}
		T resource = available.take();
		if (resource != null) {
			aquiredResources.put(resource, new CountDownLatch(1));
		}
		return resource;
	}

	public T acquire(long timeout, TimeUnit timeUnit) throws Exception {
		if (!isOpen()) {
			throw new Exception(POOL_CLOSED);
		}
		T resource = available.poll(timeout, timeUnit);
		if (resource != null) {
			aquiredResources.put(resource, new CountDownLatch(1));
		}
		return resource;
	}

	public boolean add(T resource) {
		return available.offer(resource);
	}

	public void close() throws Exception {
		open = false;
		for (CountDownLatch latch : aquiredResources.values()) {
			latch.await();
		}
	}

	public void closeNow() {
		open = false;
	}

	public boolean isOpen() {
		return open;
	}

	public void open() {
		open = true;
	}

	public void release(T resource) {
		CountDownLatch latch = aquiredResources.get(resource);
		available.add(resource);
		latch.countDown();
	}

	public boolean remove(T resource) throws Exception {
		CountDownLatch latch = aquiredResources.get(resource);
		latch.await();
		return available.remove(resource);
	}

	public boolean removeNow(final T resource) {
		return available.remove(resource);
	}
}
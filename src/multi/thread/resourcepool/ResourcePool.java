package multi.thread.resourcepool;

import java.util.concurrent.TimeUnit;

public interface ResourcePool<T> {
    
    T acquire() throws Exception;
    
    T acquire( long timeout, TimeUnit timeUnit ) throws Exception;
    
    boolean add( T resource );
    
    void close() throws Exception;
    
    void closeNow();
    
    boolean isOpen();
    
    void open();
    
    void release( T resource );
    
    boolean remove( T resource ) throws Exception;
    
    boolean removeNow( T resource );
}
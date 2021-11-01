package caching;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimedCache {

    final int capacity;
    Map<String, Object> map;
    ScheduledExecutorService scheduledExecutorService;


    public TimedCache(int capacity) {
        this.capacity = capacity;
        this.map = Collections.synchronizedMap(new LinkedHashMap<String, Object>() {
            @Override
            protected boolean removeEldestEntry(final Map.Entry eldest) {
                return size() > capacity;
            }
        });
        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    }

    /**
     * add value to the data structure. complexity is o(1)
     * @param key
     * @param value
     * @param timeToLive
     */
    public void put(String key, Object value, int timeToLive) {
        map.put(key,value);
        if (timeToLive != 0) {
            this.scheduledExecutorService.schedule(() -> remove(key), timeToLive, TimeUnit.MILLISECONDS);
        }
    }

    /**
     * remove value from the data structure. complexity is o(1)
     * @param key
     */
    public void remove(String key) {
        map.remove(key);
    }

    /**
     * get value from the data structure. complexity is o(1)
     * @param key
     * @return
     */
    public Object get(String key) {
        return map.get(key);
    }

    /**
     * get number of keys in the data structure. complexity is o(1)
     * @return number of keys in the data structure
     */
    public int size() {
        return map.size();
    }
}

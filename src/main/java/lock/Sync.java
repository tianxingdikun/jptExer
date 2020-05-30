package lock;

import java.util.HashMap;
import java.util.Map;

public class Sync {

    private static Map<String,Object> map = new HashMap();

    public Object get(Object key) {
        synchronized(map) {
            if(map.get(key) == null) {
                // set some values
            }
            return map.get(key);
        }
    }

    public Object getOptimistic(Object key) {
        Object val = map.get(key);
        if(val == null) {
            // 当map取值为null时再加锁判断
            synchronized(map) {
                if(val == null) {
                    // set some value to map...
                }
            }
        }
        return map.get(key);
    }

}

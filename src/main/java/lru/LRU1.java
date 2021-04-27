package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author summer
 * @see <a href="https://blog.csdn.net/elricboa/article/details/78847305">LRU1</a><br/>
 * @since 2021/4/12 19:42
 */
public class LRU1<K,V> {
    private static final  float loadFactory = 0.75f;
    private LinkedHashMap<K,V> map;
    private int cacheSize;

    public LRU1(int cacheSize){
        this.cacheSize=cacheSize;
        int capacity=(int)Math.ceil(cacheSize/loadFactory)+1;
        map=new LinkedHashMap<>(capacity,loadFactory,true){
            private static final long serialVersionUID=1;

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest){
                return size()> LRU1.this.cacheSize;
            }
        };
    }

    public synchronized V get(K key){
        return map.get(key);
    }

    public synchronized void put(K key,V value){
        map.put(key,value);
    }

    public synchronized int usedSize(){
        return map.size();
    }

    private void print(){
        for (Map.Entry<K,V> entry:map.entrySet()) {
            System.out.println(entry.getValue()+"----");
        }
        System.out.println();
    }
}

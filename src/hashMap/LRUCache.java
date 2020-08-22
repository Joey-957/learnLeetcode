package src.hashMap;

import javafx.scene.layout.Priority;
import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用LinkedHashMap 实现 一个LRU 缓存
 *
 * 设定最大缓存空间 MAX_ENTRIES 为 3；
 * 使用 LinkedHashMap 的构造函数将 accessOrder 设置为 true，开启 LRU 顺序；
 * 覆盖 removeEldestEntry() 方法实现，在节点多于 MAX_ENTRIES 就会将最近最久未使用的数据移除。
 *
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private static final int MAX_SIZE = 3;

    public   boolean removeEldestEntry(Map.Entry eldest){
        return size() > MAX_SIZE;

    }
    // 构造函数
    private LRUCache(){
        super(MAX_SIZE,0.75f,true);
    }
    public static void main(String[] args) {
        Test<Integer,String> cache = new Test<Integer,String>();
        cache.put(1,"a");
        cache.put(2,"b");
        cache.put(3, "c");
        cache.get(1);
        cache.put(4, "d");
        System.out.println(cache.keySet());

    }



}
class Test<K,V> extends LinkedHashMap<K,V>{
    private static  final int maxSize = 3;
    public boolean removeEldestEntry(Map.Entry entry){
        return size() > maxSize;
    }
    Test(){
        super(maxSize,0.75f,true);
    }


}

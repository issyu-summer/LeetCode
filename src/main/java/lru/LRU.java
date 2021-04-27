package lru;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author summer
 * @see <a href="https://blog.csdn.net/elricboa/article/details/78847305">LRU1</a><br/>
 * @since 2021/4/12 19:42
 */
public class LRU<K,V> implements Iterable<K>{

    private class Node{
        Node pre;
        Node next;
        K k;
        V v;

        public Node(K k,V v){
            this.k=k;
            this.v=v;
        }
    }
    private Node head;
    private Node tail;
    private HashMap<K,Node> map;
    private int maxSize;

    /**
     * 构造函数
     */
    public LRU(int maxSize){
        this.maxSize=maxSize;
        this.map=new HashMap<K,Node>(maxSize*4/3);
        head=new Node(null,null);
        tail=new Node(null,null);
        head.next=tail;
        tail.pre=head;
    }

    /**
     * get
     */
    public V get(K key){
        //如果没有,返回null
        if(!map.containsKey(key)){
            return null;
        }
        //有则取出
        Node node=map.get(key);
        //解链并放到头部
        unlink(node);
        appendHead(node);
        return node.v;
    }


    /**
     * put
     */
    public void put(K key,V value){
        //如果有,则先,解链
        if(map.containsKey(key)){
            Node node=map.get(key);
            unlink(node);
        }
        //更新值
        Node node=new Node(key,value);
        map.put(key,node);
        //相当于使用过了,放入头
        appendHead(node);
        //使用LRU淘汰
        if(map.size()>maxSize){
            Node toRemove = removeTail();
            map.remove(toRemove.k);
        }
    }

    /**
     * removeTail
     */
    private Node removeTail() {
        //需要移除的是尾部前一个的
        Node node=tail.pre;
        //将尾节点和倒数第二个节点建立联系
        Node pre=node.pre;
        tail.pre=pre;
        pre.next=tail;
        //不再被任何节点引用
        node.pre=null;
        node.next=null;
        return node;
    }

    /**
     * appendHead
     */
    private void appendHead(Node node) {
        Node next=head.next;
        node.next=next;
        next.pre=node;
        node.pre=head;
        head.next=node;
    }

    /**
     * unlink
     */
    private void unlink(Node node) {
        Node pre=node.pre;
        Node next=node.next;

        pre.next=next;
        next.pre=pre;
        //不再被任何节点引用
        node.pre=null;
        node.next=null;
    }

    /**
     * 实现迭代器
     */
    @NotNull
    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {

            private Node cur = head.next;

            @Override
            public boolean hasNext() {
                return cur != tail;
            }

            @Override
            public K next() {
                Node node = cur;
                cur = cur.next;
                return node.k;
            }
        };
    }
}

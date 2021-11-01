import java.util.*;

class LRUcache {

    class Node {
        Node prev;
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;

    public LRUcache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key){
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveNodeToHead(node);
        return node.value;
    }

    private void moveNodeToHead(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = head;
        head.prev = node;
        head = node;
    }

    public void put(int key, int val){
        Node node;
        if (!map.containsKey(key)){
            if (map.size() == capacity) {
                tail.prev.next = null;
                tail = tail.prev;
            }
            node = new Node(val);
            map.put(key, node);
        } else {
            node = map.get(key);
            node.value = val;
        }
        moveNodeToHead(node);
        Queue q = new LinkedList();
    }
}

package LinkedList;

import java.util.*;

/**
 * @LeetCodeId 146
 * @LeetCodeLink <a href="https://leetcode.cn/problems/lru-cache">LRU 缓存</a>
 * @Frequency 🔥🔥🔥
 * @Date 2025-05-14
 */
public class LRUCache {
    static class Solution {
        // 双向链表用于 O(1) 插入或更新节点
        static class DLinkedNode {
            int key, value;
            DLinkedNode prev, next;

            public DLinkedNode() {
            }

            public DLinkedNode(int _key, int _value) {
                key = _key;
                value = _value;
            }
        }

        // 头尾虚拟节点
        private final DLinkedNode head, tail;

        // 哈希表用于 O(1) 查询缓存节点
        private final Map<Integer, DLinkedNode> cache = new HashMap<>();
        private int size; // 当前元素数量
        private final int capacity; // 最大容量

        public Solution(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 缓存命中，移至链表头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                // 新建节点
                DLinkedNode newNode = new DLinkedNode(key, value);
                // 加入哈希表
                cache.put(key, newNode);
                // 添加到链表头部
                addToHead(newNode);
                size++;
                // 超出容量，移除尾部节点
                if (size > capacity) {
                    DLinkedNode tail = removeTail();
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                // 更新值并移动到头部
                node.value = value;
                moveToHead(node);
            }
        }

        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }
    }

    public static void main(String[] args) {
        // 创建容量为 2 的 LRU 缓存
        Solution lruCache = new Solution(2);

        // 测试用例 1
        lruCache.put(1, 1); // 缓存是 {1=1}
        lruCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lruCache.get(1)); // 返回 1

        // 测试用例 2
        lruCache.put(3, 3); // 使 key 2 失效，缓存是 {1=1, 3=3}
        System.out.println(lruCache.get(2)); // 返回 -1

        // 测试用例 3
        lruCache.put(4, 4); // 使 key 1 失效，缓存是 {4=4, 3=3}
        System.out.println(lruCache.get(1)); // 返回 -1
        System.out.println(lruCache.get(3)); // 返回 3
        System.out.println(lruCache.get(4)); // 返回 4
    }
}


package Lesson18;

import java.util.HashMap;

public class TopKRecordRealTime {

    public static class Node {
        public String str;
        public int times;

        public Node(String s, int t) {
            str = s;
            times = t;
        }
    }

    public static class TopKRecord {
        private HashMap<String, Node> strNodeMap;
        private Node[] heap;
        private int heapSize;

        private HashMap<Node, Integer> nodeIndexMap;

        public TopKRecord(int size) {
            heap = new Node[size];
            heapSize = 0;
            strNodeMap = new HashMap<>();
            nodeIndexMap = new HashMap<>();
        }

        public void add(String str) {
            // 当前str对应的节点对象
            Node curNode = null;
            // 当前str对应的节点是否在堆中
            int preIndex = -1;
            if (!strNodeMap.containsKey(str)) { // str第一次出现
                curNode = new Node(str, 1);
                strNodeMap.put(str, curNode);
                nodeIndexMap.put(curNode, preIndex);
            } else { // 并非第一次出现
                curNode = strNodeMap.get(str);
                curNode.times++;
                preIndex = nodeIndexMap.get(curNode);
            }
            if (preIndex == -1) { // 当前str对应的节点对象，词频增加之后不在堆上
                if (heapSize == heap.length) { // 堆已经满了
                    if (heap[0].times < curNode.times) {
                        nodeIndexMap.put(heap[0], preIndex);
                        nodeIndexMap.put(curNode, 0);
                        heap[0] = curNode;
                        heapify(0, heapSize);
                    }
                } else {
                    nodeIndexMap.put(curNode, heapSize);
                    heap[heapSize] = curNode;
                    heapInsert(heapSize++);
                }
            } else {
                heapify(preIndex, heapSize);
            }
        }

        public void heapify(int index, int heapSize) {
            int l = index * 2 + 1;
            int r = index * 2 + 2;
            int smallest = index;
            while (l < heapSize) {
                if (heap[l].times < heap[index].times) {
                    smallest = l;
                }
                if (r < heapSize && heap[r].times < heap[smallest].times) {
                    smallest = r;
                }
                if (smallest != index) {
                    swap(smallest, index);
                } else {
                    break;
                }
                index = smallest;
                l = index * 2 + 1;
                r = index * 2 + 2;
            }
        }

        public void heapInsert(int i) {
            while (i != 0) {
                int parent = (i - 1) / 2;
                if (heap[i].times < heap[parent].times) {
                    swap(parent, i);
                    i = parent;
                } else {
                    break;
                }
            }
        }

        public void swap(int i, int j) {
            //swap the nodes in the heap
            //and swap the nodes in the maps
        }
    }
}

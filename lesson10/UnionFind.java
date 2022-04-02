package lesson10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class UnionFind {

    public static class Element<V> {
        public V value;

        public Element(V value) {
            this.value = value;
        }
    }

    public static class UnionFindSet<V> {
        // The set of elements
        public Map<V, Element<V>> elementMap;
        // Key: an element; Value: its head element
        public Map<Element<V>, Element<V>> fatherMap;
        // Key: a set's head element; Value: the set's size
        public Map<Element<V>, Integer> sizeMap;

        public UnionFindSet(List<V> list) {
            elementMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<V>(value);
                elementMap.put(value, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        private Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>();
            while (element != fatherMap.get(element)) {
                path.push(element);
                element = fatherMap.get(element);
            }
            // flattern the chains
            while (!path.isEmpty()) {
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

        public boolean isSameSet(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
            }
            return false;
        }

        public void union(V a, V b) {
            if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
                Element<V> headOfA = findHead(elementMap.get(a));
                Element<V> headOfB = findHead(elementMap.get(b));
                if (headOfA != headOfB) {
                    Element<V> big = sizeMap.get(headOfA) >= sizeMap.get(headOfB) ? headOfA : headOfB;
                    Element<V> small = big == headOfA ? headOfB : headOfA;
                    fatherMap.put(small, big);
                    sizeMap.put(big, sizeMap.get(headOfA) + sizeMap.get(headOfB));
                    sizeMap.remove(small);
                }
            }
        }
    }
}

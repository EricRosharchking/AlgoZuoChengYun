package lesson7;

public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String str) {
        if (str == null) {
            return;
        }
        char[] ch = str.toCharArray();
        TrieNode node = root;
        node.pass++;
        int index = 0;
        for (int i = 0; i < ch.length; i++) {
            index = ch[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }

    public int search(String str) {
        if (str == null) {
            return 0;
        }
        TrieNode node = root;
        char[] ch = str.toCharArray();
        int index = 0;
        for (int i = 0; i < ch.length; i++) {
            index = ch[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.end;
    }

    public int searchPrefix(String str) {
        if (str == null) {
            return 0;
        }
        TrieNode node = root;
        char[] ch = str.toCharArray();
        int index = 0;
        for (int i = 0; i < ch.length; i++) {
            index = ch[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.pass;
    }

    public void delete(String str) {
        if (search(str) != 0) {
            return;
        }
        TrieNode node = root;
        char[] ch = str.toCharArray();
        int index = 0;
        node.pass--;
        for (int i = 0; i < ch.length; i++) {
            index = ch[i] - 'a';
            if (--node.nexts[index].pass == 0) {
                node.nexts[index] = null; // 以后的所有节点都被释放了
                return;
            }
            node = node.nexts[index];
        }
        node.end--;
    }
}

public class Trie {
    private static final Integer R = 256;
    private Node root;

    private static class Node {
        private boolean Is_Terminal;
        private final Node[] next = new Node[R];
    }

    public Trie() {

    }

    public void insert(String word) {
        root = insert(root, word, 0);
    }

    private Node insert(Node x, String word, int d) {
        if (x == null) x = new Node();
        if (d == word.length()) {
            x.Is_Terminal = true;
            return x;
        }
        char c = word.charAt(d);
        x.next[c] = insert(x.next[c], word, d + 1);
        return x;
    }

    public boolean search(String word) {
        Node x = search(root, word, 0);
        return x != null;
    }

    private Node search(Node x, String word, Integer d) {
        if (x == null) return null;
        if (d == word.length()) {
            if (!x.Is_Terminal) return null;
            return x;
        }
        char c = word.charAt(d);
        return search(x.next[c], word, d + 1);
    }

    public boolean startsWith(String prefix) {
        Node x = startsWith(root, prefix, 0);
        return x != null;
    }

    private Node startsWith(Node x, String prefix, Integer d) {
        if (x == null) return null;
        if (d == prefix.length()) return x;
        char c = prefix.charAt(d);
        return startsWith(x.next[c], prefix, d + 1);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        // trie.insert("apple");
        trie.insert("apple");
        System.out.printf("Test 1 - Trie search() Expecting \"True\", Getting: %b\n", trie.search("apple"));
        System.out.printf("Test 2 - Trie search() Expecting \"False\", Getting: %b\n", trie.search("app"));
        System.out.printf("Test 3 - Trie startsWith() Expecting \"True\", Getting: %b\n", trie.startsWith("app"));
        trie.insert("app");
        System.out.printf("Test 4 - Trie search() Expecting \"True\", Getting: %b\n", trie.search("app"));
    }
}

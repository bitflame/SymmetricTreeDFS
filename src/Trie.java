public class Trie {
    public void insert(String word) {

    }

    public boolean search(String word) {
        return false;
    }

    public boolean startsWith(String prefix) {
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.printf("Expecting \"True\", Getting: %b\n", trie.search("apple"));
        System.out.printf("Expecting \"True\", Getting: %b\n", trie.search("app"));
        System.out.printf("Expecting \"True\", Getting: %b\n", trie.startsWith("app"));
        trie.insert("app");
        System.out.printf("Expecting \"True\", Getting: %b\n", trie.search("app"));
    }
}

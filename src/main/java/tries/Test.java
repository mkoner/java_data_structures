package tries;

public class Test {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Hello");
        trie.insert("Can");
        trie.insert("Cancel");
        trie.insert("Candy");
        trie.printAllWords();
        System.out.println("Search Hello: "+ trie.search("Hello"));
        System.out.println("Words staring with Can: " + trie.getWordsWithPrefix("Can"));
        System.out.println("Delete Can");
        trie.delete("Can");
        trie.printAllWords();
        System.out.println("Words staring with Can: " + trie.getWordsWithPrefix("Can"));
        System.out.println("Delete Hello");
        trie.delete("Hello");
        System.out.println("Search Hello: "+ trie.search("Hello"));
        trie.printAllWords();
    }
}

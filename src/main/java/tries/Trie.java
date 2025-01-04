package tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    Node root;
    public Trie(){
        root = new Node();
    }
    public void insert(String word){
        Node current = root;
        for(char c: word.toCharArray()){
            if(current.children.containsKey(c)){
                current = current.children.get(c);
            }
            else{
                Node newNode = new Node(c);
                current.children.put(c, newNode);
                current = newNode;
            }
        }
        current.wordEnd = true;
    }
    public boolean search(String word){
        Node node = searchNode(word);
        if(node == null){
            return false;
        }
        return node.wordEnd;
    }
    public List<String> getWordsWithPrefix(String prefix){
        List<String> words = new ArrayList<>();
        Node node = searchNode(prefix);
        if(node==null){
            return words;
        }
        addWords(node, words, prefix);
        return words;
    }
    public void delete(String word){
        Node current = root;
        List<Node> nodes = new ArrayList<>();
        for(char c: word.toCharArray()){
            if(!current.children.containsKey(c)){
                return;
            }
            current = current.children.get(c);
            nodes.add(current);
        }
        current.wordEnd = false;
        for(int i=nodes.size()-1; i>0; i--){
            Node node = nodes.get(i);
            if(node.wordEnd){
                break;
            }
            else if(node.children.isEmpty()){
                nodes.get(i-1).children.remove(node.character);
            }
        }
        if(!nodes.get(0).wordEnd && nodes.get(0).children.isEmpty()){
            root.children.remove(nodes.get(0).character);
        }
    }
    public void printAllWords(){
        List<String> words = new ArrayList<>();
        addWords(root, words, "");
        System.out.println("Words in trie: " + words);
    }

    private void addWords(Node node, List<String> words, String currentWord) {
        if(node.wordEnd){
            words.add(currentWord);
        }
        for(Node child: node.children.values()){
            addWords(child, words, currentWord+child.character);
        }
    }
    private Node searchNode(String word){
        Node current = root;
        for(char c: word.toCharArray()){
            if(!current.children.containsKey(c)){
                return null;
            }
            current = current.children.get(c);
        }
        return current;
    }
}
class Node{
    Character character;
    Map<Character, Node> children;
    boolean wordEnd;
    public Node(){
        character = null;
        children = new HashMap<>();
    }
    public Node(Character c){
        character = c;
        children = new HashMap<>();
    }
}

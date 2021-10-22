package LeetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Trie {

    Node root;

    public Trie() {
        root = new Node(' ');
    }

    public void insert(String word) {
        Node currentNode = root;
        List<Character> chars = word.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
        for (Character c : chars){
            if (!currentNode.sons.containsKey(c)) {
                Node newSon = new Node(c);
                currentNode.sons.put(c, newSon);
            }
            currentNode = currentNode.sons.get(c);
        }
        currentNode.markAsWord();
    }

    public boolean search(String word) {
        Node currentNode = root;
        List<Character> chars = word.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
        for (Character c : chars){
            if (!currentNode.sons.containsKey(c)) {
                return false;
            }
            currentNode = currentNode.sons.get(c);
        }
        return currentNode.isWord;
    }

    public boolean startsWith(String prefix) {
        Node currentNode = root;
        List<Character> chars = prefix.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
        for (Character c : chars){
            if (!currentNode.sons.containsKey(c)) {
                return false;
            }
            currentNode = currentNode.sons.get(c);
        }
        return true;
    }

    private class Node {

        Character c;

        Map<Character, Node> sons;

        boolean isWord = false;

        public Node(Character c) {
            this.c = c;
            sons = new HashMap<>();
        }

        public void markAsWord(){
            isWord = true;
        }
    }

    public static void main(String[] args){
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
}

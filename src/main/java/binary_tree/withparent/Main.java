package binary_tree.withparent;

public class Main {
    public static void main(String[] args) {
        Node<Character> root = new Node<>('A');
        BinaryTree<Character> tree = new BinaryTree<>(root);
        Node<Character>  M2 = new Node<>('M');
        Node<Character>  M1 = new Node<>('M');
        Node<Character>  A1 = new Node<>('A');
        Node<Character>  D = new Node<>('D');
        Node<Character>  O = new Node<>('O');
        Node<Character>  U = new Node<>('U');
        tree.addBefore(root, A1);
        tree.addAfter(root, O);
        tree.addBefore(A1, M1);
        tree.addAfter(A1, M2);
        tree.addBefore(O, D);
        tree.addAfter(O, U);
        tree.print();
        tree.delete(root);
        tree.print();
        tree.delete(root);
        tree.print();

    }
}

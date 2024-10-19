package binary_tree.withparent;

public class BinaryTree<T> {
    private Node<T> root;
    public BinaryTree() {
        root = null;
    }
    public BinaryTree(Node<T> root) {
        this.root = root;
    }
    public Node<T> getRoot() {
        return root;
    }
    public void addAfter(Node<T> node, Node<T> newNode) {
        if(node.getRight() == null) {
            node.setRight(newNode);
            newNode.setParent(node);
        }
        else {
            Node<T> successor = getSuccessor(node);
            successor.setLeft(newNode);
            newNode.setParent(successor);
        }
    }
    public void addBefore(Node<T> node, Node<T> newNode) {
        if(node.getLeft() == null) {
            node.setLeft(newNode);
            newNode.setParent(node);
        }
        else {
            Node<T> predecessor = getPredecessor(node);
            predecessor.setRight(newNode);
            newNode.setParent(predecessor);
        }
    }
    public void delete(Node<T> node) {
        if(isLeaf(node)){
            detachNode(node);
        }
        if(node.getLeft() != null) {
            Node<T> predecessor = getPredecessor(node);
            swapData(node, predecessor);
            delete(predecessor);
        }
        else if(node.getRight() != null) {
            Node<T> successor = getSuccessor(node);
            swapData(node, successor);
            delete(successor);
        }

    }

    private void swapData(Node<T> node1, Node<T> node2) {
        T temp = node1.getData();
        node1.setData(node2.getData());
        node2.setData(temp);
    }

    private void detachNode(Node<T> node) {
        System.out.println("detach " + node.getData());
        if (node == null || node.getParent() == null) {
            return; // If node is null or if it's the root node, do nothing
        }
        if(node == node.getParent().getLeft()) {
//            System.out.println("leaf is left o parent");
            node.getParent().setLeft(null);
        }
        else if(node == node.getParent().getRight()) {
//            System.out.println("leaf is right o parent");
            node.getParent().setRight(null);
        }
        node.setParent(null);
    }

    private boolean isLeaf(Node<T> node) {
//        System.out.println(node.getData() + " is leaf");
        return node.getLeft() == null && node.getRight() == null;
    }

    public Node<T> getSuccessor(Node<T> node) {
        if(node == subTreeLast(root))
            return null;
        if(node.getRight() != null)
            return subTreeFirst(node.getRight());
        while (node.getParent().getLeft() != node)
            node = node.getParent();
        return node.getParent();
    }
    public Node<T> getPredecessor(Node<T> node) {
        if(node == subTreeFirst(root))
            return null;
        if(node.getLeft() != null)
            return subTreeLast(node.getLeft());
        while (node.getParent().getRight() != node){
            node = node.getParent();
        }
        return node.getParent();
    }
    public Node<T> subTreeFirst(Node<T> node) {
        while (node.getLeft() != null)
            node = node.getLeft();
        return node;
    }
    public Node<T> subTreeLast(Node<T> node) {
        while (node.getRight() != null)
            node = node.getRight();
        return node;
    }
    public void print() {
        inorder(root);
        System.out.println();
    }
    private void inorder(Node<T> node) {
        if(node == null)
            return;
        inorder(node.getLeft());
        System.out.print(node.getData() + " ");
        inorder(node.getRight());
    }
}

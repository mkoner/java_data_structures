package binary_tree.noparent;

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

    public void setRoot(Node<T> root) {
        this.root = root;
    }
    Node<T> subTreeMin(Node<T> node) {
        while (node.getLeft() != null)
            node = node.getLeft();
        return node;
    }
    Node<T> subTreeMax(Node<T> node) {
        while (node.getRight() != null)
            node = node.getRight();
        return node;
    }
    Node<T> getSuccessor(Node<T> node) {
        // To implement
        if(node.getRight() == null)
            return subTreeMin(node.getRight());
        return null;
    }
    Node<T> getPredecessor(Node<T> node) {
        // To implement
        if(node.getLeft() != null)
            return subTreeMax(node.getLeft());
        return null;
    }
    public void addBefore(Node<T> node, Node<T> newNode) {
        if(node.getLeft() == null)
            node.setLeft(newNode);
        else
            addAfter(getPredecessor(node), newNode);
    }

    public void addAfter(Node<T> node, Node<T> newNode) {
        if(node.getRight() == null)
            node.setRight(newNode);
        else
            addBefore(getSuccessor(node), newNode);
    }
    public void delete(Node<T> node) {
        if(isLeaf(node)){
            detach(node);
            return;
        }
        if(node.getLeft() != null){
            Node<T> predecessor = getPredecessor(node);
            swapData(node, predecessor);
            delete(predecessor);
        }
        else if(node.getRight() != null){
            Node<T> successor = getSuccessor(node);
            swapData(node, successor);
            delete(successor);
        }
    }

    private void swapData(Node<T> node, Node<T> predecessor) {
        T temp = predecessor.getData();
        predecessor.setData(node.getData());
        node.setData(temp);
    }

    private void detach(Node<T> node) {
        Node<T> parent = findParent(root,node);
        if(parent == null) return;
        if(parent.getLeft() == node)
            parent.setLeft(null);
        if(parent.getRight() == node)
            parent.setRight(null);
    }

    private Node<T> findParent(Node<T> root, Node<T> node) {
        if(root == null)
            return null;
        if(root.getLeft() == node || root.getRight() == node)
            return root;
        Node<T> resultLeft = findParent(root.getLeft(), node);
        if(resultLeft != null)
            return resultLeft;
        return findParent(root.getRight(), node);
    }

    private boolean isLeaf(Node<T> node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    private Node<T> inOrderSuccessor(Node<T> root, Node<T> node) {
        if(root != null){
            inOrderSuccessor(root.getLeft(), node);
            if(root == node){

            }
            inOrderSuccessor(root.getRight(), node);
        }
        return null;
    }
}

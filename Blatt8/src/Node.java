/**
 * Implements a Node of a Tree.
 * 
 * @author Michael Mardaus
 * @author Julian Rost
 * @since 11.06.2013
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    /**
     * pointer to the left child.
     */
    private Node<T> leftChild;
    /**
     * pointer to the right child.
     */
    private Node<T> rightChild;
    /**
     * pointer to the parent.
     */
    private Node<T> father;
    /**
     * the node's value
     */
    private T value;

    /**
     * constructor for an empty node.
     */
    public Node() {
        this.value = null;
        this.leftChild = null;
        this.rightChild = null;
        this.father = null;
    }

    /**
     * constructor for a unlinked node.
     * @param value the node value
     */
    public Node(T value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
        this.father = null;
    }

    /**
     * constructor for a fully linked node
     * @param value the value
     * @param left the leftchild pointer
     * @param right the rightchild pointer
     * @param father the parent pointer
     */
    public Node(T value, Node<T> left, Node<T> right, Node<T> father) {
        this.value = value;
        this.leftChild = left;
        this.rightChild = right;
        this.father = father;
    }

    /**
     * getLeft.
     * 
     * @return left node
     */
    public Node<T> getLeftChild() {
        return this.leftChild;
    }

    /**
     * setLeft.
     * 
     * @param leftChild
     *            the left one
     */
    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * getRight.
     * 
     * @return right node
     */
    public Node<T> getRightChild() {
        return this.rightChild;
    }

    /**
     * setRight.
     * 
     * @param rightChild
     *            the right one
     */
    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    /**
     * getFather.
     * 
     * @return father node
     */
    public Node<T> getFather() {
        return this.father;
    }

    /**
     * setFather.
     * 
     * @param father
     *            the father.
     */
    public void setFather(Node<T> father) {
        this.father = father;
    }

    /**
     * getValue.
     * 
     * @return value of node
     */
    public T getValue() {
        return this.value;
    }

    /**
     * setValue.
     * 
     * @param value
     *            the value
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * compares the nodes by its value.
     * 
     * @param other
     *            the other node
     * @return compareTo result of type T
     */
    public int compareTo(Node<T> other) {
        return this.getValue().compareTo(other.getValue());
    }

    /**
     * finds next bigger value from current node.
     * @return next node
     */
    public Node<T> getNext() {
        if (this.getRightChild() != null) {
            return this.getRightChild().getMinimum();
        } else if (this.getFather() != null)
            return this.getRightParent();
        else
            return null;
    }

    /**
     * helper function to get down to the smallest child
     * in a right subtree.
     * @return minimum of right subtree
     */
    public Node<T> getMinimum() {
        if (this.getLeftChild() != null) {
            return getLeftChild().getMinimum();
        } else {
            return this;
        }
    }

    /**
     * helper function to get the correct parent.
     * when we don't find a rightchild we have to go up.
     * if the current node is a leftchild we just take the parent.
     * if the current node is a rightchild we call that function again
     * for our parent.
     * @return the next bigger parent
     */
    public Node<T> getRightParent() {
        if (this.getFather() == null) return null;
        if (this.getFather().getLeftChild() == this)
            return this.getFather();
        else
            return this.getFather().getRightParent();
    }
}

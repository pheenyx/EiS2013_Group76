/**
 * Implements a Tree.
 * 
 * @author Michael Mardaus
 * @author Julian Rost
 * @since 11.06.2013
 */
public class Tree<T extends Comparable<T>> {

    private Node<T> root;
    
    /**
     * constructor for an empty tree.
     */
    public Tree(){
        this.root = null;
    }
    /**
     * constructor for a tree with value.
     * @param value new value.
     */
    public Tree(T value){
        this.root = new Node<T>(value);
    }
    
    
    /**
     * gets the root of the tree.
     * @return the root node
     */
    public Node<T> getRoot(){
        return this.root;
    }
    /**
     * sets the root node ot the tree.
     * @param root new root node
     */
    public void setRoot(Node<T> root){
        this.root = root;
    }
     
    /**
     * adds an element to the tree.
     * @param element the element to add
     * @return successvalue
     */
    public boolean add(T element){
        Node<T> currentNode = this.getRoot();
        // if the root is still null, we have to set it first
        if (currentNode == null) {   
            this.root = new Node<T>(element);            
            return true;
        } else {
            while (true) {
                //is the new element smaller then current, go left
                if (currentNode.getValue().compareTo(element) > 0){
                    // if there is no leftchild set element here
                    if (currentNode.getLeftChild() == null) {   
                        Node<T> l = new Node<T>(element);
                        l.setFather(currentNode);
                        currentNode.setLeftChild(l);             
                        return true;
                    // otherwise go deeper left
                    } else {
                        currentNode = currentNode.getLeftChild();
                    }
                // greater or equal then current, go right
                } else {
                    // if there is no rightchild, set element here
                    if (currentNode.getRightChild() == null) {   
                        Node<T> r = new Node<T>(element);
                        r.setFather(currentNode);
                        currentNode.setRightChild(r);             
                        return true;
                    // otherwise go deeper right
                    } else {
                        currentNode = currentNode.getRightChild();
                    }
                }
            }
        }
    }
    
    /**
     * returns the lowerleftmost node of the tree.
     * @return minimum of the tree
     */
    public Node<T> getFirst(){
        Node<T> currentNode = this.getRoot();
        while (currentNode.getLeftChild() != null) {
            currentNode = currentNode.getLeftChild();
        }
        return currentNode;
    }
    
    public static void main(final String[] args) {
        Tree<Integer> tree = new Tree<Integer>();
        tree.add(25);
        tree.add(5);
        tree.add(31);
        tree.add(9);
        tree.add(44);
        tree.add(32);
        tree.add(1);
        tree.add(12);
        tree.add(30);
        Node<Integer> currentNode = tree.getFirst();
        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        
        System.out.println("Baum2:");
        Tree<Integer> tree1 = new Tree<Integer>();
        tree1.add(1);
        tree1.add(5);
        tree1.add(9);
        tree1.add(12);
        tree1.add(25);
        tree1.add(30);
        tree1.add(31);
        tree1.add(32);
        tree1.add(44);
        currentNode = tree.getFirst();
        while (currentNode != null) {
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
    }

}

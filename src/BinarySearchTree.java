public class BinarySearchTree<T extends Comparable<T>> {
    private NodeType<T> head;
    private boolean printDuplicates;

    public BinarySearchTree() {
        head = null;
        printDuplicates = false;
    } //constructor

    public void setPrintDuplicates(boolean setting) {
        this.printDuplicates = setting;
    } //setPrintDuplicates

    public void insert(T key) {
        NodeType<T> newNode = new NodeType<>();
        newNode.info = key;
        //Inserts an item into the tree

        //Base Case: If the tree is NULL, allocate a new node
        if (head == null) {
            head = newNode;
            return;
        } else {
            //General Case: Insert into the left or right subtree as appropriate (recursively)
            NodeType<T> current = head;
            insertHelper(current, newNode);
        }
    } //insert

    private void insertHelper(NodeType<T> current, NodeType<T> newNode) {
        if (newNode.info.compareTo(current.info) < 0) {
            //Take left path
            if (current.left == null) {
                //newNode becomes the new left child of current
                current.left = newNode;
            } else {
                //Continue down the left path
                insertHelper(current.left, newNode);
            }
        } else if (newNode.info.compareTo(current.info) > 0) {
            //Take right path
            if (current.right == null) {
                //newNode becomes the new right child of current
                current.right = newNode;
            } else {
                //Continue down the right path
                insertHelper(current.right, newNode);
            }
        } else {
            //Duplicate found
            System.out.println("The item already exists in the tree.");
        }
    } //insertHelper

    public void delete(T key) {
        
    } //delete

    public boolean retrieve(T item) {
        return false;
    } //retrieve

    //Prints the tree in order (left, root, right)
    public void inOrder() {
        System.out.print("In-order: ");
        //Go to the leftmost node, then print, then go to the right
        NodeType<T> current = head;
        if (current != null) {
            if (current.left != null) {
                inOrderHelper(current.left);
            }
            System.out.print(current.info + " ");
            if(current.right != null) {
                inOrderHelper(current.right);
            }
        }
        System.out.println("");
    } //inOrder

    private void inOrderHelper(NodeType<T> current) {
        if (current.left != null) {
            inOrderHelper(current.left);
        }
        System.out.print(current.info + " ");
        if (current.right != null) {
            inOrderHelper(current.right);
        }
    } //inOrderHelper

    public void getSingleParent() {

    }

    public void getNumLeafNodes() {

    } //getNumLeafNodes

    public void getCousins() {

    } //getCousins
} //BinarySearchTree

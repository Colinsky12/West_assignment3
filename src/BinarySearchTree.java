import org.w3c.dom.Node;

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
        NodeType<T> current = head;
        head = deleteHelper(current, key);
    } //delete

    private NodeType<T> deleteHelper(NodeType<T> current, T key) {
            if (current == null) {
                System.out.println("The item is not present in the tree.");
                return null;
            } else if (key.compareTo(current.info) < 0) {
                //Take left path
                current.left = deleteHelper(current.left, key);
                return current;
            } else if (key.compareTo(current.info) > 0) {
                //Take right path
                current.right = deleteHelper(current.right, key);
                return current;
            } else {
                //Item found, delete it
                if (current.left == null && current.right == null) {
                    //Case 1: No children
                    return null;
                } else if (current.left == null) {
                    //Case 2: One child (right)
                    return current.right;
                } else if (current.right == null) {
                    //Case 3: One child (left)
                    return current.left;
                } else {
                    //Case 4: Two children, find the in-order successor (smallest in the right subtree)
                    NodeType<T> successor = findMin(current.right);
                    current.info = successor.info; //Replace current's value with successor's value
                    current.right = deleteHelper(current.right, successor.info); //Delete the successor node
                    return current;
                }
            }
    } //deleteHelper

    private NodeType<T> findMin(NodeType<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    } //findMin

    public boolean retrieve(T item) {
        if (head == null) {
            System.out.println("The tree is empty.");
            return false;
        } else {
            boolean found = false;
            NodeType<T> current = head;
            while (current != null) {
                if (item.compareTo(current.info) < 0) {
                    //Take left path
                    current = current.left;
                } else if (item.compareTo(current.info) > 0) {
                    //Take right path
                    current = current.right;
                } else {
                    //Item found
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.println("Item is present in the tree.");
            } else {
                System.out.println("Item is not present in the tree.");
            }
            return found;
        }
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
        NodeType<T> current = head;
        System.out.print("Single Parents: ");
        getSingleParentHelper(current);
        System.out.println("");
    }

    private void getSingleParentHelper(NodeType<T> current) {
        if (current != null) {
            getSingleParentHelper(current.left);
            if (current.left != null && current.right == null) {
                System.out.print(current.info + " ");
            } else if (current.left == null && current.right != null) {
                System.out.print(current.info + " ");
            }
            getSingleParentHelper(current.right);
        }
    } //getSingleParentHelper

    public void getNumLeafNodes() {
        int numLeafNodes = getNumLeafNodesHelper(head);
        System.out.println("The number of leaf nodes are " + numLeafNodes);
    } //getNumLeafNodes

    private int getNumLeafNodesHelper(NodeType<T> current) {
        if (current == null) {
            return 0;
        }
        if (current.left == null && current.right == null) {
            return 1; //Current node is a leaf
        } else {
            return getNumLeafNodesHelper(current.left) + getNumLeafNodesHelper(current.right);
        }
        
    } //getNumLeafNodesHelper

    public void getCousins(T item) {
        NodeType<T> current = head;
        NodeType<T> parent = null;
        NodeType<T> grandparent = null;
        //1: find item in the tree
        if (head == null) {
            System.out.println("The tree is empty.");
        } else {
            while (current != null) {
                if (item.compareTo(current.info) < 0) {
                    //Take left path
                    grandparent = parent;
                    parent = current;
                    current = current.left;
                } else if (item.compareTo(current.info) > 0) {
                    //Take right path
                    grandparent = parent;
                    parent = current;
                    current = current.right;
                } else if (item.compareTo(current.info) == 0) {
                    //Item found
                    break;
                } //search for item in tree
                if (current == null) {
                    System.out.println("Item is not present in the tree.");
                    return;
                }
            } //while loop to find item in tree
            System.out.print(item + "cousins: "); 
            if (grandparent == null) {
                return;
            } else {
                if (grandparent.left != parent && grandparent.left != null) {
                    if (grandparent.left.left != null) {
                        System.out.print(grandparent.left.left.info + " ");
                    }
                    if (grandparent.left.right != null) {
                        System.out.print(grandparent.left.right.info + " ");
                    }
                }
                if (grandparent.right != parent && grandparent.right != null) {
                    if (grandparent.right.left != null) {
                        System.out.print(grandparent.right.left.info + " ");
                    }
                    if (grandparent.right.right != null) {
                        System.out.print(grandparent.right.right.info + " ");
                    }
                }
            }
        } //if/else
        System.out.println("");
    } //getCousins
} //BinarySearchTree

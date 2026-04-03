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

    } //insert

    public void delete(T key) {

    } //delete

    public boolean retrieve(T item) {
        return false;
    } //retrieve

    public void inOrder() {

    } //inOrder

    public void getSingleParent(T item) {

    }

    public void getNumLeafNodes() {

    } //getNumLeafNodes

    public void getCousins(T item) {

    } //getCousins
}

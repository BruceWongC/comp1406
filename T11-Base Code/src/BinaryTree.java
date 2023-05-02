import java.util.ArrayList;
import java.util.Objects;

public class BinaryTree {
    private String	   	data;
    private BinaryTree	leftChild;
    private BinaryTree	rightChild;

    // A constructor that makes a Sentinel node
    public BinaryTree() {
        data = null;
        leftChild = null;
        rightChild = null;
    }

    // This constructor now uses sentinels for terminators instead of null
    public BinaryTree(String d) {
        data = d;
        leftChild = new BinaryTree();
        rightChild = new BinaryTree();
    }

    // This constructor is unchanged
    public BinaryTree(String d, BinaryTree left, BinaryTree right) {
        data = d;
        leftChild = left;
        rightChild = right;
    }

    public boolean contains(String d){
        if (this.data == null){
            return false;
        }

        if(this.data.equals(d)){
            return true;
        }
        else {
            return this.leftChild.contains(d) || this.rightChild.contains(d);
        }
    }

    public boolean isTheSameAs(BinaryTree t) {
        if (this.data == null && t.data == null){// reaches ends of trees, completed search
            return true;
        }

        if (this.data != null && t.data != null){
            return this.leftChild.isTheSameAs(t.leftChild) && this.rightChild.isTheSameAs(t.rightChild) && this.data.equals(t.data);
        }
        else {
            return false;//if a leaf, but other isn't null. Not equal
        }
    }


    // Get methods
    public String getData() { return data; }
    public BinaryTree getLeftChild() { return leftChild; }
    public BinaryTree getRightChild() { return rightChild; }

    // Set methods
    public void setData(String d) { data = d; }
    public void setLeftChild(BinaryTree left) { leftChild = left; }
    public void setRightChild(BinaryTree right) { rightChild = right; }

    // Return a list of all data within the leaves of the tree
    public ArrayList<String> leafData()  {
        ArrayList<String>	result = new ArrayList<String>();

        if (data != null) {
            if ((leftChild.data == null) && (rightChild.data == null))
                result.add(data);
            result.addAll(leftChild.leafData());
            result.addAll(rightChild.leafData());
        }
        return result;
    }

    // Determines the height of the tree, which is the number of branches
    // in the path from the root to the deepest leaf.
    public int height()  {
        // Check if this is a sentinel node
        if (data == null)
            return 0;

        return 1 + Math.max(leftChild.height(),
                rightChild.height());
    }


}

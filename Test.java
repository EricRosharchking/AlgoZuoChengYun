import java.util.Arrays;

import lesson1.LocalMinimum;
import lesson2.SmallSum;
import lesson3.RadixSort;
import lesson5.BinaryTree;
import lesson5.IsTree;
import util.BinaryTreeNode;

public class Test {
    
    public static void main(String[] args) {
        // int[] arr = {6,5,4,2,3,1,8,10};
        // // System.out.println(arr);
        // // LocalMinimum.findLocalMinimum(arr);
        // // arr = new int[] {5,6,10};
        // // System.out.println(arr);
        // // LocalMinimum.findLocalMinimum(arr);

        // // arr = new int[] {6,5,1};
        // // System.out.println(arr);
        // // LocalMinimum.findLocalMinimum(arr);

        // arr = new int[] {16,32,42,26,50,100};
        // // System.out.println(SmallSum.calculate(arr));
        // RadixSort.radixSort(arr);
        // System.out.println(Arrays.toString(arr));

        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);
        BinaryTreeNode n2 = new BinaryTreeNode(2, n4, n5);
        BinaryTreeNode n3 = new BinaryTreeNode(3, n6, n7);
        BinaryTreeNode n1 = new BinaryTreeNode(1, n2, n3);

        n3.left = null;
        n7.right = n6;
        
        BinaryTreeNode n14 = new BinaryTreeNode(1);
        BinaryTreeNode n15 = new BinaryTreeNode(3);
        BinaryTreeNode n16 = new BinaryTreeNode(5);
        BinaryTreeNode n17 = new BinaryTreeNode(7);
        BinaryTreeNode n12 = new BinaryTreeNode(2, n14, n15);
        BinaryTreeNode n13 = new BinaryTreeNode(6, n16, n17);
        BinaryTreeNode n11 = new BinaryTreeNode(4, n12, n13);

        // n13.left = null;
        // BinaryTree.nonReccursivePreOrder(n1);
        // BinaryTree.nonReccursivePostOrder(n1);
        // BinaryTree.nonReccursiveInOrder(n1);
        // BinaryTree.bfs(n1);
        // System.out.println(BinaryTree.maxWidth(n4));
        // System.out.println(BinaryTree.maxWidthAdjusted(n1));
        // BinaryTree.nonReccursiveInOrder(n11);
        // System.out.println(IsTree.isBSTReccursive(n11).isBST);
        // System.out.println(IsTree.isBSTNonReccursive(n12));
        // System.out.println(IsTree.isBSTReccursive(n12).minVal + "," + IsTree.isBSTReccursive(n12).maxVal + "," + IsTree.isBSTReccursive(n12).isBST);
        // System.out.println(IsTree.isBSTReccursive(n14).isBST);
        System.out.println(IsTree.isCBTNonReccursive(n11));

    }

    public static int divide(int i, int j) {
        return i + ((i + j) >> 1); //bitwise operation is faster than divide
    }
}

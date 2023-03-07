
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;


public class SymmetricTree {
    TreeNode buildTree(int[] input) {
        if (input == null || input.length == 0) return null;
        return buildTree(input, 0);
    }

    TreeNode buildTree(int[] input, int index) {
        Queue<TreeNode> nodes = new Queue<>();
        TreeNode root = new TreeNode(input[index]);
        nodes.enqueue(root);
        while (!nodes.isEmpty()) {
            TreeNode parent = nodes.dequeue();
            parent.left = new TreeNode(input[++index]);
            if (index == input.length - 1) break;
            nodes.enqueue(parent.left);
            parent.right = new TreeNode(input[++index]);
            if (index == input.length - 1) break;
            nodes.enqueue(parent.right);
        }
        return root;
    }

    public void printInOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val);
            printInOrder(root.left);
            printInOrder(root.right);
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkChildren(root.left, root.right);
    }

    public boolean checkChildren(TreeNode lf, TreeNode rt) {
        if (lf == null) {
            if (rt == null) return true;
            else return false;
        } else if (rt == null) return false;
        else {
            if (lf.val != rt.val) return false;
            else return (checkChildren(lf.left, rt.right) && checkChildren(lf.right, rt.left));
        }
    }

    public boolean isSymStack(TreeNode treeNode) {
        Stack<Integer> stack = new Stack<>();
        return isSymStack(treeNode.left, treeNode.right, stack);
    }

    public boolean isSymStack(TreeNode lf, TreeNode rt, Stack<Integer> stack) {
        if (lf != null) {
            stack.push(lf.val);
            if (rt != null) {
                if (rt.val == stack.peek()) stack.pop();
                else {
                    stack.push(rt.val);
                }
                return (isSymStack(rt.left, lf.right, stack) && isSymStack(lf.left, rt.right, stack));
            }
        }
        if (rt != null) {
            stack.push(rt.val);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // [1,2,2,3,4,4,3]
        int[] input = {1, 2, 2, 3, 4, 4, 3};
        SymmetricTree symmetricTree = new SymmetricTree();
        // symmetricTree.multiNode(input);
        symmetricTree.printInOrder(symmetricTree.buildTree(input));
        symmetricTree.printInOrder(symmetricTree.buildTree(null));
        symmetricTree.printInOrder(symmetricTree.buildTree(new int[0]));
        System.out.println();
        System.out.println("Expecting \"True\" Getting: " + symmetricTree.isSymmetric(new TreeNode(1)));
        System.out.println("Expecting \"True\" Getting: " + symmetricTree.isSymmetric(new TreeNode()));
        System.out.println("Expecting \"True\" Getting: " + symmetricTree.isSymmetric(symmetricTree.buildTree(input)));
        // this tree fails 1,2,2,null,3,null,3
        TreeNode test = new TreeNode(1);
        test.left = new TreeNode(2);
        test.right = new TreeNode(2);
        test.left.right = new TreeNode(3);
        test.right.right = new TreeNode(3);
        System.out.println("Test1 - Expecting \"False\" Getting: " + symmetricTree.isSymmetric(test));
        test = new TreeNode(1);
        test.left = new TreeNode(2);
        test.right = new TreeNode(2);
        test.left.left = new TreeNode(2);
        test.left.right = null;
        test.right.left = new TreeNode(2);
        System.out.println("Test 2 - Expecting \"False\" Getting: " + symmetricTree.isSymmetric(test));
        test = new TreeNode(1);
        test.left = new TreeNode(2);
        test.right = new TreeNode(2);
        test.left.left = null;
        test.left.right = new TreeNode(3);
        test.right.left = new TreeNode(3);
        System.out.println("Test 3 - Expecting \"True\" Getting: " + symmetricTree.isSymmetric(test));
        // [1,2,2,3,null,null,3]
        test = new TreeNode(1);
        System.out.println("Test 4 - Expecting \"True\" Getting: " + symmetricTree.isSymmetric(test));
        test.left = new TreeNode(2);
        test.right = new TreeNode(2);
        System.out.println("Test 4 - Expecting \"True\" Getting: " + symmetricTree.isSymmetric(test));
//
        TreeNode test1 = new TreeNode();
        System.out.println("Test 1 isSymStack - Expecting \"True\" Getting: " + symmetricTree.isSymStack(test1));
        test1.val = 1;
        System.out.println("Test 2 isSymStack - Expecting \"True\" Getting: " + symmetricTree.isSymStack(test1));
        test1.left = new TreeNode(2);
        System.out.println("Test 3 isSymStack - Expecting \"False\" Getting: " + symmetricTree.isSymStack(test1));
        test1.right = new TreeNode(2);
        System.out.println("Test 4 isSymStack - Expecting \"True\" Getting: " + symmetricTree.isSymStack(test1));
        test1.left.left = new TreeNode(3);
        test1.left.right = new TreeNode(4);
        test1.right.left = new TreeNode(4);
        test1.right.right = new TreeNode(3);
        System.out.println("Test 5 isSymStack - Expecting \"True\" Getting: " + symmetricTree.isSymStack(test1));
        // [1,2,2,null,3,null,3]
        test1 = new TreeNode();
        test1.val = 1;
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(2);
        test1.left.right = new TreeNode(3);
        test1.right.right = new TreeNode(3);
        System.out.println("Test 6 isSymStack - Expecting \"False\" Getting: " + symmetricTree.isSymStack(test1));
        // [1,2,2,3,4,4,3]
        test1 = new TreeNode();
        test1.val = 1;
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(2);
        test1.left.left = new TreeNode(3);
        test1.left.right = new TreeNode(4);
        test1.right.left = new TreeNode(4);
        test1.right.right = new TreeNode(3);
        System.out.println("Test 7 isSymStack - Expecting \"True\" Getting: " + symmetricTree.isSymStack(test1));
    }
}

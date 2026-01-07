import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 

public class MaximumLevelSumOfABinaryTree {
    public static int maxLevelSum(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int maxLevelSum = Integer.MIN_VALUE;
        int currLevel = 1;
        int maxLevel = 1;

        while(!q.isEmpty()){
            int size = q.size();
            int currLevelSum = 0;

            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                currLevelSum += node.val;

                if(node.left!= null) q.add(node.left);
                if(node.right!= null) q.add(node.right);
            }

            if(currLevelSum > maxLevelSum) {
                maxLevelSum = currLevelSum;
                maxLevel = currLevel;
            }

            currLevel++;
        }
        return maxLevel;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(989);
        root.left = null;
        root.right = new TreeNode(10250);
        root.right.left = new TreeNode(98693);
        root.right.right = new TreeNode(-89388);
        root.right.right.left = null;
        root.right.right.right = new TreeNode(-32127);
        System.out.println(maxLevelSum(root));
    }
}

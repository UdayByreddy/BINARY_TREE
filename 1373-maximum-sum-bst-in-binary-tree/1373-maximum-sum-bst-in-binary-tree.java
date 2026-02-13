/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ansMax = 0;
    class Info{
        boolean isBST;
        int sum;
        int min;
        int max;
        public Info(boolean isBST,int sum,int min,int max){
            this.isBST = isBST;
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ansMax;
    }
    public Info dfs(TreeNode root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info left = dfs(root.left);
        Info right = dfs(root.right);
        if(left.isBST && right.isBST && left.max<root.val && root.val<right.min){
            int sum = left.sum+right.sum+root.val;
            ansMax = Math.max(ansMax,sum);
            int min = Math.min(root.val,left.min);
            int max = Math.max(root.val,right.max);
            return new Info(true,sum,min,max);
        }
        return new Info(false,0,0,0);
    }
}
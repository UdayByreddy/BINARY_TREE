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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return false;
        List<Integer> arr = new ArrayList<>();
        inOrder(root,arr);
        for(int i=1;i<arr.size();i++){
            if(arr.get(i)<=arr.get(i-1)) return false;
        }
        return true;
        
    }
    public void inOrder(TreeNode root, List<Integer> ans){
        if(root==null) return ;
        inOrder(root.left,ans);
        ans.add(root.val);
        inOrder(root.right,ans);
    }
}
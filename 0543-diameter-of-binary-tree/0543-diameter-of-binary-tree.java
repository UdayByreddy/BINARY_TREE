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
    int diameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
    
       height(root);
       return diameter;


       /* HashMap<TreeNode,Integer> map = new HashMap<>();
        Stack<TreeNode> stk = new Stack<>();
        int diamter=0;
        if(root!=null){
            stk.push(root);
        }
        while(!stk.isEmpty()){
            TreeNode node = stk.peek();
            if(node.left!=null&&!map.containsKey(node.left)){
                stk.push(node.left);
            }
            else if(node.right!=null&&!map.containsKey(node.right)){
                stk.push(node.right);
            }
            else{
                stk.pop();
                int leftDepth = map.getOrDefault(node.left,0);
                int rightDepth = map.getOrDefault(node.right,0);

                map.put(node,1+Math.max(leftDepth, rightDepth));

                 diamter = Math.max(diamter,leftDepth+rightDepth);

            }
        }
        return diamter;*/
        
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        diameter = Math.max(diameter,left+right);

        return 1+Math.max(left,right);
    }
}
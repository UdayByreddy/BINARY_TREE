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
class BSTIterator {
    List<Integer> arr = new ArrayList<>();
    int index=0;

    public BSTIterator(TreeNode root) {
        if(root==null) return;
        Iter(root);
    }
    public void Iter(TreeNode root){
        if(root==null) return ;
        Iter(root.left);
        arr.add(root.val);
        Iter(root.right);
    }
    
    public int next() {
        return arr.get(index++);
    }
    
    public boolean hasNext() {
        return index<arr.size();
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
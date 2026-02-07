/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp==null){
                sb.append("#,");
            }
            else{
                sb.append(temp.val).append(",");
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] values = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
        int i=1;
        while(!queue.isEmpty() || i<values.length){
            TreeNode temp = queue.poll();
            if(!values[i].equals("#")){
                temp.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(temp.left);
            }
            i++;
            if(!values[i].equals("#")){
                temp.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(temp.right);
            }
            i++;
        }
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
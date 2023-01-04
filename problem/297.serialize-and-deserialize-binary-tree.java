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
        return serialize(root, "");
    }

    public String serialize(TreeNode root, String str) {
        if(root==null){
            str += "null,";
            return str;
        }

        str += (String.valueOf(root.val)+",");
        str = serialize(root.left, str);
        str = serialize(root.right, str);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        List<String> l = new ArrayList<>();
        for(int i=0; i<arr.length; ++i){
            l.add(arr[i]);
        }
        return deserialize(l);
    }

    public TreeNode deserialize(List<String> l) {
        if(l.get(0).equals("null")){
            l.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(l.get(0)));
        l.remove(0);
        node.left = deserialize(l);
        node.right = deserialize(l);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
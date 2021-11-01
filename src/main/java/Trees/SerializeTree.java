package Trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeTree {

    String delimeter = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuffer sb){
        if (node == null){
            sb.append("-1").append(delimeter);
            return;
        }
        sb.append(node.val).append(delimeter);
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList(Arrays.asList(data.split(delimeter)));
        return deserialize(nodes);
    }

    private TreeNode deserialize(Queue<String> nodes){
        int val = Integer.valueOf(nodes.remove());
        if (val == -1)
            return null;
        TreeNode node = new TreeNode(val);
        node.left = deserialize(nodes);
        node.right = deserialize(nodes);
        return node;
    }


}

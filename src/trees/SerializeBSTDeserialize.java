package trees;

import java.util.Arrays;

/**
 * Created by sergei.kostin on 3/7/18.
 */
public class SerializeBSTDeserialize {

    public String serialize(BinarySearchTree.TreeNode root){
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }

    private void serialize(BinarySearchTree.TreeNode root, StringBuilder builder) {
        if(root == null) {
            builder.append("X,");
            return;
        }
        builder.append(root.value + ",");
        serialize(root.left, builder);
        serialize(root.right, builder);
    }

    public BinarySearchTree.TreeNode deserialize(String data){
        String[] dataArr = data.split(",");
        IntWrapper wrapper = new IntWrapper();

        BinarySearchTree.TreeNode root = deserialize(dataArr, wrapper);

        return root;
    }

    private BinarySearchTree.TreeNode deserialize(String[] data, IntWrapper intWrapper) {
        if(intWrapper.index >= data.length || data[intWrapper.index].equals("X")) return null;
        BinarySearchTree.TreeNode node = new BinarySearchTree.TreeNode(Integer.parseInt(data[intWrapper.index]));
        node.left = deserialize(data, intWrapper.incremnt());
        node.right = deserialize(data, intWrapper.incremnt());
        return node;

    }

    private class IntWrapper{
        int index = 0;

        public IntWrapper incremnt(){
            index++;
            return this;
        }
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(40);
        tree.insert(20);
        tree.insert(60);
        tree.insert(10);
        tree.insert(30);
        tree.insert(50);
        tree.insert(80);
        tree.printPreOrder(tree.getRoot());
        System.out.println();

        SerializeBSTDeserialize serializer = new SerializeBSTDeserialize();
        String res = serializer.serialize(tree.getRoot());
        System.out.println(res);


        BinarySearchTree.TreeNode temp = serializer.deserialize(res);
        tree.printPreOrder(temp);
    }

}

package trees;

import search.BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 1/5/18.
 */
public class PrintTreePath {

    public void printTreePaths(BinarySearchTree.TreeNode root, List<Integer> result, List<String> stringResult){
        if(root == null) return;
        if(root.left == null && root.right == null){
            result.add(root.value);
            stringResult.add(convertList(result));
            result.remove(result.get(result.size()-1));
            return;
        }
        result.add(root.value);
        printTreePaths(root.left, result, stringResult);
        printTreePaths(root.right, result, stringResult);
        result.remove(result.size()-1);
    }

    private String convertList(List<Integer> list){
        StringBuilder builder = new StringBuilder();
        for(Integer elem : list){
            builder.append(elem + "->");
        }
        builder.replace(builder.length()-2, builder.length(), "");
        return builder.toString();
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(40);
        bst.insert(60);
        bst.insert(20);
        bst.insert(15);
        bst.insert(27);
        bst.insert(25);
        bst.insert(45);
        PrintTreePath pt = new PrintTreePath();
        List<String> result = new ArrayList<>();
        pt.printTreePaths(bst.getRoot(), new ArrayList<>(), result);
        for(String elem : result){
            System.out.println(elem);
        }
    }

}

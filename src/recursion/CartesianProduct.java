package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 11/11/17.
 *
 * Given a list of list of Strings. Print cartesian product of lists.
 * input -> {"Hello", "World"} , {"Game"}, {"Go","Home"}
 * output ->
 * Hello Game Go
 * Hellow Game Home
 * World Game Go
 * World Game Home
 */
public class CartesianProduct {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Hello");
        list1.add("World");

        List<String> list2 = new ArrayList<>();
        list2.add("Game");
        list2.add("To");
        list2.add("Boo");

        List<String> list3 = new ArrayList<>();
        list3.add("Go");
        list3.add("Home");

        List<List<String>> input = new ArrayList<>();
        input.add(list1);
        input.add(list2);
        input.add(list3);


        CartesianProduct cp = new CartesianProduct();

        cp.wordCartisianProduct(input);

    }

    private void wordCartisianProduct(List<List<String>> input){
        wordCartisianProduct(input, new ArrayList<>(), 0);
    }

    private void wordCartisianProduct(List<List<String>> input, List<String> temp, int level){
        if(level == input.size()){
            System.out.println(temp);
            return;
        }

        for(int i = 0; i < input.get(level).size(); i++){
            temp.add(input.get(level).get(i));
            wordCartisianProduct(input, temp, level+1);
            temp.remove(level);
        }

    }



}

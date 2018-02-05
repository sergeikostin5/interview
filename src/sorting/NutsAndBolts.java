package sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a set of n nuts of different sizes and n bolts of different sizes. There is a one-one mapping between nuts and
 * bolts. Match nuts and bolts efficiently.
 *
 * Constraint:
 * Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut can only be compared with
 * bolt and bolt can only be compared with nut to see which one is bigger/smaller.
 *
 * https://www.geeksforgeeks.org/nuts-bolts-problem-lock-key-problem/
 */
public class NutsAndBolts {


    private interface Part extends Comparable<Part>{
        int getSize();

    }

    private static class Nutt implements Part{
        String name;
        int size;

        Nutt(String name, int size){
            this.name = name;
            this.size = size;
        }

        @Override
        public int getSize(){
            return size;
        }

        @Override
        public String toString() {
            return "Nutt{" +
                    "name='" + name + '\'' +
                    ", size=" + size +
                    '}';
        }

        @Override
        public int compareTo(Part o) {
            return this.getSize() - o.getSize();
        }
    }

    private static class Bolt implements Part{
        String name;
        int size;

        Bolt(String name, int size){
            this.name = name;
            this.size = size;
        }

        @Override
        public int getSize(){
            return size;
        }

        @Override
        public String toString() {
            return "Bolt{" +
                    "name='" + name + '\'' +
                    ", size=" + size +
                    '}';
        }

        @Override
        public int compareTo(Part o) {
            return this.getSize() - o.getSize();
        }
    }

    public void sort(Nutt[] nuts, Bolt[] bolts){
        sort(nuts, bolts, 0, nuts.length - 1);
    }

    private void sort(Nutt[] nuts, Bolt[] bolts, int left, int right){

        if(left >=right) return;

        int pivot = partition(bolts, left, right, nuts[left]);
        partition(nuts, left, right, bolts[pivot]);
        sort(nuts, bolts, left, pivot - 1);
        sort(nuts, bolts, pivot + 1, right);
    }

    private int partition(Part[] parts, int left, int right, Part pivot){
        int i = left;
        int j = right;
        while(i < j){
            while(parts[i].compareTo(pivot) < 0){
                i++;
            }
            while(parts[j].compareTo(pivot) > 0){
                j--;
            }
            if(parts[i].compareTo(parts[j]) > 0){
                swap(parts, i, j);
            }
        }
        if(parts[i].compareTo(parts[j]) < 0) swap(parts, i, j);
        return j;

    }

    private void swap(Part[] parts, int i, int j){
        Part temp = parts[i];
        parts[i] = parts[j];
        parts[j] = temp;
     }




    public static void main(String[] args) {

        Nutt[] nuts = {new Nutt("N4", 4), new Nutt("N5", 5),new Nutt("N2", 2),new Nutt("N1", 1),new Nutt("N3", 3), };
        Bolt[] bolts = {new Bolt("B1", 1), new Bolt("B5", 5),new Bolt("B3", 3),new Bolt("B4", 4),new Bolt("N2", 2), };
        NutsAndBolts nb = new NutsAndBolts();
        nb.sort(nuts, bolts);
        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));
    }
}

package interviews;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergei.kostin on 4/3/18.
 */
public class SnapInterview {

    private static class Pair{
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        String file1 = "dog,cat;Aaron,Sergei";
        String file2 = "Aaron had a dog";
        convert(file1, file2);
    }

    public static void convert(String file1, String file2){
        List<Pair> defs = new ArrayList<>();
        String[] lines = file1.split(";");
        for(String line : lines){
            String[] parts = line.split(",");
            if(parts[0].length() > 0) defs.add(new Pair(parts[0], parts[1]));
        }

        String all = file2;
        for(Pair def : defs){
            String[] words = all.split(" ");
            List<String> newAll = new ArrayList<>();
            for(String word : words){
                if(word.equals(def.first)){
                    newAll.add(def.second);
                } else {
                    newAll.add(word);
                }
            }
            String s = "";
            for(String temp : newAll){
                s = s + " " +temp;
            }
            all = s;
        }

        System.out.println(all);


    }

}

//// This is the text editor interface.
//// Anything you type or change here will be seen by the other person in real time.
///*class Pair {
//  str first;
//  str second;
//
//  Pair(first, second) {
//    this.first = first;
//    this.second = second;
//  }
//}
//
//func convert(file1, file2) {
//  Pair[] defs = [];
//  str[] lines = readLines(file1);
//  foreach (str line in lines) {
//    str[] parts = line.split(',');
//    if (parts[0].length > 0) {
//      defs.push(new Pair(parts[0], parts[1]));
//    }
//  }
//
//  str all = readContents(file2);
//  foreach (Pair def in defs) {
//    str[] words = all.split(' ');
//    str[] newAll = [];
//    foreach (str word in words) {
//      if (word == def.first) {
//        newAll.push(def.second);
//      } else {
//        newAll.push(word);
//      }
//    }
//    all = newAll.join(' ');
//  }
//
//
//  print(all);
//}
//}

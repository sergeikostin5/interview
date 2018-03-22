package recursion;

import java.util.*;

// https://leetcode.com/problems/remove-invalid-parentheses/discuss/75032/share-my-java-bfs-solution
public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();
        if(s == null) return result;

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.add(s);
        visited.add(s);

        boolean found = false;

        while(!q.isEmpty() ){
            String current = q.remove();

            if(isValid(current)){
                found = true;
                result.add(current);
            }

            if(found) continue;

            for(int i = 0; i < current.length(); i++){
                if(current.charAt(i) != '(' && current.charAt(i) != ')') continue;
                String temp = current.substring(0, i) + current.substring(i+1, current.length());
                if(!visited.contains(temp)) {
                    q.add(temp);
                    visited.add(temp);
                }
            }
        }
        return result;
    }

    private boolean isValid(String s){
        int open = 0;
        for(char c : s.toCharArray()){
            if(c == '(') open++;
            else if(c == ')') open --;
            if(open < 0) return false;
        }

        return open == 0;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses rip = new RemoveInvalidParentheses();
        System.out.println(rip.removeInvalidParentheses("(((k()(("));





    }
}

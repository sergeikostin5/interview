package search;

/**
 * Cracking the coding interview 11.5
 *
 * Given a sorted array of strings which is interspersed with empty string, write a method to find the
 * location of a given string
 * Example:
 * {"for", "", "", "", "geeks","ide", "", "practice", "" ,"", "quiz", "", ""};
 *
 * https://www.geeksforgeeks.org/search-in-an-array-of-strings-where-non-empty-strings-are-sorted/
 */
public class SearchWithEmptyStrings {

    public int search(String[] arr, String target){
        return search(arr, target, 0, arr.length - 1);
    }

    private int search(String[] arr, String target, int left, int right){

        if(left > right) return -1;

        int mid = left + (right - left)/2;
        if( arr[mid].isEmpty()){
            mid = findNextNonEmpty(arr, mid, left, right);
            if(mid == -1) return -1;
        }
        if(arr[mid].compareTo(target) < 0 ) return search(arr, target, mid + 1, right);
        else if(arr[mid].compareTo(target) > 0) return search(arr, target, left, mid - 1);
        else return mid;
    }

    private int findNextNonEmpty(String[] arr, int mid, int left, int right){
        int i = mid - 1;
        int j = mid + 1;
        while(i >= left || j<=right){
            if(i >=left && !arr[i].isEmpty()) return i;
            if(j <= right && !arr[j].isEmpty()) return j;
            i--; j++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] arr = {"for", "", "", "", "geeks","ide", "", "practice", "" ,"", "quiz", "", ""};
        SearchWithEmptyStrings s = new SearchWithEmptyStrings();
        System.out.println(s.search(arr, "ide"));
    }

}

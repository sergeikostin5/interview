package interviews.square;

import java.util.*;

/**
 * Created by sergei.kostin on 4/10/18.
 */
class TeachersStudents {
    public static void main (String[] args) {

        List<String> teachers = new ArrayList<>();
        teachers.add( "Teacher 1" );
        teachers.add( "Teacher 2" );
        teachers.add( "Teacher 3" );

        List<String> students = new ArrayList<>();
        students.add( "Student 1" );
        students.add( "Student 2" );
        students.add( "Student 3" );
        students.add( "Student 4" );
        students.add( "Student 5" );
        students.add( "Student 6" );
        students.add( "Student 7" );
        students.add( "Student 8" );
        students.add( "Student 9" );
        students.add( "Student 10" );
        students.add( "Student 11" );

        printAssignments( getAssign( teachers, students, 1 , null) );
    }

    private static void printAssignments( Map<String, List<String>> map ) {
        for ( Map.Entry<String, List<String>> entry : map.entrySet() ) {
            System.out.print( "" + entry.getKey() + " -> " );
            printList( entry.getValue() );
            System.out.println();
        }
    }

    private static void printList( List<String> list ) {
        for ( String str : list ) {
            System.out.print( str + "," );
        }
    }

    public static Map<String, List<String>> getAssign(List<String> teachers, List<String> students, int max, Map<String, List<String>> prefs){

        Map<String, List<String>> map = new HashMap<>();
        for(String teacher : teachers){
            map.put(teacher, new LinkedList<String>());
        }


        int i = 0;
        int curMax = 0;
        while(true){
            if(i == students.size()) return map;
            if(curMax == max) break;
            for( String key : map.keySet() ){
                if(i == students.size()) break;
                map.get(key).add(students.get(i));
                i++;
            }
            curMax++;
        }

        LinkedList<String> unassigned = new LinkedList<String>();
        for(int k = i; k <students.size(); k++){
            unassigned.add(students.get(k));
        }
        map.put( "unassigned", unassigned );


        return map;


    }



}

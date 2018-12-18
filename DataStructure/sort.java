import java.util.*;

class Sort {
    public static void main(String[] args) {
        /** int sort */
        int[] arr = {2, 1, 4, 3, 5};

        // int sort asc
        Arrays.sort(arr);
        
        
        /** Integer sort */
        Integer[] arr2 = new Integer[] {2, 1, 4, 3, 5};

        // Integer sort asc
        Arrays.sort(arr2);        

        // Integer sort desc
        Arrays.sort(arr2, Collections.reverseOrder());



        /** List sort using Collections */
        List<Integer> array = new ArrayList<Integer>();
        array.add(2); array.add(1); array.add(4); array.add(3); array.add(5);

        // List sort asc
        Collections.sort(array);

        // List sort desc
        Collections.sort(array, Collections.reverseOrder());



        /** Set sort */
        Set<Integer> set = new HashSet<Integer>();
        set.add(2); set.add(1); set.add(4); set.add(3); set.add(5); 

        // from set to list
        List<Integer> setList = new ArrayList<Integer>(set);

        Collections.sort(setList);
    }   
}
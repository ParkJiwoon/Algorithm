// https://programmers.co.kr/learn/courses/30/lessons/17681

class Solution {
    static public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++) {          
            String temp = Integer.toBinaryString(arr1[i] | arr2[i]);  
            temp = String.format("%" + n + "s", temp);
            temp = temp.replaceAll("1", "#");
            temp = temp.replaceAll("0", " ");
            answer[i] = temp;
        }
        
        return answer;
    }
}

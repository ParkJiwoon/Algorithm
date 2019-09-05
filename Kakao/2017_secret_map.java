// https://programmers.co.kr/learn/courses/30/lessons/17681

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++) {          
            String temp = Integer.toBinaryString(arr1[i] | arr2[i]);  
            String ans = "";
            //System.out.println(temp);
            for(int k=0; k<temp.length(); k++) {
                if(temp.charAt(k) == '1')
                    ans += "#";
                else 
                    ans += " ";
            }
            
            while(true) {
                if(ans.length() == n)
                    break;
                else {
                    ans = " " + ans;
                }
            }
            
            System.out.println(ans);
            
            answer[i] = ans;
        }
        
        return answer;
    }
  }
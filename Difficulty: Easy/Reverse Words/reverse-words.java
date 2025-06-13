class Solution {
    // Function to reverse words in a given string
    public String reverseWords(String s) {
        // Code here
        
        Stack<String> st = new Stack<>();
        String word = "";
        
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            
            if(curr == ' '){
                if(!word.isEmpty()){
                    st.push(word);
                    word = "";
                }
            }
                else{
                    word += curr;
                }
            }
            
            if(!word.isEmpty()){
                st.push(word);
            }
            
            String ans = "";
            while(!st.isEmpty()){
                ans += st.pop();
                if(!st.isEmpty()){
                    ans += " "; 
                }
            }
        
            return ans;
        
    }
}

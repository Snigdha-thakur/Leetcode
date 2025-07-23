class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] answer = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int prevDayIndex = st.pop(); 
                answer[prevDayIndex] = i - prevDayIndex; 
            }
            st.push(i); 
        }
        return answer;
    }
}
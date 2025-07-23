import java.util.*;
class MyQueue {
    Stack<Integer> s1= new Stack<>();
    Stack<Integer> s2= new Stack<>();
    
    public void push(int x) {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        return s1.pop();
        
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty();
    }
}
public class Solution{
    public static void main(String[] arg){
        MyQueue q= new MyQueue();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.empty());
    }
}


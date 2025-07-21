class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
       if(head==null) return head;
       int c = 0;
       ListNode cur = head;
       while(cur!=null&&c<k){
           cur = cur.next;
           c++;
       }
       if(c==k){//if we have k nodes 
           ListNode prev = null, temp = head,nxt;
           for(int i=1;i<=k;i++){
               nxt = temp.next;
               temp.next = prev;
               prev = temp;
               temp = nxt;
           }
           head.next = reverseKGroup(cur,k);//3 2 1 6 5 4 7 8
           return prev;
       }
       return head;
    }
}  
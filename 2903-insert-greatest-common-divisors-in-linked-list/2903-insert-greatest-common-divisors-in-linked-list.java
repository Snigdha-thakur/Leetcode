
class Solution {
    int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode cur=head;
        while(cur.next!=null){
            ListNode nxt=cur.next;//next node of the cur node
            int g= gcd(cur.val,nxt.val);
            ListNode newnode= new ListNode(g);
            cur.next= newnode;
            newnode.next=nxt;
            cur= cur.next.next;//two nodes skip(because of gcd inserted)
        }
        return head;

    }
}
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0||head==null|| head.next==null)return head;
       ListNode cur= head;
       int len=1;
    while(cur.next!=null){
        len++;
        cur= cur.next;// moves to the last node
    }
    cur.next= head;//circular linkwdlist
    k=k%len;//for k exceeds len of the list 2%5=>2
    ListNode temp= head;
    for(int i=1; i<(len-k);i++){//upto 5-2=>3rd index it will move
        temp=temp.next;//until the rotation index
    }
    head= temp.next;//head=>3->next which is 4
    temp.next=null;//3->next we are making null
    return head;//4->5->1->2->3->null
    }
}
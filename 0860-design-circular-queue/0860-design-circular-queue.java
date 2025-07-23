class MyCircularQueue {
    int[] queue;
    int size;
    int front,rear;

    public MyCircularQueue(int k) {
        size=k;
        queue= new int[k];
        front= rear= -1;
    }
    
    public boolean enQueue(int value) {
        if(( rear + 1) % size== front) return false;
        if(rear== -1){
            front=rear=0;
        }else{
            rear= (rear+1)% size;
        }
        queue[rear]= value;
        return true;
        
    }
    
    public boolean deQueue() {
        if(front== -1) return false;
        if(front== rear){
            front= rear=-1;
        }else{
            front= (front+1)%size;
        }
        return true;
    }
    
    public int Front() {
        
        if(front== -1) return -1;
        return queue[front];
    }
    
    public int Rear() {
        if(rear==-1) return  -1;
        return queue[rear];
        
    }
    
    public boolean isEmpty() {
        return front==-1;
        
    }
    
    public boolean isFull() {
        return(rear+ 1)% size== front;
    }
}


public class queue16{
    int[] data;
    int front;
    int rear;
    int size;
    int max;

    public queue16(int n){
        max = n;
        data = new int[max];
        size = 0;
        front = rear =-1;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }
    public boolean isFull(){
        if(size == max){
            return true;
        }else{
            return false;
        }
    }
    public void isPeek(){
        if(!isEmpty()){
            System.out.println("Elemen terdepan: "+data[front]);
        }else{
            System.out.println("Queue masih kosong");
        }
    }
    void print(){
        if(isEmpty()){
            System.out.println("Queue masih kosong");
        }else{
            int i = front;
            while (i != rear){
                System.out.print(data[i]+" ");
                i = (i+1) % max;
            }
            System.out.println(data[i]+" ");
            System.out.println("Jumlah elemen: "+size);
        }
    }
    void clear(){
        if(!isEmpty()){
            front=rear=-1;
            size = 0;
            System.out.println("Queue berhasil dikosongkan");
        }else{
            System.out.println("Queue masih kosong");
        }
    }
    void enqueue(int dt){
        if(isFull()){
            System.out.println("Queue sudah penuh");
            System.exit(0);
        }else{
            if(isEmpty()){
                front=rear=0;
            }else{
                if(rear == max -1){
                    rear=0;
                }else{
                    rear++;
                }
            }
            data[rear] = dt;
            size++;
        }
    }
    int dequeue(){
        if(isEmpty()){
            System.out.println("Queue masih kosong");
            System.exit(0);
            return -1;
        }else{
            int dt=data[front];
            size--;
            if(isEmpty()){
                front= rear =-1;
            }else{
                if(front == max-1){
                    front=0;
                }else{
                    front++;
                }
            }
            return dt;
        }
    }
}
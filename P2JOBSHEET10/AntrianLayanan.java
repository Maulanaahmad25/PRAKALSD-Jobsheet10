package P2JOBSHEET10;

public class AntrianLayanan {
    Mahasiswa16[]data;
    int front;
    int rear;
    int size;
    int max;
    
    public AntrianLayanan(int max){
        this.max = max; 
        this.data = new Mahasiswa16[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
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
    public void lihatTerdepan(){
        if(isEmpty()){
            System.out.println("Antrian masih kosong");
        }else{
            System.out.print("Mahasiswa terdepan:");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data[front].tampilkanData();
        }
    }
    void tampilkanSemua(){
        if(isEmpty()){
            System.out.println("Antrian masih kosong");
            return;
        }
        System.out.println("Daftra Mahasiswa dalam Antrian");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        for(int i=0;i<size;i++){
            int index=(front+i)%max;
            System.out.print((i+1)+". ");
            data[index].tampilkanData();
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
    void tambahAntrian(Mahasiswa16 mhs){
        if(isFull()){
            System.out.println("Antrian sudah penuh,tidak dapat menambah mahasiswa");
            return;
        }rear= (rear+1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama +" berhasil masuk antrian");
    }
    public Mahasiswa16 layaniMahasiswa(){
        if(isEmpty()){
            System.out.println("Queue masih kosong");
            return null;
        }Mahasiswa16 mhs=data[front];
        front= (front+1) % max;
        size--;
        return mhs;
    }
    public int getJumlagAntrian(){
        return size;
    }
    public void lihatAkhir(){
        if(isEmpty()){
            System.out.println("Antrian masih kosong");
        }else{
            System.out.println("Mahasiswa terakhir:");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data[rear].tampilkanData();
        }
    }
}



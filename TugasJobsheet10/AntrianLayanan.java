package TugasJobsheet10;

public class AntrianLayanan {
    Mahasiswa16[] data;
    int front;
    int rear;
    int size;
    int max;
    int totalDiproses;

    public AntrianLayanan(int max) {
        this.max = max;
        this.data = new Mahasiswa16[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.totalDiproses = 0;
    }

    //cek apakah antrian kosong
    public boolean cekAntrianKosong() {
        return size == 0;
    }

    //cek apakah antrian penuh
    public boolean cekAntrianPenuh() {
        return size == max;
    }

    //Mengosongkan seluruh antrian
    public void kosongkanAntrian() {
        if (!cekAntrianKosong()) {
            front = rear = -1;
            size = 0;
            System.out.println("Queue berhasil dikosongkan");
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void tambahAntrian(Mahasiswa16 mhs) {
        if (cekAntrianPenuh()) {
            System.out.println("Antrian sudah penuh, tidak dapat menambah mahasiswa");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk antrian");
    }

    //Memproses 1 mahasiswa dalam antrian (layanan KRS)
    public Mahasiswa16 prosesKRS() {
        if (cekAntrianKosong()) {
            System.out.println("Queue masih kosong");
            return null;
        }
        Mahasiswa16 mhs = data[front];
        front = (front + 1) % max;
        size--;
        totalDiproses++;
        return mhs;
    }

    //untuk memproses 2 mahasiswa terdepan dalam antrian sekaligus
    public void prosesKRSBatch() {
        if (size < 2) {
            System.out.println("Antrian kurang dari 2 mahasiswa, tidak bisa memproses 2 sekaligus.");
            return;
        }
        System.out.println("Memproses KRS untuk dua mahasiswa:");
        for (int i = 0; i < 2; i++) {
            Mahasiswa16 mhs = prosesKRS();
            if (mhs != null) {
                mhs.tampilkanData();
            }
        }
    }

    //Menampilkan mahasiswa paling depan dalam antrian
    public void lihatMahasiswaTerdepan() {
        if (cekAntrianKosong()) {
            System.out.println("Antrian masih kosong");
        } else {
            System.out.println("Mahasiswa terdepan:");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data[front].tampilkanData();
        }
    }

    //Menampilkan seluruh mahasiswa dalam antrian
    public void tampilkanSemuaAntrian() {
        if (cekAntrianKosong()) {
            System.out.println("Antrian masih kosong");
            return;
        }
        System.out.println("Daftar Mahasiswa dalam Antrian:");
        System.out.println("NIM - NAMA - PRODI - KELAS");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    //Menampilkan mahasiswa paling akhir dalam antrian
    public void lihatMahasiswaTerakhir() {
        if (cekAntrianKosong()) {
            System.out.println("Antrian masih kosong");
        } else {
            System.out.println("Mahasiswa terakhir:");
            System.out.println("NIM - NAMA - PRODI - KELAS");
            data[rear].tampilkanData();
        }
    }

    //Mengembalikan jumlah mahasiswa yang sedang dalam antrian
    public int jumlahAntrian() {
        return size;
    }

    //Mengembalikan jumlah mahasiswa yang sudah melakukan proses KRS
    public int jumlahSudahDiproses() {
        return totalDiproses;
    }

    //Menghitung jumlah mahasiswa yang belum melakukan proses KRS dari total quota (3 DPA x 30 = 90)
    public int jumlahBelumDiproses() {
        return 90 - totalDiproses;
    }
}


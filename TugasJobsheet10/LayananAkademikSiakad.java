package TugasJobsheet10;
import java.util.Scanner;

public class LayananAkademikSiakad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianLayanan antrian = new AntrianLayanan(10);
        int pilihan;

        do {
            System.out.println("\n=== Menu Antrian Layanan Akademik ===");
            System.out.println("1. Tambah Mahasiswa ke Antrian");
            System.out.println("2. Proses 1 Mahasiswa (KRS)");
            System.out.println("3. Proses 2 Mahasiswa (Batch KRS)");
            System.out.println("4. Lihat Mahasiswa Terdepan");
            System.out.println("5. Lihat Semua Antrian");
            System.out.println("6. Lihat Mahasiswa Terakhir");
            System.out.println("7. Cetak Jumlah Antrian");
            System.out.println("8. Cetak Jumlah Sudah Proses KRS");
            System.out.println("9. Cetak Jumlah Belum Proses KRS");
            System.out.println("10. Kosongkan Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt(); sc.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.print("NIM: ");
                    String nim = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi: ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = sc.nextLine();
                    Mahasiswa16 mhs = new Mahasiswa16(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(mhs);
                    break;
                case 2:
                    Mahasiswa16 satu = antrian.prosesKRS();
                    if (satu != null) {
                        System.out.println("Memproses mahasiswa:");
                        satu.tampilkanData();
                    }
                    break;
                case 3:
                    antrian.prosesKRSBatch();
                    break;
                case 4:
                    antrian.lihatMahasiswaTerdepan();
                    break;
                case 5:
                    antrian.tampilkanSemuaAntrian();
                    break;
                case 6:
                    antrian.lihatMahasiswaTerakhir();
                    break;
                case 7:
                    System.out.println("Jumlah mahasiswa dalam antrian: " + antrian.jumlahAntrian());
                    break;
                case 8:
                    System.out.println("Jumlah mahasiswa yang sudah proses KRS: " + antrian.jumlahSudahDiproses());
                    break;
                case 9:
                    System.out.println("Jumlah mahasiswa yang belum proses KRS: " + antrian.jumlahBelumDiproses());
                    break;
                case 10:
                    antrian.kosongkanAntrian();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan layanan!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
        sc.close();
    }
}

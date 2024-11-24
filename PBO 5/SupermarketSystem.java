import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SupermarketSystem {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Login Process
            System.out.println("Log in");
            System.out.println("+-----------------------------------------------------+");
            System.out.print("Username     : ");
            String username = scanner.nextLine();
            System.out.print("Password     : ");
            String password = scanner.nextLine();

            // Generate a simple CAPTCHA
            String captcha = generateCaptcha();
            System.out.print("Captcha      : " + captcha + "\nEnter Captcha: ");
            String captchaInput = scanner.nextLine();

            if (username.equals("admin") && password.equals("12345") && captchaInput.equals(captcha)) {
                System.out.println("Login berhasil\n");
            } else {
                System.out.println("Login gagal, silakan diulangi.");
                return;
            }

            // Supermarket Display
            System.out.println("Selamat Datang di Supermarket ModernMart");
            String currentDateTime = getCurrentDateTime();
            System.out.println("Tanggal dan Waktu : " + currentDateTime);

            System.out.println("+----------------------------------------------------+");

            // Transaction Process
            System.out.print("No. Faktur      : ");
            String noFaktur = scanner.nextLine();
            System.out.print("Kode Barang     : ");
            String kodeBarang = scanner.nextLine();
            System.out.print("Nama Barang     : ");
            String namaBarang = scanner.nextLine();
            System.out.print("Harga Barang    : Rp ");
            double hargaBarang = scanner.nextDouble();
            System.out.print("Jumlah Beli     : ");
            int jumlahBeli = scanner.nextInt();

            // Calculate total
            double total = hargaBarang * jumlahBeli;

            System.out.println("+----------------------------------------------------+");
            System.out.printf("TOTAL           : Rp %.2f\n", total);
            System.out.println("+----------------------------------------------------+");

            scanner.nextLine(); // Consume the newline
            System.out.print("Kasir : ");
            String namaKasir = scanner.nextLine();
        }

        System.out.println("+----------------------------------------------------+");
        System.out.println("Terima kasih telah berbelanja di ModernMart!");
    }

    private static String generateCaptcha() {
        // Simple CAPTCHA generator
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * characters.length());
            captcha.append(characters.charAt(index));
        }
        return captcha.toString();
    }

    private static String getCurrentDateTime() {
        // Format current date and time
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }
}

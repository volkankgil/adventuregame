import java.util.Scanner;

public class Game {

    private Players player;

    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera oyununa hoþgeldiniz.");

        Players player = new Players("Volkan");
        System.out.println(player.getPlayerName() + " Hoþgeldiniz.");
        System.out.println("Lütfen Bir karakter seçiniz ! ");
        player.selectChar();

        location location = null;
        while (true) {
            player.printPlayerinfo();
            System.out.println("--------------");
            System.out.println("BÖLGELER");
            System.out.println("--------------");
            System.out.println("1 - Güvenli Ev");
            System.out.println("2 - Maðaza");

            System.out.println("Lütfen gitmek istediðiniz bölgeyi seçiniz.");
            int selectlocation = input.nextInt();

            switch (selectlocation) {

                case 1:
                    location = new SafeHouse(player);// this yazdýðýmýzda ürettiðimiz player nesnesini referans alýyor.
                    break;

                case 2:
                    location = new ToolStore(player);
                    break;

                default:
                    location = new SafeHouse(player);
            }

            if (!location.onlocation()) {
                System.out.println("Game Over");
                break;
            }
        }
    }
}

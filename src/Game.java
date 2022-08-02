import java.util.Scanner;

public class Game {

    private Players player;

    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera oyununa ho�geldiniz.");

        Players player = new Players("Volkan");
        System.out.println(player.getPlayerName() + " Ho�geldiniz.");
        System.out.println("L�tfen Bir karakter se�iniz ! ");
        player.selectChar();

        location location = null;
        while (true) {
            player.printPlayerinfo();
            System.out.println("--------------");
            System.out.println("B�LGELER");
            System.out.println("--------------");
            System.out.println("1 - G�venli Ev");
            System.out.println("2 - Ma�aza");

            System.out.println("L�tfen gitmek istedi�iniz b�lgeyi se�iniz.");
            int selectlocation = input.nextInt();

            switch (selectlocation) {

                case 1:
                    location = new SafeHouse(player);// this yazd���m�zda �retti�imiz player nesnesini referans al�yor.
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

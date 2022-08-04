import java.util.Scanner;

public class Game {

    private Players player;

    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.print("Macera oyununa ho�geldin " );

        Players player = new Players("Volkan");
        System.out.println( player.getPlayerName() );
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
            System.out.println("3 - Ma�ara  -- Ma�araya gir -- dikkatli ol canavar ��kabilir." );
            System.out.println("4 - Orman  --  Ormana gir --   dikkatli ol canavar ��kabilir." );
            System.out.println("5 - Nehir  --  Nehir gir --    dikkatli ol canavar ��kabilir." );
            System.out.println("0 - ��k�� Yap----Oyunu Sonland�r.");

            System.out.println("L�tfen gitmek istedi�iniz b�lgeyi se�iniz.");
            int selectlocation = input.nextInt();

            switch (selectlocation) {

                case 0:
                    location=null;
                    break;
                case 1:
                    location = new SafeHouse(player);// this yazd���m�zda �retti�imiz player nesnesini referans al�yor.
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                case 4:
                    location=new Forest(player);
                    break;
                case 5:
                    location=new River(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }

            if(location==null){
                System.out.println("Oyun bitti");
                break;
            }

            if (!location.onlocation()) {
                System.out.println("Game Over");
                break;
            }
        }
    }
}

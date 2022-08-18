import java.util.Scanner;

public class Game {

    private Players player;

    private Scanner input = new Scanner(System.in);

    int count1, count2, count3, count4;

    public void start() {
        System.out.print("Macera oyununa ho�geldin ");

        Players player = new Players("Volkan");
        System.out.println(player.getPlayerName());
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
                System.out.println("3 - Ma�ara  --  Ma�araya gir --  dikkatli ol canavar ��kabilir.");
                System.out.println("4 - Orman   --  Ormana gir   --  dikkatli ol canavar ��kabilir.");
                System.out.println("5 - Nehir   --  Nehir gir    --  dikkatli ol canavar ��kabilir.");
                System.out.println("6 - Maden   --  Maden gir    --  dikkatli ol canavar ��kabilir.");
                System.out.println("0 - ��k�� Yap----Oyunu Sonland�r.");

                System.out.println("L�tfen gitmek istedi�iniz b�lgeyi se�iniz.");
                int selectlocation = input.nextInt();

                switch (selectlocation) {
                    case 0:
                        location = null;
                        break;
                    case 1:
                        location = new SafeHouse(player);// this yazd���m�zda �retti�imiz player nesnesini referans al�yor.
                        break;
                    case 2:
                        location = new ToolStore(player);
                        break;
                    case 3:
                        location = new Cave(player);
                        count1++;
                        if (count1 >= 2) {
                            System.out.println("Buraya temizlediniz.");
                            location = new SafeHouse(player);
                        }
                        break;
                    case 4:
                        location = new Forest(player);
                        count2++;
                        if (count2 >= 2) {
                            System.out.println("Buraya temizlediniz.");
                            location = new SafeHouse(player);
                        }
                        break;
                    case 5:
                        location = new River(player);
                        count3++;
                        if (count3 >= 2) {
                            System.out.println("Buraya temizlediniz.");
                            location = new SafeHouse(player);
                        }
                        break;
                    case 6:
                        location = new coal(player);
                        count4++;
                        if (count4 >= 2) {
                            System.out.println("Buraya temizlediniz.");
                            location = new SafeHouse(player);
                        }
                        break;
                    default:
                        location = new SafeHouse(player);
                }

                if (location == null) {
                    System.out.println("Oyundan ��k�� yap�ld�.");
                    break;
                }


                if (!location.onlocation()) {
                    System.out.println("Game Over");
                    break;
                }

            boolean enter1=(count1 == 1 && count2 == 1);
            boolean enter2=(count3 == 1 && count4 == 1);

            if(enter1 && enter2){
                System.out.println("B�t�n alan� temizlediniz.");
                break;
            }
        }
    }
}

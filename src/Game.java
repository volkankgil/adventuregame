import java.util.Scanner;

public class Game {

    private Players player;

    private Scanner input = new Scanner(System.in);

    int count1, count2, count3, count4;

    public void start() {
        System.out.print("Macera oyununa hoþgeldin ");

        Players player = new Players("Volkan");
        System.out.println(player.getPlayerName());
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
                System.out.println("3 - Maðara  --  Maðaraya gir --  dikkatli ol canavar çýkabilir.");
                System.out.println("4 - Orman   --  Ormana gir   --  dikkatli ol canavar çýkabilir.");
                System.out.println("5 - Nehir   --  Nehir gir    --  dikkatli ol canavar çýkabilir.");
                System.out.println("6 - Maden   --  Maden gir    --  dikkatli ol canavar çýkabilir.");
                System.out.println("0 - Çýkýþ Yap----Oyunu Sonlandýr.");

                System.out.println("Lütfen gitmek istediðiniz bölgeyi seçiniz.");
                int selectlocation = input.nextInt();

                switch (selectlocation) {
                    case 0:
                        location = null;
                        break;
                    case 1:
                        location = new SafeHouse(player);// this yazdýðýmýzda ürettiðimiz player nesnesini referans alýyor.
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
                    System.out.println("Oyundan çýkýþ yapýldý.");
                    break;
                }


                if (!location.onlocation()) {
                    System.out.println("Game Over");
                    break;
                }

            boolean enter1=(count1 == 1 && count2 == 1);
            boolean enter2=(count3 == 1 && count4 == 1);

            if(enter1 && enter2){
                System.out.println("Bütün alaný temizlediniz.");
                break;
            }
        }
    }
}

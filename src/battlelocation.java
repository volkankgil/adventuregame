import java.util.Random;

public class battlelocation extends location{

    monster monster1; // battlelocation 'ýn kendine ait bir monster'ý olmasý için monster deðiþkenin den ürettik.
    private String yemekaward;
    private int maxmonster;

    public battlelocation(Players player, String locationname, monster monster1, String yemekaward, int maxmonster){
        super(player,locationname);
        this.yemekaward = yemekaward;
        this.monster1=monster1;
        this.maxmonster=maxmonster;

    }

    @Override
    public boolean onlocation(){
        int monsterNumber=randomMonsternumber();
        System.out.println("Þu an buradasýnýz." + this.getLocationname());
        System.out.println("Dikkatli ol Burada " + monsterNumber + " adet " + this.getMonster1().getMonsterName() + " yaþýyor.");
        System.out.println("<S>avas yada <Kac>");
        String selectcase=input.nextLine();
        selectcase=selectcase.toUpperCase();//Eðer s'yi küçük harfle girmiþ ise büyütüyor.
        if(selectcase.equals("S")){


            if(combat(monsterNumber)){  //combat metodunu burada çaðýrdýk.
                System.out.println(this.getLocationname() + " tüm düþmanlarý yendiniz.");
                return true;
            }
        }

        if(this.getPlayer().getHealty()<=0){
            System.out.println("Öldünüz.");
            return false;
        }
        return true;
    }
    public boolean combat(int monsterNumber) {
        for (int i = 1; i <= monsterNumber; i++) {
            this.getMonster1().setMonsterHealth(this.getMonster1().getOrjinalHealth());

            playerStats();
            enemyStats(i);

            while (this.getPlayer().getHealty() > 0 && this.getMonster1().getMonsterHealth() > 0) {

                System.out.println(" <V>ur veya <K>ac ");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")) {
                    int a = (int) (Math.random() * 100);

                    if (a <= 50) {
                        System.out.println("Siz Vurdunuz");
                        this.getMonster1().setMonsterHealth(this.getMonster1().getMonsterHealth() - this.getPlayer().getTotaldamage());

                        afterHit();

                        if (this.getMonster1().getMonsterHealth() > 0) {
                            System.out.println();
                            System.out.println("Canavar Size Vurdu");
                            int monsterDamage = this.getMonster1().getMonsterdamage() - this.getPlayer().getInventory().getArmours().getArmoursblocked();
                            if (monsterDamage < 0) {
                                monsterDamage = 0;
                            }
                            System.out.println();
                            this.getPlayer().setHealty(this.getPlayer().getHealty() - monsterDamage);
                            afterHit();
                        }
                    } else if (a > 50) {
                        System.out.println("Canavar Size Vurdu");
                        int monsterDamage = this.getMonster1().getMonsterdamage() - this.getPlayer().getInventory().getArmours().getArmoursblocked();
                        this.getPlayer().setHealty(this.getPlayer().getHealty() - monsterDamage);
                        afterHit();

                        if (this.getPlayer().getHealty() > 0) {
                            this.getMonster1().setMonsterHealth(this.getMonster1().getMonsterHealth() - this.getPlayer().getTotaldamage());
                            afterHit();

                        }
                    }
                } else {
                    return false;//KAÇ YAPAR ÝSE ÇIKMASI ÝÇÝN FALSE DÖNÜYOR
                }
            }
            if (this.getMonster1().getMonsterHealth() == 0) {
                if (this.getLocationname().equals("Coal")) {
                    System.out.println("Dusmani yendiniz !");
                    this.awardGenerator();
                }
            }

                if (this.getMonster1().getMonsterHealth() < this.getPlayer().getHealty()) {
                    System.out.println("Düþmaný Yendiniz.");
                    System.out.println(this.getMonster1().getAward() + " para kazandýnýz.");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster1().getAward());
                    System.out.println("Güncel Paranýz : " + this.getPlayer().getMoney());
                    System.out.println("Bölgeden " +getYemekaward() + " kazandýnýz." );

                } else {
                    return false; //ÖLDÜNÜZ
                }
            }
        return true;
        }

    public void afterHit(){
        System.out.println("Canýnýz : " + this.getPlayer().getHealty());
        System.out.println(this.getMonster1().getMonsterName() + " Canýnýz : " + this.getMonster1().getMonsterHealth());
        System.out.println();
    }
    public void playerStats(){
        System.out.println("Oyuncu Deðerleri:");
        System.out.println("----------------");
        System.out.println("Saðlýk : " + this.getPlayer().getHealty());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeaponClasses().getWeaponName());
        System.out.println("Hasar : " + this.getPlayer().getTotaldamage());
        System.out.println("Zýrh : " + this.getPlayer().getInventory().getArmours().getArmourNAme());
        System.out.println("Bloklama : " +this.getPlayer().getInventory().getArmours().getArmoursblocked());
        System.out.println("Kalan Paranýz : " + this.getPlayer().getMoney());
        System.out.println();
    }

    public void enemyStats(int i){
        System.out.println(i + " . " + this.getMonster1().getMonsterName() + " Deðerleri");
        System.out.println("-------------");
        System.out.println("Saðlýk : " + this.getMonster1().getMonsterHealth());
        System.out.println("Hasar : " + this.getMonster1().getMonsterdamage());
        System.out.println("Ödül : " + this.getMonster1().getAward());
        System.out.println();
    }

    public int randomMonsternumber(){
        Random r=new Random();
        return r.nextInt(this.getMaxmonster())+1; // +1 yaptýk çünkü bu fonksiyonda bounda deðeri 0 ve 2 areasýnda sayý üretiyor.
    }

    public void awardGenerator() {
        int number = (int) (Math.random() * 100);
        if (number < 15) {
            System.out.println("Silah Kazandýnýz.");
            int number2 = (int) (Math.random() * 100);
            if (number2 <= 20) {
                System.out.println("Tebrikler, Tufek kazandiniz !");
                this.getPlayer().getInventory().setWeaponClasses(new weaponClass("Tüfek", 3, 7, 45));
                System.out.println("Yeni silahýnýz: " + this.getPlayer().getInventory().getWeaponClasses().getWeaponName());
            } else if (number2 > 20 && number2 < 50) {
                System.out.println("Tebrikler, Kýlýç kazandiniz !");
                this.getPlayer().getInventory().setWeaponClasses(new weaponClass("Kýlýç", 2, 3, 35));
                System.out.println("Yeni Silahýnýz: " + this.getPlayer().getInventory().getWeaponClasses().getWeaponName());
            } else {
                System.out.println("Tebrikler, Tabanca kazandiniz !");
                this.getPlayer().getInventory().setWeaponClasses(new weaponClass("Tabanca", 1, 2, 25));
                System.out.println("Yeni Silahýnýz: " + this.getPlayer().getInventory().getWeaponClasses().getWeaponName());
            }

        } else if (number > 15 && number < 55) {
            int number2 = (int) (Math.random() * 100);
            System.out.println("Zýrh Kazandýnýz.");
            if (number2 < 20) {
                System.out.println("Tebrikler, Agir zirh kazandiniz !");
                this.getPlayer().getInventory().setArmours(new Armour(3, "Agir", 5, 40));
                System.out.println("Yeni zirhiniz " + this.getPlayer().getInventory().getArmours().getArmourNAme());
            } else if (number2 > 20 && number2 < 50) {
                System.out.println("Tebrikler, Orta zirh kazandiniz !");
                this.getPlayer().getInventory().setArmours(new Armour(2, "Orta", 3, 25));
                System.out.println("Yeni zirhiniz " + this.getPlayer().getInventory().getArmours().getArmourNAme());
            } else {
                System.out.println("Tebrikler, Hafif zirh kazandiniz !");
                this.getPlayer().getInventory().setArmours(new Armour(1, "Hafif", 1, 15));
                System.out.println("Yeni zirhiniz " + this.getPlayer().getInventory().getArmours().getArmourNAme());
            }

        } else if (number > 30 && number < 55) {
            int number2 = (int) (Math.random() * 100);
            System.out.println(" Para Kazandýnýz.");
            if (number2 < 20) {
                System.out.println("Tebrikler, 10 para kazandiniz");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                System.out.println("Guncel paraniz " + this.getPlayer().getMoney());
            } else if (number2 > 20 && number2 < 50) {
                System.out.println("Tebrikler, 5 para kazandiniz");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                System.out.println("Guncel paraniz " + this.getPlayer().getMoney());
            } else {
                System.out.println("Tebrikler, 1 para kazandiniz");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
                System.out.println("Guncel paraniz " + this.getPlayer().getMoney());
            }

        } else {
            System.out.println("Bu canavardan esya yada para dusmedi !");
        }
    }

    public monster getMonster1(){
        return monster1;
    }

    public void setMonster1(monster monster1) {
        this.monster1 = monster1;
    }
    public int getMaxmonster(){
        return maxmonster;
    }
    public void setMaxmonster(int maxmonster) {
        this.maxmonster = maxmonster;
    }

    public String getYemekaward() {
        return yemekaward;
    }

    public void setYemekaward(String yemekaward) {
        this.yemekaward = yemekaward;
    }

}

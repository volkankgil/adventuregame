import java.util.Random;

public class battlelocation extends location{

    monster monster1; // battlelocation '�n kendine ait bir monster'� olmas� i�in monster de�i�kenin den �rettik.
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
        System.out.println("�u an buradas�n�z." + this.getLocationname());
        System.out.println("Dikkatli ol Burada " + monsterNumber + " adet " + this.getMonster1().getMonsterName() + " ya��yor.");
        System.out.println("<S>avas yada <Kac>");
        String selectcase=input.nextLine();
        selectcase=selectcase.toUpperCase();//E�er s'yi k���k harfle girmi� ise b�y�t�yor.
        if(selectcase.equals("S")){


            if(combat(monsterNumber)){  //combat metodunu burada �a��rd�k.
                System.out.println(this.getLocationname() + " t�m d��manlar� yendiniz.");
                return true;
            }
        }

        if(this.getPlayer().getHealty()<=0){
            System.out.println("�ld�n�z.");
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
                    return false;//KA� YAPAR �SE �IKMASI ���N FALSE D�N�YOR
                }
            }
            if (this.getMonster1().getMonsterHealth() == 0) {
                if (this.getLocationname().equals("Coal")) {
                    System.out.println("Dusmani yendiniz !");
                    this.awardGenerator();
                }
            }

                if (this.getMonster1().getMonsterHealth() < this.getPlayer().getHealty()) {
                    System.out.println("D��man� Yendiniz.");
                    System.out.println(this.getMonster1().getAward() + " para kazand�n�z.");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster1().getAward());
                    System.out.println("G�ncel Paran�z : " + this.getPlayer().getMoney());
                    System.out.println("B�lgeden " +getYemekaward() + " kazand�n�z." );

                } else {
                    return false; //�LD�N�Z
                }
            }
        return true;
        }

    public void afterHit(){
        System.out.println("Can�n�z : " + this.getPlayer().getHealty());
        System.out.println(this.getMonster1().getMonsterName() + " Can�n�z : " + this.getMonster1().getMonsterHealth());
        System.out.println();
    }
    public void playerStats(){
        System.out.println("Oyuncu De�erleri:");
        System.out.println("----------------");
        System.out.println("Sa�l�k : " + this.getPlayer().getHealty());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeaponClasses().getWeaponName());
        System.out.println("Hasar : " + this.getPlayer().getTotaldamage());
        System.out.println("Z�rh : " + this.getPlayer().getInventory().getArmours().getArmourNAme());
        System.out.println("Bloklama : " +this.getPlayer().getInventory().getArmours().getArmoursblocked());
        System.out.println("Kalan Paran�z : " + this.getPlayer().getMoney());
        System.out.println();
    }

    public void enemyStats(int i){
        System.out.println(i + " . " + this.getMonster1().getMonsterName() + " De�erleri");
        System.out.println("-------------");
        System.out.println("Sa�l�k : " + this.getMonster1().getMonsterHealth());
        System.out.println("Hasar : " + this.getMonster1().getMonsterdamage());
        System.out.println("�d�l : " + this.getMonster1().getAward());
        System.out.println();
    }

    public int randomMonsternumber(){
        Random r=new Random();
        return r.nextInt(this.getMaxmonster())+1; // +1 yapt�k ��nk� bu fonksiyonda bounda de�eri 0 ve 2 areas�nda say� �retiyor.
    }

    public void awardGenerator() {
        int number = (int) (Math.random() * 100);
        if (number < 15) {
            System.out.println("Silah Kazand�n�z.");
            int number2 = (int) (Math.random() * 100);
            if (number2 <= 20) {
                System.out.println("Tebrikler, Tufek kazandiniz !");
                this.getPlayer().getInventory().setWeaponClasses(new weaponClass("T�fek", 3, 7, 45));
                System.out.println("Yeni silah�n�z: " + this.getPlayer().getInventory().getWeaponClasses().getWeaponName());
            } else if (number2 > 20 && number2 < 50) {
                System.out.println("Tebrikler, K�l�� kazandiniz !");
                this.getPlayer().getInventory().setWeaponClasses(new weaponClass("K�l��", 2, 3, 35));
                System.out.println("Yeni Silah�n�z: " + this.getPlayer().getInventory().getWeaponClasses().getWeaponName());
            } else {
                System.out.println("Tebrikler, Tabanca kazandiniz !");
                this.getPlayer().getInventory().setWeaponClasses(new weaponClass("Tabanca", 1, 2, 25));
                System.out.println("Yeni Silah�n�z: " + this.getPlayer().getInventory().getWeaponClasses().getWeaponName());
            }

        } else if (number > 15 && number < 55) {
            int number2 = (int) (Math.random() * 100);
            System.out.println("Z�rh Kazand�n�z.");
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
            System.out.println(" Para Kazand�n�z.");
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

import java.util.Scanner;

public class ToolStore extends normallocation {

    ToolStore(Players player) {
        super(player, "Ma�azaya Ho� geldiniz.");

    }

    @Override
    public boolean onlocation() {
        System.out.println("Ma�azaya Ho�geldiniz.");

        boolean showMenu = true;

        while (showMenu) {
            System.out.println("1- Silahlar : ");
            System.out.println("2- Z�rhlar : ");
            System.out.println("3- ��k�� : ");
            System.out.println("Se�iminiz : ");
            int selectsecim = input.nextInt();
            while (selectsecim < 1 || selectsecim > 3) {
                System.out.print("Hatal� se�im Yapt�n�z. Tekrar Deneyiniz: ");
                selectsecim = input.nextInt();
            }
            switch (selectsecim) {
                case 1:
                    printweapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmour();
                    buyArmour();
                    break;
                case 3:
                    System.out.println("��k�� yapt�n�z.");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printweapon() {
        System.out.println("--------Silahlar----------");
        for (silahlars�n�f� w : silahlars�n�f�.weapons()) {
            System.out.println(w.getID() + "-" + " Silah �smi: " + w.getWeaponName() + " Para : " + w.getMoney() + " Hasar:" + w.getDamage());
        }
        System.out.println("0- ��k�� Yap.");
    }

    public void buyWeapon() {

        System.out.println("Bir Silah Se�iniz:");
        int selectweapon = input.nextInt();
        while (selectweapon < 0 || silahlars�n�f�.weapons().length > 3) {
            System.out.print("Hatal� se�im Yapt�n�z. Tekrar Deneyiniz: ");
            selectweapon = input.nextInt();
        }

        if (selectweapon != 0) {
            silahlars�n�f� selectedWeapon = silahlars�n�f�.getweapons�d(selectweapon);

            if (selectedWeapon != null) {
                if (selectedWeapon.getMoney() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paran�z yok");
                } else {
                    //Sat�nalman�n ger�ekle�ti�i alan.
                    System.out.println(selectedWeapon.getWeaponName() + " silah�n� sat�n ald�n�z.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getMoney();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paran�z : " + this.getPlayer().getMoney());
                    System.out.println("�nceki silah�n�z :" + this.getPlayer().getInventory().getSilahlars�n�f�().getWeaponName());
                    this.getPlayer().getInventory().setSilahlars�n�f�(selectedWeapon);
                    System.out.println("G�ncel silah�n�z :" + this.getPlayer().getInventory().getSilahlars�n�f�().getWeaponName());
                }
            }
        }
    }

    public void printArmour() {
        for (Armour a : Armour.armoursprintnames()) {
            System.out.println(" Z�rh tipi : " + a.getArmourNAme() + "   Z�rh Kodu : " + a.getId() + "   Blokaj De�eri : " + a.getArmoursblocked() + "  Sat�nal�nmas� i�in paras�: " + a.getArmoursmoney());
        }
        System.out.println("0- ��k�� Yap.");
    }

    public void buyArmour() {
        System.out.println("Bir Z�rh Se�iniz:");
        int selectarmour = input.nextInt();
        while (selectarmour < 0 || selectarmour > Armour.armoursprintnames().length) {
            System.out.println("Hatal� se�im yapt�n�z. Tekrar deneyiniz.");
            selectarmour = input.nextInt();
        }

        Armour selectedArmour = Armour.getArmoursid(selectarmour);
        if (selectarmour != 0) {
            if (selectedArmour != null) {
                if (selectedArmour.getArmoursmoney() > this.getPlayer().getMoney()) {
                    System.out.println("Paran�z yetersiz.");
                } else {
                    System.out.println(selectedArmour.getArmourNAme() + " Z�rh�n� sat�n ald�n�z.");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmour.getArmoursmoney());
                    this.getPlayer().getInventory().setArmours(selectedArmour);
                    System.out.println("Kalan Paran�z: " + this.getPlayer().getMoney());

                }
            }
        }
    }
}
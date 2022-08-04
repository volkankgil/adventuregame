import java.util.Scanner;

public class ToolStore extends normallocation {

    ToolStore(Players player) {
        super(player, "Maðazaya Hoþ geldiniz.");

    }

    @Override
    public boolean onlocation() {
        System.out.println("Maðazaya Hoþgeldiniz.");

        boolean showMenu = true;

        while (showMenu) {
            System.out.println("1- Silahlar : ");
            System.out.println("2- Zýrhlar : ");
            System.out.println("3- Çýkýþ : ");
            System.out.println("Seçiminiz : ");
            int selectsecim = input.nextInt();
            while (selectsecim < 1 || selectsecim > 3) {
                System.out.print("Hatalý seçim Yaptýnýz. Tekrar Deneyiniz: ");
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
                    System.out.println("Çýkýþ yaptýnýz.");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printweapon() {
        System.out.println("--------Silahlar----------");
        for (silahlarsýnýfý w : silahlarsýnýfý.weapons()) {
            System.out.println(w.getID() + "-" + " Silah Ýsmi: " + w.getWeaponName() + " Para : " + w.getMoney() + " Hasar:" + w.getDamage());
        }
        System.out.println("0- Çýkýþ Yap.");
    }

    public void buyWeapon() {

        System.out.println("Bir Silah Seçiniz:");
        int selectweapon = input.nextInt();
        while (selectweapon < 0 || silahlarsýnýfý.weapons().length > 3) {
            System.out.print("Hatalý seçim Yaptýnýz. Tekrar Deneyiniz: ");
            selectweapon = input.nextInt();
        }

        if (selectweapon != 0) {
            silahlarsýnýfý selectedWeapon = silahlarsýnýfý.getweaponsýd(selectweapon);

            if (selectedWeapon != null) {
                if (selectedWeapon.getMoney() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranýz yok");
                } else {
                    //Satýnalmanýn gerçekleþtiði alan.
                    System.out.println(selectedWeapon.getWeaponName() + " silahýný satýn aldýnýz.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getMoney();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paranýz : " + this.getPlayer().getMoney());
                    System.out.println("Önceki silahýnýz :" + this.getPlayer().getInventory().getSilahlarsýnýfý().getWeaponName());
                    this.getPlayer().getInventory().setSilahlarsýnýfý(selectedWeapon);
                    System.out.println("Güncel silahýnýz :" + this.getPlayer().getInventory().getSilahlarsýnýfý().getWeaponName());
                }
            }
        }
    }

    public void printArmour() {
        for (Armour a : Armour.armoursprintnames()) {
            System.out.println(" Zýrh tipi : " + a.getArmourNAme() + "   Zýrh Kodu : " + a.getId() + "   Blokaj Deðeri : " + a.getArmoursblocked() + "  Satýnalýnmasý için parasý: " + a.getArmoursmoney());
        }
        System.out.println("0- Çýkýþ Yap.");
    }

    public void buyArmour() {
        System.out.println("Bir Zýrh Seçiniz:");
        int selectarmour = input.nextInt();
        while (selectarmour < 0 || selectarmour > Armour.armoursprintnames().length) {
            System.out.println("Hatalý seçim yaptýnýz. Tekrar deneyiniz.");
            selectarmour = input.nextInt();
        }

        Armour selectedArmour = Armour.getArmoursid(selectarmour);
        if (selectarmour != 0) {
            if (selectedArmour != null) {
                if (selectedArmour.getArmoursmoney() > this.getPlayer().getMoney()) {
                    System.out.println("Paranýz yetersiz.");
                } else {
                    System.out.println(selectedArmour.getArmourNAme() + " Zýrhýný satýn aldýnýz.");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmour.getArmoursmoney());
                    this.getPlayer().getInventory().setArmours(selectedArmour);
                    System.out.println("Kalan Paranýz: " + this.getPlayer().getMoney());

                }
            }
        }
    }
}
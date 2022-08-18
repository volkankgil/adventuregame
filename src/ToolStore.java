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
        for (weaponClass w : weaponClass.weapons()) {
            System.out.println(w.getWeaponID() + "-" + " Silah Ýsmi: " + w.getWeaponName() + " Para : " + w.getWeaponMoneyforBuying() + " Hasar:" + w.getWeapondamage());
        }
        System.out.println("0- Çýkýþ Yap.");
    }

    public void buyWeapon() {

        System.out.println("Bir Silah Seçiniz:");
        int selectweapon = input.nextInt();
        while (selectweapon < 0 || weaponClass.weapons().length > 3) {
            System.out.print("Hatalý seçim Yaptýnýz. Tekrar Deneyiniz: ");
            selectweapon = input.nextInt();
        }

        if (selectweapon != 0) {
            weaponClass selectedWeapon = weaponClass.callweaponsýd(selectweapon);

            if (selectedWeapon != null) {
                if (selectedWeapon.getWeaponMoneyforBuying() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranýz yok");
                } else {
                    //Satýnalmanýn gerçekleþtiði alan.
                    System.out.println(selectedWeapon.getWeaponName() + " silahýný satýn aldýnýz.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getWeaponMoneyforBuying();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paranýz : " + this.getPlayer().getMoney());
                    System.out.println("Önceki silahýnýz :" + this.getPlayer().getInventory().getWeaponClasses().getWeaponName());
                    this.getPlayer().getInventory().setWeaponClasses(selectedWeapon);
                    System.out.println("Güncel silahýnýz :" + this.getPlayer().getInventory().getWeaponClasses().getWeaponName());
                }
            }
        }
    }

    public void printArmour() {
        for (Armour a : Armour.armours()) {
            System.out.println("   Zýrh Kodu : " + a.getArmourid() + "  Zýrh tipi : " + a.getArmourNAme() +  "   Blokaj Deðeri : " + a.getArmoursblocked() + "  Satýnalýnmasý için parasý: " + a.getArmoursmoney());
        }
        System.out.println("0- Çýkýþ Yap.");
    }

    public void buyArmour() {
        System.out.println("Bir Zýrh Seçiniz:");
        int selectarmour = input.nextInt();
        while (selectarmour < 0 || selectarmour > Armour.armours().length) {
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
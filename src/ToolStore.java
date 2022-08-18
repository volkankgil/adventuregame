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
        for (weaponClass w : weaponClass.weapons()) {
            System.out.println(w.getWeaponID() + "-" + " Silah �smi: " + w.getWeaponName() + " Para : " + w.getWeaponMoneyforBuying() + " Hasar:" + w.getWeapondamage());
        }
        System.out.println("0- ��k�� Yap.");
    }

    public void buyWeapon() {

        System.out.println("Bir Silah Se�iniz:");
        int selectweapon = input.nextInt();
        while (selectweapon < 0 || weaponClass.weapons().length > 3) {
            System.out.print("Hatal� se�im Yapt�n�z. Tekrar Deneyiniz: ");
            selectweapon = input.nextInt();
        }

        if (selectweapon != 0) {
            weaponClass selectedWeapon = weaponClass.callweapons�d(selectweapon);

            if (selectedWeapon != null) {
                if (selectedWeapon.getWeaponMoneyforBuying() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paran�z yok");
                } else {
                    //Sat�nalman�n ger�ekle�ti�i alan.
                    System.out.println(selectedWeapon.getWeaponName() + " silah�n� sat�n ald�n�z.");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getWeaponMoneyforBuying();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan Paran�z : " + this.getPlayer().getMoney());
                    System.out.println("�nceki silah�n�z :" + this.getPlayer().getInventory().getWeaponClasses().getWeaponName());
                    this.getPlayer().getInventory().setWeaponClasses(selectedWeapon);
                    System.out.println("G�ncel silah�n�z :" + this.getPlayer().getInventory().getWeaponClasses().getWeaponName());
                }
            }
        }
    }

    public void printArmour() {
        for (Armour a : Armour.armours()) {
            System.out.println("   Z�rh Kodu : " + a.getArmourid() + "  Z�rh tipi : " + a.getArmourNAme() +  "   Blokaj De�eri : " + a.getArmoursblocked() + "  Sat�nal�nmas� i�in paras�: " + a.getArmoursmoney());
        }
        System.out.println("0- ��k�� Yap.");
    }

    public void buyArmour() {
        System.out.println("Bir Z�rh Se�iniz:");
        int selectarmour = input.nextInt();
        while (selectarmour < 0 || selectarmour > Armour.armours().length) {
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
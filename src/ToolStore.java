public class ToolStore extends normallocation {

    ToolStore(Players player){
        super(player,"Maðazaya Hoþ geldiniz.");

    }

    @Override
    public boolean onlocation() {
        System.out.println("Maðazaya Hoþgeldiniz.");
        System.out.println("1- Silahlar : ");
        System.out.println("2- Zýrhlar : ");
        System.out.println("3- Çýkýþ : ");
        System.out.println("Seçiminiz : ");
        int selectsecim=input.nextInt();
        while (selectsecim<1 || selectsecim>3){
            System.out.print("Hatalý seçim Yaptýnýz. Tekrar Deneyiniz: ");
            selectsecim=input.nextInt();
        }
        switch (selectsecim){
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
                return true;
        }
        return true;
    }

    public void printweapon() {
        System.out.println("--------Silahlar----------");
        for (silahlarsýnýfý w : silahlarsýnýfý.weapons()) {
            System.out.println("Silah Ýsmi: " + w.getWeaponName() + " Para : " + w.getMoney() + " Hasar:" + w.getDamage());
        }
    }
    public void buyWeapon(){

        System.out.println("Bir Silah Seçiniz:");
        int selectweapon = input.nextInt();
        while (selectweapon < 1 || silahlarsýnýfý.weapons().length > 3) {
            System.out.print("Hatalý seçim Yaptýnýz. Tekrar Deneyiniz: ");
            selectweapon = input.nextInt();
        }
        silahlarsýnýfý selectedWeapon=silahlarsýnýfý.getweaponsýd(selectweapon);

        if(selectedWeapon!=null){
            if(selectedWeapon.getMoney()>this.getPlayer().getMoney()){
                System.out.println("Yeterli paranýz yok");
            }else {
                //Satýnalmanýn gerçekleþtiði alan.
                System.out.println(selectedWeapon.getWeaponName()+ " silahýný satýn aldýnýz.");
                int balance=this.getPlayer().getMoney()-selectedWeapon.getMoney();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan Paranýz : "+this.getPlayer().getMoney());
                System.out.println("Önceki silahýnýz :" + this.getPlayer().getInventory().getSilahlarsýnýfý().getWeaponName());
                this.getPlayer().getInventory().setSilahlarsýnýfý(selectedWeapon);
                System.out.println("Güncel silahýnýz :" + this.getPlayer().getInventory().getSilahlarsýnýfý().getWeaponName());
            }
        }
    }

    public void printArmour(){
        for (Armour a :Armour.printnames())
            System.out.println(" Zýrh tipi : " + a.getArmourNAme()+"   Zýrh Kodu : " + a.getId()+ "   Blokaj Deðeri : " + a.getBlocked()+ "  Satýnalýnmasý için parasý: " + a.getMoney());
        }


        public void buyArmour(){
            System.out.println("Bir Zýrh Seçiniz:");
            int selectarmour = input.nextInt();
            System.out.println(this.getPlayer().getInventory().getArmours().getArmourNAme());
        }
    }

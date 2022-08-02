public class ToolStore extends normallocation {

    ToolStore(Players player){
        super(player,"Ma�azaya Ho� geldiniz.");

    }

    @Override
    public boolean onlocation() {
        System.out.println("Ma�azaya Ho�geldiniz.");
        System.out.println("1- Silahlar : ");
        System.out.println("2- Z�rhlar : ");
        System.out.println("3- ��k�� : ");
        System.out.println("Se�iminiz : ");
        int selectsecim=input.nextInt();
        while (selectsecim<1 || selectsecim>3){
            System.out.print("Hatal� se�im Yapt�n�z. Tekrar Deneyiniz: ");
            selectsecim=input.nextInt();
        }
        switch (selectsecim){
            case 1:
                printweapon();
                buyWeapon();
                break;
            case 2:
                printArmour();
                break;
            case 3:
                System.out.println("��k�� yapt�n�z.");
                return true;
        }
        return true;
    }

    public void printweapon() {
        System.out.println("--------Silahlar----------");
        for (silahlars�n�f� w : silahlars�n�f�.weapons()) {
            System.out.println("Silah �smi: " + w.getWeaponName() + " Para : " + w.getMoney() + " Hasar:" + w.getDamage());
        }
    }
    public void buyWeapon(){

        System.out.println("Bir Silah Se�iniz:");
        int selectweapon = input.nextInt();
        while (selectweapon < 1 || silahlars�n�f�.weapons().length > 3) {
            System.out.print("Hatal� se�im Yapt�n�z. Tekrar Deneyiniz: ");
            selectweapon = input.nextInt();
        }
        silahlars�n�f� selectedWeapon=silahlars�n�f�.getweapons�d(selectweapon);

        if(selectedWeapon!=null){
            if(selectedWeapon.getMoney()>this.getPlayer().getMoney()){
                System.out.println("Yeterli paran�z yok");
            }else {
                //Sat�nalman�n ger�ekle�ti�i alan.
                System.out.println(selectedWeapon.getWeaponName()+ " silah�n� sat�n ald�n�z.");
                int balance=this.getPlayer().getMoney()-selectedWeapon.getMoney();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan Paran�z : "+this.getPlayer().getMoney());
                System.out.println("�nceki silah�n�z :" + this.getPlayer().getInventory().getSilahlars�n�f�().getWeaponName());
                this.getPlayer().getInventory().setSilahlars�n�f�(selectedWeapon);
                System.out.println("G�ncel silah�n�z :" + this.getPlayer().getInventory().getSilahlars�n�f�().getWeaponName());
            }
        }
    }
///vevvvvvvvvvvvvvvvvv
    public void printArmour(){
        System.out.println("Z�rhlar");
    }
}

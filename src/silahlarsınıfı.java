public class silahlars�n�f� {

    private String weaponName;
    private int ID;
    private int damage;
    private int money;
    silahlars�n�f�(String weaponName, int ID, int damage, int money){
        this.weaponName=weaponName;
        this.ID=ID;
        this.damage=damage;
        this.money=money;
    }

    public static silahlars�n�f�[] weapons (){

        silahlars�n�f�[] weapons=new silahlars�n�f�[3];

        weapons[0]=new silahlars�n�f�("Tabanca",1,2,5);
        weapons[1]=new silahlars�n�f�("K�l��",2,3,35);
        weapons[2]=new silahlars�n�f�("T�fek",3,7,45);
        return weapons;
    }

    public static silahlars�n�f�  getweapons�d(int ID){
        for (silahlars�n�f� w:silahlars�n�f�.weapons()){
              if(w.getID()==ID){
                  return w;
              }
        }
        return null;
    }

    public String getWeaponName(){
        return weaponName;
    }

    public void setWeaponName(String weaponName){
        this.weaponName=weaponName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

public class silahlarsýnýfý {

    private String weaponName;
    private int ID;
    private int damage;
    private int money;
    silahlarsýnýfý(String weaponName, int ID, int damage, int money){
        this.weaponName=weaponName;
        this.ID=ID;
        this.damage=damage;
        this.money=money;
    }

    public static silahlarsýnýfý[] weapons (){

        silahlarsýnýfý[] weapons=new silahlarsýnýfý[3];

        weapons[0]=new silahlarsýnýfý("Tabanca",1,2,5);
        weapons[1]=new silahlarsýnýfý("Kýlýç",2,3,35);
        weapons[2]=new silahlarsýnýfý("Tüfek",3,7,45);
        return weapons;
    }

    public static silahlarsýnýfý  getweaponsýd(int ID){
        for (silahlarsýnýfý w:silahlarsýnýfý.weapons()){
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

public class weaponClass {

    private String weaponName;
    private int weaponID;
    private int weapondamage;
    private int weaponMoneyforBuying;
    weaponClass(String weaponName, int weaponID, int weapondamage, int weaponMoneyforBuying){
        this.weaponName=weaponName;
        this.weaponID = weaponID;
        this.weapondamage = weapondamage;
        this.weaponMoneyforBuying = weaponMoneyforBuying;
    }

    public static weaponClass[] weapons (){

        weaponClass[] weapons=new weaponClass[3];

        weapons[0]=new weaponClass("Tabanca",1,2,5);
        weapons[1]=new weaponClass("Kýlýç",2,3,35);
        weapons[2]=new weaponClass("Tüfek",3,7,45);
        return weapons;
    }

    public static weaponClass callweaponsýd(int ID){
        for (weaponClass w: weaponClass.weapons()){
              if(w.getWeaponID()==ID){
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

    public int getWeaponID() {
        return weaponID;
    }

    public void setWeaponID(int weaponID) {
        this.weaponID = weaponID;
    }

    public int getWeapondamage() {
        return weapondamage;
    }

    public void setWeapondamage(int weapondamage) {
        this.weapondamage = weapondamage;
    }

    public int getWeaponMoneyforBuying() {
        return weaponMoneyforBuying;
    }

    public void setWeaponMoneyforBuying(int weaponMoneyforBuying) {
        this.weaponMoneyforBuying = weaponMoneyforBuying;
    }
}

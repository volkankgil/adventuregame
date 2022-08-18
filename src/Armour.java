public class Armour {

    private int armourid;
    private String armourNAme;
    private int armoursblocked;
    private int armoursmoney;

    public Armour(int armourid, String armourNAme,  int armoursblocked, int money){
        this.armourid = armourid;
        this.armourNAme=armourNAme;
        this.armoursblocked = armoursblocked;
        this.armoursmoney =money;
    }

    public static Armour[] armours(){
        Armour armoursname[]=new Armour[3];
        armoursname[0]=new Armour(1, "Hafif", 1,15);
        armoursname[1]=new Armour(2, "Orta", 3,25);
        armoursname[2]=new Armour(3, "Aðýr", 5,40);
        return armoursname;
    }

    public static Armour getArmoursid(int id) {
        for (Armour a : Armour.armours()) {
            if (a.getArmourid() == id) {
                return a;
            }
        }
        return null;
    }

    public String getArmourNAme(){
        return armourNAme;
    }

    public void setArmourNAme(String armourNAme){
        this.armourNAme=armourNAme;
    }

    public int getArmourid() {
        return armourid;
    }

    public void setArmourid(int armourid) {
        this.armourid = armourid;
    }

    public int getArmoursblocked(){
        return armoursblocked;
    }

    public void setArmoursblocked(int armoursblocked){
        this.armoursblocked = armoursblocked;
    }

    public int getArmoursmoney() {
        return armoursmoney;
    }

    public void setArmoursmoney(int armoursmoney) {
        this.armoursmoney = armoursmoney;
    }
}

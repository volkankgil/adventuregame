public class Armour {

    private String armourNAme;
    private int id;
    private int armoursblocked;
    private int armoursmoney;

    public Armour(String armourNAme, int id, int armoursblocked, int money){
        this.armourNAme=armourNAme;
        this.id=id;
        this.armoursblocked = armoursblocked;
        this.armoursmoney =money;
    }

    public static Armour[] armoursprintnames(){
        Armour armoursname[]=new Armour[3];
        armoursname[0]=new Armour("Hafif",1,1,15);
        armoursname[1]=new Armour("Orta",2,3,25);
        armoursname[2]=new Armour("Aðýr",3,5,40);
        return armoursname;
    }

    public static Armour getArmoursid(int id) {
        for (Armour a : Armour.armoursprintnames()) {
            if (a.getId() == id) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

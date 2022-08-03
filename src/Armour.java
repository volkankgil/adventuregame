public class Armour {

    private String armourNAme;
    private int id;
    private int blocked;
    private int money;

    public Armour(String armourNAme,int id,int blocked,int money){
        this.armourNAme=armourNAme;
        this.id=id;
        this.blocked=blocked;
        this.money=money;
    }

    public static Armour[] printnames(){
        Armour armoursname[]=new Armour[3];
        armoursname[0]=new Armour("Hafif",1,1,15);
        armoursname[1]=new Armour("Orta",2,3,25);
        armoursname[2]=new Armour("Aðýr",3,5,40);
        return armoursname;
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

    public int getBlocked(){
        return blocked;
    }

    public void setBlocked(int blocked){
        this.blocked=blocked;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}

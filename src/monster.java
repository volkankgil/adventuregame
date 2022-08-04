public class monster {

    private String monsterName;
    private int monsterid;
    private int monsterdamage;
    private int monsterHealth;

    monster(String monsterName,int monsterid,int monsterdamage,int monsterHealth){
        this.monsterName=monsterName;
        this.monsterid=monsterid;
        this.monsterdamage=monsterdamage;
        this.monsterHealth=monsterHealth;
    }

    public String getMonsterName(){
        return monsterName;
    }

    public void setMonsterName(String monsterName){
        this.monsterName=monsterName;
    }

    public int getMonsterid() {
        return monsterid;
    }

    public void setMonsterid(int monsterid) {
        this.monsterid = monsterid;
    }

    public int getMonsterdamage() {
        return monsterdamage;
    }

    public void setMonsterdamage(int monsterdamage) {
        this.monsterdamage = monsterdamage;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(int monsterHealth) {
        this.monsterHealth = monsterHealth;
    }
}

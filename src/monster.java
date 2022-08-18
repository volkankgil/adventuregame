import java.util.Random;

public class monster {

    private String monsterName;
    private int monsterid;
    private int monsterdamage;
    private int monsterHealth;
    private int award;
    private int orjinalHealth;




    monster(String monsterName, int monsterid, int monsterdamage,int monsterHealth, int award){
        this.monsterName=monsterName;
        this.monsterid=monsterid;
        this.monsterdamage=monsterdamage;
        this.monsterHealth=monsterHealth;
        this.award=award;
        this.orjinalHealth=monsterHealth;
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
        if(monsterHealth<0){
            monsterHealth=0;
        }
        this.monsterHealth = monsterHealth;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getOrjinalHealth(){
        return orjinalHealth;
    }
    public void setOrjinalHealth(int orjinalHealth){
        this.orjinalHealth=orjinalHealth;
    }
}

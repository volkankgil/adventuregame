public abstract class character { // abstract oluþturduðumuz için bu sýnýftan nesne üretilmez.

    private int characterId;
    private String charactername;
    private int charcaterDamage;
    private int characterHealth;
    private int charactermoney;

    public character(int characterId, String charactername, int charcaterDamage, int characterHealth, int charactermoney){
        this.characterId = characterId;
        this.charactername = charactername;
        this.charcaterDamage = charcaterDamage;
        this.characterHealth = characterHealth;
        this.charactermoney = charactermoney;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public String getCharactername(){
        return charactername;
    }

    public void setCharactername(String charactername){
        this.charactername = charactername;
    }
    public int getCharcaterDamage() {
        return charcaterDamage;
    }

    public void setCharcaterDamage(int charcaterDamage) {
        this.charcaterDamage = charcaterDamage;
    }

    public int getCharacterHealth() {
        return characterHealth;
    }

    public void setCharacterHealth(int characterHealth) {
        this.characterHealth = characterHealth;
    }

    public int getCharactermoney(){
        return charactermoney;
    }

    public void setCharactermoney(int charactermoney){
        this.charactermoney = charactermoney;
    }
}

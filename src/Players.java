import java.util.Scanner;

public class Players {
    private inventory inventory;
    private int damage;
    private int healty;

    private int orjinalHealth;
    private int money;
    private String PlayerName;
    private String charName;
    private Scanner input = new Scanner(System.in);

    public Players(String playerName) {
        this.PlayerName = playerName;
        this.inventory= new inventory();
    }

    public void selectChar() {

        character charlist[] = {new samuray(), new Archer(), new sovalye()};

        for (character character : charlist) {
            System.out.println("\t\tID: " + character.getCharacterId() +
                    "\t\t Karakter: " + character.getCharactername() +
                    "\t\t Hasar :  " + character.getCharcaterDamage() +
                    "\t\t Saðlýk : " + character.getCharacterHealth() +
                    "\t\t Para :   " + character.getCharactermoney());
        }

        System.out.println("-----------");

        System.out.println("Lütfen Bir Karakter Giriniz : ");
        int selectchar = input.nextInt();

            while (true) {
                if (selectchar > 0 && selectchar < 4) {
                    switch (selectchar) {
                        case 1:
                            initPlayer(new samuray());
                            break;
                        case 2:
                            initPlayer(new Archer());
                            break;
                        case 3:
                            initPlayer(new sovalye());
                            break;
                    }
                    break;
                } else {
                    System.out.print("Yanlýþ seçim tekrar giriniz: ");
                    selectchar = input.nextInt();
                }
            }
        }

    public void initPlayer(character character){
        this.setDamage(character.getCharcaterDamage());
        this.setHealty(character.getCharacterHealth());
        this.setOrjinalHealth(character.getCharacterHealth());
        this.setMoney(character.getCharactermoney());
        this.setCharName(character.getCharactername());
    }

    public void printPlayerinfo(){
        System.out.println("Karakter: " +this.getCharName() +
                "\tZýrhýnýz :" + this.getInventory().getArmours().getArmourNAme()+
                "\tBloklama :" + this.getInventory().getArmours().getArmoursblocked()+
                "\tSilahýnýz: " + this.getInventory().getWeaponClasses().getWeaponName()+
                "\tHasar: " +this.getTotaldamage()+
                "\tSaðlýk: "+getHealty()+
                "\tPara: "+getMoney()+
                "\tÖdüller: " );
    }

    public int getTotaldamage(){
        return damage+this.getInventory().getWeaponClasses().getWeapondamage();
    }
    public int getDamage(){
        return  damage;
    }
    public void setDamage(int damage){
        this.damage=damage;
    }

    public int getHealty(){
        return healty;
    }

    public void setHealty(int healty){
        if(healty<0){
            healty=0;
        }
        this.healty=healty;
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int money){
        this.money=money;
    }

    public String getPlayerName(){
        return PlayerName;
    }

    public void setPlayerName(String playerName){
        this.PlayerName=playerName;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }
    public inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }
    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}


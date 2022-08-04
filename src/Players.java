import java.util.Scanner;

public class Players {
    private inventory inventory;
    private int damage;
    private int healty;
    private int money;
    private String PlayerName;
    private String charName;

    private Scanner input = new Scanner(System.in);

    public Players(String playerName) {
        this.PlayerName = playerName;
        this.inventory= new inventory();
    }

    public void selectChar() {

        karakterler charlist[] = {new samuray(), new okcu(), new sovalye()};

        for (karakterler karakterler : charlist) {
            System.out.println("\t\tID: " + karakterler.getId() +
                    "\t\tKarakter: " + karakterler.getName() +
                    "\t\t Hasar :  " + karakterler.getDamage() +
                    "\t\t Saðlýk : " + karakterler.getHealth() +
                    "\t\t Para :   " + karakterler.getMoney());
        }

        System.out.println("-----------");
        System.out.println("Lütfen Bir Karakter Giriniz : ");
        int selectchar = input.nextInt();
        switch (selectchar) {
            case 1:
                initPlayer(new samuray());
                break;
            case 2:
                initPlayer(new okcu());
                break;
            case 3:
                initPlayer(new sovalye());
                break;
            default:
                initPlayer(new samuray());
        }
    }
    public void initPlayer(karakterler karakterler){
        this.setDamage(karakterler.getDamage());
        this.setHealty(karakterler.getHealth());
        this.setMoney(karakterler.getMoney());
        this.setCharName(karakterler.getName());
    }

    public void printPlayerinfo(){
        System.out.println("Karakter: " +this.getCharName() +
                "\tZýrhýnýz :" + this.getInventory().getArmours().getArmourNAme()+
                "\tBloklama :" + this.getInventory().getArmours().getArmoursblocked()+
                "\tSilahýnýz: " + this.getInventory().getSilahlarsýnýfý().getWeaponName()+
                "\tHasar: " +this.getDamage()+
                "\tSaðlýk: "+getHealty()+
                "\tPara:"+getMoney());
    }

    public int getDamage(){
        return  damage+this.getInventory().getSilahlarsýnýfý().getDamage();
    }

    public void setDamage(int damage){
        this.damage=damage;
    }

    public int getHealty(){
        return healty;
    }

    public void setHealty(int healty){
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
}

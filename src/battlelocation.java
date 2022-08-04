import java.util.Random;

public abstract class battlelocation extends location{

    monster monster1; // battlelocation 'ýn kendine ait bir monster'ý olmasý için monster deðiþkenin den ürettik.
    private String award;

    private int maxmonster;

    public battlelocation(Players player, String locationname,monster monster1,String award,int maxmonster){
        super(player,locationname);
        this.award =award;
        this.monster1=monster1;
        this.maxmonster=maxmonster;
    }
    @Override
    public boolean onlocation(){
        int monsterNumber=randomMonsternumber();
        System.out.println("Þu an buradasýnýz." + this.getLocationname());
        System.out.println("Dikkatli ol Burada " + monsterNumber + " adet " + this.getMonster1().getMonsterName() + " yaþýyor.");
        System.out.println("<S>avas yada <Kac>");
        String selectcase=input.nextLine();
        selectcase=selectcase.toUpperCase();//Eðer s'yi küçük harfle girmiþ ise büyütüyor.
        if(selectcase.equals("S")){
            System.out.println("savaþ iþlemleri olcaktýr.");
            //Savaþ iþlemleri
        }
        return true;
    }

    public int randomMonsternumber(){
        Random r=new Random();
        return r.nextInt(this.getMaxmonster())+1; // +1 yaptýk çünkü bu fonksiyonda bounda deðeri 0 ve 2 areasýnda sayý üretiyor.
    }

    public monster getMonster1(){
        return monster1;
    }

    public void setMonster1(monster monster1) {
        this.monster1 = monster1;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxmonster(){
        return maxmonster;
    }

    public void setMaxmonster(){
        this.maxmonster=maxmonster;
    }

}

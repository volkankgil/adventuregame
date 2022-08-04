import java.util.Random;

public abstract class battlelocation extends location{

    monster monster1; // battlelocation '�n kendine ait bir monster'� olmas� i�in monster de�i�kenin den �rettik.
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
        System.out.println("�u an buradas�n�z." + this.getLocationname());
        System.out.println("Dikkatli ol Burada " + monsterNumber + " adet " + this.getMonster1().getMonsterName() + " ya��yor.");
        System.out.println("<S>avas yada <Kac>");
        String selectcase=input.nextLine();
        selectcase=selectcase.toUpperCase();//E�er s'yi k���k harfle girmi� ise b�y�t�yor.
        if(selectcase.equals("S")){
            System.out.println("sava� i�lemleri olcakt�r.");
            //Sava� i�lemleri
        }
        return true;
    }

    public int randomMonsternumber(){
        Random r=new Random();
        return r.nextInt(this.getMaxmonster())+1; // +1 yapt�k ��nk� bu fonksiyonda bounda de�eri 0 ve 2 areas�nda say� �retiyor.
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

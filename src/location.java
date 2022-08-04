import java.util.Scanner;

public abstract class location {

    protected Scanner input =new Scanner(System.in);  //alt s�n�flar�n eri�mesi i�in protected tan�mlad�k.
    private Players player;
    private String locationname;

    location(Players player, String locationname){
        this.player=player;
        this.locationname =locationname;
    }

    public Players getPlayer() {
        return player;
    }

    public void setPlayer(Players player) {
        this.player = player;
    }

    public String getLocationname() {
        return locationname;
    }

    public void setLocationname(String locationname) {
        this.locationname = locationname;
    }
    public abstract boolean onlocation(); // location s�n�f�ndan kal�t�m alan b�t�n alt s�n�flar�n bu metodu yazmas� i�in abstract yazd�k.
}

import java.util.Scanner;

public abstract class location {

    protected Scanner input =new Scanner(System.in);  //alt sýnýflarýn eriþmesi için protected tanýmladýk.
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



    public abstract boolean onlocation(); // location sýnýfýndan kalýtým alan bütün alt sýnýflarýn bu metodu yazmasý için abstract yazdýk.
}

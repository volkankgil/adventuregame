public class SafeHouse extends normallocation{

    SafeHouse(Players player){
        super(player,"G�venli Ev");
    }

    @Override
    public boolean onlocation() {
        System.out.println("G�venli Evdesiniz.");
        System.out.println("Can�n�z Yenilendi.");
        this.getPlayer().setHealty(this.getPlayer().getOrjinalHealth());
        return true;
    }
}

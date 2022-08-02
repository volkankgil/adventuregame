public class SafeHouse extends normallocation{

    SafeHouse(Players player){
        super(player,"Güvenli Ev");
    }

    @Override
    public boolean onlocation() {
        System.out.println("Güvenli Evdesiniz.");
        System.out.println("Canýnýz Yenilendi.");
        return true;
    }
}

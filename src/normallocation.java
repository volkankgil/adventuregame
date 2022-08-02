public class normallocation extends location{

    normallocation(Players player,String locationname){
        super(player,locationname);
    }

    @Override
    public boolean onlocation() {
        return true;
    }
}

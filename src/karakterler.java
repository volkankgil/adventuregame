public abstract class karakterler { // abstract oluþturduðumuz için bu sýnýftan nesne üretilmez.

    private int Id;
    private String name;
    private int Damage;
    private int Health;
    private int money;

    public karakterler(int Id, String name, int Damage, int Health, int money){
        this.Id=Id;
        this.name=name;
        this.Damage=Damage;
        this.Health=Health;
        this.money=money;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }
    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int money){
        this.money=money;
    }
}

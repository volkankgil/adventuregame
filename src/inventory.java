public class inventory {

   private silahlars�n�f� silahlars�n�f�;
   private Armour armours;

   public inventory(){
      this.silahlars�n�f�= new silahlars�n�f�("Yumruk",0,0,0);
      this.armours=new Armour("Z�rh Yok",0,0,0);
   }

   public silahlars�n�f� getSilahlars�n�f�() {
      return silahlars�n�f�;
   }

   public void setSilahlars�n�f�(silahlars�n�f� silahlars�n�f�){
      this.silahlars�n�f� = silahlars�n�f�;
   }

   public Armour getArmours() {
      return armours;
   }

   public void setArmours(Armour armours) {
      this.armours = armours;
   }
}



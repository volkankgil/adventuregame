public class inventory {

   private silahlarsýnýfý silahlarsýnýfý;
   private Armour armours;

   public inventory(){
      this.silahlarsýnýfý= new silahlarsýnýfý("Yumruk",-1,0,0);
      this.armours=new Armour("Zýrh Yok",-1,0,0);
   }

   public silahlarsýnýfý getSilahlarsýnýfý() {
      return silahlarsýnýfý;
   }

   public void setSilahlarsýnýfý(silahlarsýnýfý silahlarsýnýfý){
      this.silahlarsýnýfý = silahlarsýnýfý;
   }

   public Armour getArmours() {
      return armours;
   }

   public void setArmours(Armour armours) {
      this.armours = armours;
   }
}



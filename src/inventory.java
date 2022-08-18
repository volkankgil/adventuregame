import java.util.ArrayList;

public class inventory {

   private weaponClass weaponClasses;
   private Armour armours;

   public battlelocation getA() {
      return a;
   }

   public void setA(battlelocation a) {
      this.a = a;
   }

   private battlelocation a;

   public inventory(){
      this.weaponClasses = new weaponClass("Yumruk",-1,0,0);
      this.armours=new Armour(-1, "Zýrh Yok", 0,0);
   }

   public weaponClass getWeaponClasses() {
      return weaponClasses;
   }

   public void setWeaponClasses(weaponClass weaponClass){
      this.weaponClasses = weaponClass;
   }

   public Armour getArmours() {
      return armours;
   }
   public void setArmours(Armour armours) {
      this.armours = armours;
   }

}



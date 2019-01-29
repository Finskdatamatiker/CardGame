/**
@author Päivi Eversbusch
@version 1.0
@since 29.1.2019
*/
public class KoererSystem
{
   /**
   * Privat konstruktør skal forhindre, at man kan komme til at lave
   * instanser i andre klasser. Og man kan kun lave én instans ad gangen.
   */
   private KoererSystem()
   {
    
   }
   public static void main(String[] args)
   {

    KortSystem kortSystem = new KortSystem();
    kortSystem.koerKort();
   
   }

}
/**
@author P�ivi Eversbusch
@version 1.0
@since 29.1.2019
*/
public class KoererSystem
{
   /**
   * Privat konstrukt�r skal forhindre, at man kan komme til at lave
   * instanser i andre klasser. Og man kan kun lave �n instans ad gangen.
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
/**
*@author Päivi Eversbusch
*@version 1.0
*@since 29.1.2019
*/
import java.util.Arrays;
public class EtSaetKort
{
   /**
   * Denne klasses ansvar er at lave et sæt kort og give det værdier
   * så vi laver et array af kort her med 52 elementer
   * EtSaetKort har dermed kort som attribut 
   * 
   */
   int antal = 52;
   private Kort kort;
   Kort[] saet = new Kort[antal];
   
   public EtSaetKort()
   {
   /**
   * I konstruktoeren faar kortene vaerdier
   * Vaerdierne gives kuloer ad gangen i for-loops
   */

      String sparNavn = "SPAR";
      Kuloer spar = Kuloer.valueOf(sparNavn);
   
      String hjerteNavn = "HJERTE";
      Kuloer hjerte = Kuloer.valueOf(hjerteNavn);
   
      String rudeNavn = "RUDE";
      Kuloer rude = Kuloer.valueOf(rudeNavn);
   
      String kloerNavn = "KLOER";
      Kuloer kloer = Kuloer.valueOf(kloerNavn);
   
      int slut1 = antal / 4;
      int slut2 = antal / 2;
      int slut3 = antal / 4 * 3;
      int slut4 = saet.length;
      
      //13 spar
      for(int i = 0; i < slut1; i++)
      {
         saet[i] = new Kort(spar, i+1);
      }
      //13 hjerte
      for(int i = slut1; i < slut2; i++)
      {
         saet[i] = new Kort(hjerte, i-(slut1-1));
      }
      //13 rude
      for(int i = slut2; i < slut3; i++)
      {
         saet[i] = new Kort(rude, i-(slut2-1));
      }
      //13 kloer
      for(int i = slut3; i < slut4; i++)
      {
         saet[i] = new Kort(kloer, i-(slut3-1));
      }
    }
  
    public Kort getKort(int index)
    {
    /**
    * Metoden returnerer et bestemt kort i saettet
    * @param index til array af kort (index mellem 0 og 51)
    */
      return this.saet[index];
    }
    
    public int getAntal()
    {
      return this.antal;
    }
    
    public Kort getKort()
    {
      return this.kort;
    }
    
    public Kort[] getSaet()
    {
    /**
    * Metoden returnerer hele saettet
    */
      return this.saet;
    }
    
    public String toString()
    {
      return Arrays.toString(saet);
    }
    
    public boolean equals(EtSaetKort saet)
    {
      if(this.saet.equals(saet.getSaet()))
      {
         return true;
      }
      else
      {
         return false;
      }
    } 
}


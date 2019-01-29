/**
@author Päivi Eversbusch
@version 1.0
@since 29.1.2019
*/
public class SaetGenerator
{
   /**
   * Denne klasse har ansvar for at blande kortene og her ville man 
   * kunne tilføje andre metoder, som man kunne bruge til at behandle
   * et sæt kort med. 
   * Der er tale om en composition mellem EtSaetKort og SaetGenerator,
   * fordi det ikke rigtig giver mening at lave et sæt kort, hvis man 
   * ikke behandler dem på nogen måde. Så kunne man lige så godt bare
   * beholde kortene for sig.Så hvis SaetGenerator forsvinder, forsvinder
   * også EtSaetKort. 
   * I konstruktøren laver vi en instans af EtSaetKort
   */
   private EtSaetKort mitSaet;
   
   public SaetGenerator()
   {
      this.mitSaet = new EtSaetKort();
   }

   public EtSaetKort getSaet()
   {
      return this.mitSaet;
   }
   
   public EtSaetKort blandKort1(EtSaetKort mitSaet)
   {
     /**
     * Metoden bytter den ene halvdel af kortene med den anden halvdel
     * @param mitSaet af datatypen EtSaetKort
     */
      int laengde = mitSaet.getAntal();
      Kort temp;

      for(int i = 0; i < laengde/2; i++)
      {
         temp = mitSaet.getSaet()[i];
         mitSaet.getSaet()[i] = mitSaet.getSaet()[(laengde/2)+i];
         mitSaet.getSaet()[(laengde/2)+i] = temp;
      }   
      return mitSaet;
   }
   
   public EtSaetKort blandKort2(EtSaetKort mitSaet)
   {
     /**
     * Metoden bytter hvert andet kort med kortet i det næste index
     * @param mitSaet af datatypen EtSaetKort
     */
      int laengde = mitSaet.getSaet().length;
      Kort temp;

      for(int i = 0; i < laengde; i = i+2)
      {
         temp = mitSaet.getSaet()[i];
         mitSaet.getSaet()[i] = mitSaet.getSaet()[i+1];
         mitSaet.getSaet()[i+1] = temp;
      }   
      return mitSaet;
   }
   
   public EtSaetKort blandKort3(EtSaetKort mitSaet)
   {
     /**
     * Metoden bytter hvert kort med et kort i et tilfældigt index
     * @param mitSaet af datatypen EtSaetKort
     */  
      int laengde = mitSaet.getSaet().length;
      Kort temp;
      int randIndex;

      for(int i = 0; i < laengde; i++)
      {
         randIndex = (int)(Math.random()*(laengde-1)) + 0;
         temp = mitSaet.getSaet()[i];
         mitSaet.getSaet()[i] = mitSaet.getSaet()[randIndex];
         mitSaet.getSaet()[randIndex] = temp;
      }   
      return mitSaet;
   }

   public EtSaetKort blandKort4(EtSaetKort mitSaet)
   {
   /**
   * Metoden bytter hvert fjerde kort i den ene halvdel med et kort 
   * med tilsvarende placering i den anden halvdel
   * @param mitSaet af datatypen EtSaetKort
   */
      int laengde = mitSaet.getSaet().length;
      Kort temp;

      for(int i = 0; i < laengde/2; i = i +3)
      {
         temp = mitSaet.getSaet()[i];
         mitSaet.getSaet()[i] = mitSaet.getSaet()[(laengde/2)+i];
         mitSaet.getSaet()[(laengde/2)+i] = temp;
      }   
      return mitSaet;
   }
   
   public EtSaetKort blandKort(EtSaetKort mitSaet)
   {
   /**
   * Metoden samler alle fire måder at blande kortene på.
   * Random tal bestemmer, hvor mange gange kortene
   * bliver blandet med de fire metoder. 
   * Denne metode kaldes på i klassen KortSystem
   * @param mitSaet af datatypen EtSaetKort
   */
     int omgange = (int)(Math.random()*100) + 30;
     for (int i = 20; i < omgange; i++)
     {
         blandKort1(mitSaet);
         blandKort2(mitSaet);
         blandKort3(mitSaet);
         blandKort4(mitSaet);
      }
      return mitSaet;
   } 
}

/**
@author Päivi Eversbusch
@version 1.0
@since 29.1.2019
*/
public class Kort
{
   /**
   * Kort har to attributter: vaerdi og kuloer
   */
   private int vaerdi;
   private Kuloer kuloer;
   
   public Kort (Kuloer kuloer, int vaerdi)
   {
      this.kuloer = kuloer;
      this.vaerdi = vaerdi;
   }
   
   public void setVaerdi (int vaerdi)
   {
      this.vaerdi = vaerdi;
   }

   public int getVaerdi()
   {
      return this.vaerdi;
   }
 
   public void setKuloer (Kuloer kuloer)
   {
      this.kuloer = kuloer;
   }

   public Kuloer getKuloer()
   {
      return this.kuloer;
   } 
   
   public boolean equals(Object o)
   {
   /**
   * Vi kan sammenligne med hvilket som helst objekt. 
   * Hvis det er et kort og kuloer og vaerdi er den samme, returnerer vi true
   */
   
      if (o instanceof Kort)
      {
         Kort other = (Kort) o;
         return this.vaerdi == other.getVaerdi() 
         && this.kuloer.equals(other.getKuloer());
      }
      else
      {
         return false;
      }
   }
   
   public String toString()
   {
      if(this.vaerdi == 1)
      {
         return this.kuloer + " es";
      }  
      if(this.vaerdi == 11)
      {
         return this.kuloer + " knaegt";
      }
      if(this.vaerdi == 12)
      {
         return this.kuloer + " dame";
      }
      if(this.vaerdi == 13)
      {
         return this.kuloer + " kong";
      }      
     return this.kuloer + " " + this.vaerdi;
   }
}




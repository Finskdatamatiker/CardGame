/**
@author Päivi Eversbusch
@version 1.0
@since 29.1.2019
*/

import java.util.Scanner;
public class KortSystem
{
 /**
 * Denne klasse laver en instans af SaetGenerator og har ansvar for at 
 * udføre handlinger, som vises i en menu
 */
      private Scanner console;
      SaetGenerator saetGenerator = new SaetGenerator(); 
      
      public KortSystem()
      {
      /**
      * I konstruktøren laver vi en instans af Scanner og kalder på 
      * metoden, som koerer progammet
      */
          console = new Scanner(System.in);
          koerKort();
      }
      
      public void koerKort()
      {
         boolean koerProgram = true;
         
         while(koerProgram)
         {
         /**
         * Valget laeses med int
         * String dummy laeser enter, men trykker på efter indtastningen.
         */
            System.out.println(visMenu());
            while(!console.hasNextInt())
            {
                 String dummie = console.nextLine();
                 System.out.println("Skriv et heltal.");
            }
            int valg = console.nextInt();
            
            if (valg == 0)
            {
                System.out.println("Afslutter programmet");
                koerProgram = false;
            } 
              
            else if (valg == 1)
            {
            /**
            * Først henter vi et sæt kort og derefter blander vi dem.
            */
               System.out.println("\nSæt før vi blander\n");
               for(int i = 0; i < 52; i++)
               {
                  System.out.println(saetGenerator.getSaet().getKort(i));
               }
               
               saetGenerator.blandKort(saetGenerator.getSaet());
               
               System.out.println("\nSæt efter at vi har blandet\n");
               for(int i = 0; i < saetGenerator.getSaet().getAntal(); i++)
               {
                  System.out.println(saetGenerator.getSaet().getKort(i));
               }
               System.out.println();
               
             }
      
             else if (valg == 0)
             {
             /**
             * Først trækker vi det øverste kort, så blander vi og  
             * trækker et nyt kort.
             */
                System.out.println("det øverste kort før:   " + saetGenerator.getSaet().getKort(0));
                saetGenerator.blandKort(saetGenerator.getSaet());
                System.out.println("det øverste kort efter: " + saetGenerator.getSaet().getKort(0));
             }   
             else if (valg == 3)
             {
             /**
             * Brugeren kan bestemme, hvor mange kort vi trækker fra 
             * sættet og så fortæller vi, hvor mange der er tilbage. 
             * Kortenes værdier har ikke nogen betydning, så vi 
             * blander dem ikke.
             * Hvis man indtaster et bogstav eller et tal, som ikke
             * er mellem 0 og 52, bliver man bedt om at vælge et tal
             * mellem 0 og 52.
             */
               System.out.println("Hvor mange kort vil du trække?");
               
               while(!console.hasNextInt())
               {
               console.nextLine();
               System.out.println("Skriv et heltal.");
               }
               
               boolean runWhile = true;
               while (runWhile)
               {
                  int antal = console.nextInt();
                
                  if(antal < 0 || antal > 52)
                  {
                     System.out.println("Vælg et tal mellem 0 og 52");
                      while(!console.hasNextInt())
                     {
                        console.nextLine();
                        System.out.println("Skriv et tal.");
                      }
                     
                     runWhile = true;
                  }
                  else
                  {
                     int taeller = 0;
                     for(int i = antal; i < saetGenerator.getSaet().getAntal(); i++)
                     {
                        taeller++;
                     }

                     System.out.println("Der er " + taeller + " kort tilbage.\n");
                  
                     runWhile = false;
                  }
                 }
               } 
               else
               {
                System.out.println("Vælg et af menupunkterne.\n");
              }
            }        
         }
         
         public String visMenu()
         {
            String menu = "Velkommen!\n";
            menu += "Hvad vil du foretage dig?\n";
            menu += "1: Bland et sæt kort.\n";
            menu += "2: Bland et sæt kort og træk det øverste kort.\n";
            menu += "3: Træk et antal kort og se, hvor mange der er tilbage.\n";
            menu += "0: Afslut programmet og du får et nyt sæt kort.\n";
            return menu;                     
         }
   }
   


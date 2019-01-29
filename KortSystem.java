/**
@author P�ivi Eversbusch
@version 1.0
@since 29.1.2019
*/

import java.util.Scanner;
public class KortSystem
{
 /**
 * Denne klasse laver en instans af SaetGenerator og har ansvar for at 
 * udf�re handlinger, som vises i en menu
 */
      private Scanner console;
      SaetGenerator saetGenerator = new SaetGenerator(); 
      
      public KortSystem()
      {
      /**
      * I konstrukt�ren laver vi en instans af Scanner og kalder p� 
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
         * Valget laeses med charAt(), fordi der er ikke flere end
         * fire valgmuligheder. Var der felre end 9, skulle man justere
         * metoden, fordi charAt(0) l�ser kun �t tegn. 
         * String dummy laeser enter, men trykker p� efter indtastningen.
         */
            System.out.println(visMenu());
            char valg = console.next().charAt(0);
            String dummy = console.nextLine(); 
            
            if (valg == '0')
            {
                System.out.println("Afslutter programmet");
                koerProgram = false;
            } 
              
            else if (valg == '1')
            {
            /**
            * F�rst henter vi et s�t kort og derefter blander vi dem.
            */
               System.out.println("\nS�t f�r vi blander\n");
               for(int i = 0; i < 52; i++)
               {
                  System.out.println(saetGenerator.getSaet().getKort(i));
               }
               
               saetGenerator.blandKort(saetGenerator.getSaet());
               
               System.out.println("\nS�t efter at vi har blandet\n");
               for(int i = 0; i < saetGenerator.getSaet().getAntal(); i++)
               {
                  System.out.println(saetGenerator.getSaet().getKort(i));
               }
               System.out.println();
               
             }
      
             else if (valg == '2')
             {
             /**
             * F�rst tr�kker vi det �verste kort, s� blander vi og  
             * tr�kker et nyt kort.
             */
                System.out.println("det �verste kort f�r:   " + saetGenerator.getSaet().getKort(0));
                saetGenerator.blandKort(saetGenerator.getSaet());
                System.out.println("det �verste kort efter: " + saetGenerator.getSaet().getKort(0));
             }   
             else if (valg == '3')
             {
             /**
             * Brugeren kan bestemme, hvor mange kort vi tr�kker fra 
             * s�ttet og s� fort�ller vi, hvor mange der er tilbage. 
             * Kortenes v�rdier har ikke nogen betydning, s� vi 
             * blander dem ikke.
             * Hvis man indtaster et bogstav eller et tal, som ikke
             * er mellem 0 og 52, bliver man bedt om at v�lge et tal
             * mellem 0 og 52.
             */
               System.out.println("Hvor mange kort vil du tr�kke?");
               
               while(!console.hasNextInt())
               {
               console.nextLine();
               System.out.println("Skriv et tal.");
               }
               
               boolean runWhile = true;
               while (runWhile)
               {
                  int antal = console.nextInt();
                  String enter = console.nextLine(); 
                
                  if(antal < 0 || antal > 52)
                  {
                     System.out.println("V�lg et tal mellem 0 og 52");
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
                System.out.println("V�lg et af menupunkterne.\n");
              }
            }        
         }
         
         public String visMenu()
         {
            String menu = "Velkommen!\n";
            menu += "Hvad vil du foretage dig?\n";
            menu += "1: Bland et s�t kort.\n";
            menu += "2: Bland et s�t kort og tr�k det �verste kort.\n";
            menu += "3: Tr�k et antal kort og se, hvor mange der er tilbage.\n";
            menu += "0: Afslut programmet og du f�r et nyt s�t kort.\n";
            return menu;                     
         }
   }
   


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es1fbk;
import java.util.Scanner;

/**
 *
 * @author alexi
 */
public class Es1FBK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserire il numero per il nuovo conto");               
        
        ContoCorrente cc = new ContoCorrente(sc.nextInt());
        System.out.println("Conto creato");
        int scelta = 0;
                
        do{
            System.out.println("1:Prelievo, 2:Versamento, 3:Salto o "
                    + "4:Lista movimenti. 0 per uscire.");
            
            scelta = sc.nextInt();            
            
            switch(scelta){
                case 0:
                    break;
                  
                case 1:
                    System.out.println("Inserire quanto si vuole prelevare e la "
                            + "causale");                    
                    cc.prelievo(sc.nextDouble(), sc.next());
                    sc.nextLine();
                    System.out.println("Il suo saldo è di: " + cc.getSaldo());
                    break;
                   
                case 2:
                    System.out.println("Inserire quanto si vuole versare e la "
                            + "causale");                    
                    cc.versamento(sc.nextDouble(), sc.next());
                    sc.nextLine();

                    System.out.println("Il suo saldo è di: " + cc.getSaldo());

                    break;
                    
                case 3:
                    System.out.println("Il suo saldo è di: " + cc.getSaldo());
                    break;
                
                case 4:
                    System.out.println(cc.listaMov());
                  
                default:
                    break;

            }
        }while(scelta != 0);
        
        
    }
    
}

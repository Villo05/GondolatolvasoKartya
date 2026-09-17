package main;

import java.util.Scanner;

public class GondolatolvasoKartya {

    static String[] pakli = new String[22];
    static Scanner sc = new Scanner(System.in);
    static int oszlop;
    
    public static void main(String[] args) {
        feltoltes();
        for (int i = 0; i < 3; i++) {
            kirajzol(); // 1 tömb
            valasztas(); // Scanner
            keveres(); // középre
        }
        
        ezVolt(); //11., az az a középső
        
    }
    
    private static void feltoltes(){
        String[] szinek = {"P", "T", "Z", "M"};
        String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VIII"};
        
        int db =0;
        for (String szin : szinek) {
            for (String ertek : ertekek) {
                String lap = szin + "_" + ertek;
                if(db < 21){
                    pakli[++db] = lap;
                }
            }
        }
    }

    private static void kirajzol() {
        System.out.printf("%-15s %-15s %-15s%n", "  1.", "  2.", "  3.");
        for (int i = 1; i <= 21; i += 3) {
            System.out.printf("%-15s %-15s %-15s%n",
                    pakli[i],
                    pakli[i + 1],
                    pakli[i + 2]);
        }
    }

    private static void valasztas() {
        
        System.out.println("Válassz egy kártyát");
        System.out.print("Melyik oszlopban van a választott kártya? (1-3): ");
        oszlop = sc.nextInt();

        while (oszlop < 1 || oszlop > 3) {
            System.out.print("Hibás választás! (1-3): ");
            oszlop = sc.nextInt();
        }
    }

    private static void keveres() {
        String[] ujPakli = new String[22];

        switch (oszlop) {
            case 1:
                for (int i = 1; i <= 7; i++) {
                    ujPakli[i] = pakli[20 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[21 - (i - 1) * 3];
                }
                break;

            case 2:
                for (int i = 1; i <= 7; i++) {
                    ujPakli[i] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[20 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[21 - (i - 1) * 3];
                }
                break;

            case 3:
                for (int i = 1; i <= 7; i++) {
                    ujPakli[i] = pakli[19 - (i - 1) * 3];
                    ujPakli[i + 7] = pakli[21 - (i - 1) * 3];
                    ujPakli[i + 14] = pakli[20 - (i - 1) * 3];
                }
                break;
        }

        pakli = ujPakli;
    }

    private static void ezVolt() {
        System.out.println("A kiválasztott kártya: " + pakli[11]);
    }
}

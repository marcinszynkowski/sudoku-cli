/*
SUDOKU 
NAJPROSTSZA WERSJA Z NAJPROSTSZYCH
ALGORYTM SPRAWDZANIA PEWNIE NIEEFEKTYWNY, ALE DZIAŁA !!!
 */
package sudoku;

import java.util.Scanner;

/**
 *
 * @author Marcin
 */
public class Sudoku {

    static int tab[][] = new int[9][9]; // Tabelka 9x9
    
    public static void RysujPlansze(){ // rysujemy plansze 
        for (int i=0; i<9; i++){
            for (int j=0;j<9; j++){
                if (tab[i][j] == 0){
                    System.out.print(" - "); // jesli jakis element jest zerem - to rysujemy kreske 
                }
                else {
                    System.out.print(" " + tab[i][j] + " "); // jezeli nie, to wypisujemy ten element 
                }
            }
            System.out.println("");
        }
    }
    
    public static void ZmienCos(){ // zmienanie elementu
        Scanner sc = new Scanner(System.in);
        System.out.println("x : ");
        int x = sc.nextInt();
        System.out.println("x : ");
        int y = sc.nextInt();
        System.out.println("Wartosc : ");
        tab[x][y] = sc.nextInt();
        RysujPlansze();
    }
    
    public static int checkNulls(){ // sprawdz ile jeszcze zer pozostało do wypelnienia
        int nulls = 0;
        for (int i = 0; i<9; i++ ){
            for (int j = 0; j<9; j++ ){
                if (tab[i][j] == 0) {
                    nulls++;
                }
            }
        }
        return nulls;
    }
    
    public static int checkCell(int wiersz, int kolumna){ // sprawdzanie komorki
        int temp = tab[wiersz][kolumna];
        int err = 0;
        for (int i = 0; i<9; i++ ){
            if (tab[i][kolumna] == 0) continue;
            if (wiersz == i) continue;
            if (temp == tab[i][kolumna]){
                err++;
            }
        }
        
        for (int j = 0; j<9; j++ ){
            if (tab[wiersz][j] == 0) continue;
            if (kolumna == j) continue;
            if (temp == tab[wiersz][j]){
                err++;
            }
        }
      return err;  
    }
    
    public static void SprawdzPlansze(){ // sprawdzanie planszy w poszukiwaniu bledow
        int errors = 0;
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
               int err = checkCell(i, j);
               errors = errors + err;
            }
        }
        if (errors > 0){
            System.out.println("Sa bledy");
        }
        else {
            System.out.println("Nie ma bledow");
        } 
        int nulls = checkNulls(); // pobieramy ilosc zer
        if (nulls == 0 && errors == 0){ // jezeli nie ma juz pustych pol i nie ma bledow to rozwiazane sudoku
            System.out.println("GRATULACJE !!!! ROZWIĄZAŁEŚ SUDOKU.");
        }
    }
    
    public static void main(String[] args) {
        int w = 0;  // zmienna sterujaca, na razie bezuzyteczna
        int m = 0; // ruchy
        RysujPlansze();
        ZmienCos();
        m++;
        while (w == 0){
            ZmienCos();
            m++;
            if (m > 2){
                SprawdzPlansze();
            }
            
        }   
    }
}

package presentation;

import dao.DaoImpl;
import metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args) {
        //Injection des dependences par l'instanciation statique
        DaoImpl dao = new DaoImpl(); // Instanciation statique
        MetierImpl metier = new MetierImpl();
        metier.setDao(dao);//Injection des dependances
        System.out.println("RES"+metier.calcul());
    }
}

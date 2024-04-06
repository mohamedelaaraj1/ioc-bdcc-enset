package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres22 {
    public static void main(String[] args) throws Exception {
        //DaoImpl dao = new DaoImpl(); // Instanciation statique
        Scanner scanner = new Scanner(System.in);
        System.out.print("Donner la classe de la couche DAO :");
        String daoClasseName=scanner.nextLine();
        //Instanciation dynamique
        Class cDao = Class.forName(daoClasseName);
        IDao  dao =(IDao) cDao.getConstructor().newInstance();// => new DaoImpl()


        //MetierImpl metier = new MetierImpl();
        System.out.print("Donner la couche Métier :");
        String metierClassname = scanner.nextLine();
        Class cMetier = Class.forName(metierClassname);
        IMetier metier = (IMetier) cMetier.getConstructor().newInstance();

        //metier.setDao(dao);//Statique
        Method setDao = cMetier.getDeclaredMethod("setDao",IDao.class);
        setDao.invoke(metier,dao); //Injection des dépendances dynamique
        //System.out.println("RES"+metier.calcul());

        System.out.println("RESULTAT= "+metier.calcul());
    }
}

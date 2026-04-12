package StructuralDesignPatterns.FacadeDesignPattern.GoodPractice;

import javax.print.attribute.standard.Media;
import java.util.Scanner;

public class MediaApp {
    public static void main(String[] args) {
        MediaFacade mediaFacade =  new MediaFacade();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome multiMediaApp");
        System.out.println("Choose an action: playMusic, playVideo, viewImage");
        String action = scanner.nextLine();
        mediaFacade.performAction(action);
        scanner.close();
    }
}

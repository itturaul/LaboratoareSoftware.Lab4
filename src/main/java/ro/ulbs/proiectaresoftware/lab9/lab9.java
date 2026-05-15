package ro.ulbs.proiectaresoftware.lab9;

import java.util.*;
import java.util.stream.Collectors;

public class Laborator9 {

    public static void main(String[] args) {
        System.out.println("=== Rezolvare 9.3.1 (Numere) ===");
        rezolvaExercitiuNumere();

        System.out.println("\n=== Rezolvare 9.3.2 (Text) ===");
        rezolvaExercitiuText();
    }

    public static void rezolvaExercitiuNumere() {
        Random random = new Random();

        List<Integer> numere = random.ints(10, 5, 26)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Lista: " + numere);

        int suma = numere.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Suma: " + suma);

        numere.stream().max(Integer::compare).ifPresent(m -> System.out.println("Max: " + m));
        numere.stream().min(Integer::compare).ifPresent(m -> System.out.println("Min: " + m));

        List<Integer> filtrate = numere.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
        System.out.println("Filtrate [10-20]: " + filtrate);

        List<Double> numereDouble = numere.stream()
                .map(Double::valueOf)
                .collect(Collectors.toList());
        System.out.println("Lista Double: " + numereDouble);

        boolean exista12 = numere.stream().anyMatch(n -> n == 12);
        System.out.println("Conține 12: " + (exista12 ? "Da" : "Nu"));
    }

    public static void rezolvaExercitiuText() {
        String text = "Acesta este un program scris in java pentru expresii lambda";
        List<String> cuvinte = Arrays.asList(text.split(" "));

        List<String> lungi = cuvinte.stream()
                .filter(c -> c.length() >= 5)
                .collect(Collectors.toList());
        System.out.println("Cuvinte >= 5 caractere: " + lungi);

        List<String> ordonate = lungi.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Lista ordonată: " + ordonate);

        cuvinte.stream()
                .filter(c -> c.startsWith("p"))
                .findFirst()
                .ifPresent(c -> System.out.println("Element cu 'p': " + c));
    }
}
}
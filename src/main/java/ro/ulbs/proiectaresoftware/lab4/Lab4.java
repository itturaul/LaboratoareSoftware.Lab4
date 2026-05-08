package ro.ulbs.proiectaresoftware.lab4;

import java.util.HashMap;
import java.util.Map;

public class Lab4 {
    public static void main(String[] args) {

        // a)
        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);

        System.out.println("Varste initiale:");
        varste.forEach((k, v) -> System.out.println(k + " -> " + v));

        varste.put("Vlad", 19);
        varste.put("Iulia", 19);

        System.out.println("\nDupa adaugare:");
        varste.forEach((k, v) -> System.out.println(k + " -> " + v));

        Map<String, String> adrese = Map.of(
                "Ioan", "Sibiu",
                "Maria", "Bucuresti",
                "Victor", "Cluj",
                "Simina", "Alba-Iulia",
                "Marius", "Medias",
                "Mihai", "Cisnadie",
                "Daniela", "Sibiu"
        );

        HashMap<String, Tanar> tineri = new HashMap<>();

        for (String nume : varste.keySet()) {
            int varsta = varste.get(nume);
            String adresa = adrese.getOrDefault(nume, "Necunoscuta");

            Tanar tanar = new Tanar(nume, varsta, adresa);
            tineri.put(nume, tanar);
        }

        System.out.println("\nLista tineri:");
        tineri.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}


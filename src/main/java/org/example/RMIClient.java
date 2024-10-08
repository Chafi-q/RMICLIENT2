package org.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            Registry registry = LocateRegistry.getRegistry("localhost",1099);
            MyRemoteService service = (MyRemoteService)registry.lookup("MyRemoteService");
            String response = service.hello();
            System.out.println("Response from server: "+response);

            while (true) {
                System.out.println(service.menu());
                int choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        System.out.print("Entrez le titre du livre: ");
                        String titre = scanner.nextLine();
                        System.out.print("Entrez l'auteur du livre: ");
                        String auteur = scanner.nextLine();
                        System.out.print("Entrez l'ISBN du livre: ");
                        Long isbn = Long.valueOf(scanner.nextLine());

                        Livre livre = new Livre(isbn, auteur, titre);
                        service.addBook(livre);
                        System.out.println("Livre ajouté avec succès !");
                        break;

                    case 2:
                        System.out.print("Entrez le titre du livre à rechercher: ");
                        String titreRech = scanner.nextLine();
                        Livre livreRech = service.findBook(titreRech);
                        if (livreRech != null) {
                            System.out.println("Livre trouvé: " + livreRech);
                        } else {
                            System.out.println("Livre non trouvé !");
                        }
                        break;

                    case 3:
                        List<Livre> livres = service.getBooks();
                        if (livres.isEmpty()) {
                            System.out.println("Aucun livre n'est enregistré.");
                        } else {
                            System.out.println("Liste des livres :");
                            for (Livre l : livres) {
                                System.out.println(l.toString());
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Au revoir !");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
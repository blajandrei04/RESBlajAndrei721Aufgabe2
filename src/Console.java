
import model.Charaktere;
import model.Produkt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private Controller controller;

    public Console(Controller controller) {
        this.controller = controller;
    }
    public Console() {}

    public void setController(Controller controller) {this.controller = controller;}

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while (option != 0)
        {
            System.out.println("""
                    1. Alles anschreiben
                    2. Produkt CRUD
                    3. Charaktere CRUD
                    0. Exit""");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {controller.alleCharaktereAnschreiben();
                    controller.alleProdukteAnschreiben();
                    break;}

                case 2: {
                    System.out.println("""
                            1. Neues Produkt hinzufugen
                            2. Alle Produkte sehen
                            3. Ein bestimmtes Produkt finden
                            4. Ein Produkt aktualisieren
                            5. Ein Produkt loschen
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {controller.createProdukt(); break;}
                        case 2: {controller.alleProdukteAnschreiben(); break;}
                        case 3: {controller.showAProdukt(); break;}
                        case 4: {controller.updateProduktValidate(); break;}
                        case 5: {controller.deleteProdukt(); break;}
                        case 0:break;
                    }
                }

                case 3:
                {
                    System.out.println("""
                            1. Neuer Charakter hinzufugen
                            2. Alle Charaktere sehen
                            3. Einen bestimmten Charakter finden
                            4. Einen Charakter aktualisieren
                            5. Einen Charakter loschen
                            6. Charaktere nach Region filtrieren
                            7. Charaktere finden, die ein Produkt in einer gegebenen Universum gekauft haben
                            8. Sortiere Produkte eines Charakteres nach Preis
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {controller.createCharakter(); break;}
                        case 2: {controller.alleCharaktereAnschreiben(); break;}
                        case 3: {controller.showKunde(); break;}
                        case 4: {controller.updateKundeValidate(); break;}
                        case 5: {controller.deleteKunde(); break;}
                        case 6: {controller.kundenNachOrtFiltrieren(); break;}
                        case 7: {controller.kundenNachProduktjahreszeitFiltrieren(); break;}
                        case 8: {controller.produkteEinesKundenNachPreisSortieren(); break;}
                        case 0:break;
                    }
                }

                case 0: break;
            }
        }

    }

    public static void main(String[] args) {

        Repository<Produkt> produktRepository = new Repository<>();
        Repository<Charaktere> charaktereRepository = new Repository<>();

        Console console = new Console();
        console.initialiseData(charaktereRepository,produktRepository);

        Service service = new Service(charaktereRepository, produktRepository);
        Controller controller = new Controller(service);

        console = new Console(controller);
        console.run();
    }

    public void initialiseData(Repository<Charaktere> kundeRepository, Repository<Produkt> produktRepository) {
        Produkt produkt1 = new Produkt("Mjolnir",400,"Asgard");
        Produkt produkt2 = new Produkt("Vibraniun-Schild",200,"Wakanda");
        Produkt produkt3 = new Produkt("Web-Shooter",100,"Terra");
        Produkt produkt4 = new Produkt("NornStones",70,"Asgard");
        Produkt produkt5 = new Produkt("Darkhold",150,"Multiverse");
        Produkt produkt6 = new Produkt("Ark-Reactor",200,"Terra");
        Produkt produkt7 = new Produkt("CosmicCube",100,"Multiverse");

        produktRepository.addElement(produkt1);
        produktRepository.addElement(produkt2);
        produktRepository.addElement(produkt3);
        produktRepository.addElement(produkt4);
        produktRepository.addElement(produkt5);
        produktRepository.addElement(produkt6);
        produktRepository.addElement(produkt7);

        List<Produkt> listeKunde1 = new ArrayList<>();
        listeKunde1.add(produkt1); listeKunde1.add(produkt3); listeKunde1.add(produkt4);
        Charaktere kunde1 = new Charaktere(1,"Thor","Asgrad",listeKunde1);

        List<Produkt> listeKunde2 = new ArrayList<>();
        listeKunde2.add(produkt2); listeKunde2.add(produkt6);
        Charaktere kunde2 = new Charaktere(2,"Black Panther","Wakanda",listeKunde2);

        List<Produkt> listeKunde3 = new ArrayList<>();
        listeKunde3.add(produkt3); listeKunde3.add(produkt5);
        Charaktere kunde3 = new Charaktere(3,"Iron-Man","Terra",listeKunde3);

        List<Produkt> listeKunde4 = new ArrayList<>();
        listeKunde3.add(produkt1); listeKunde3.add(produkt5);
        Charaktere kunde4 = new Charaktere(3,"Spider-Man","Terra",listeKunde4);

        kundeRepository.addElement(kunde1);
        kundeRepository.addElement(kunde2);
        kundeRepository.addElement(kunde3);
        kundeRepository.addElement(kunde4);
    }
}

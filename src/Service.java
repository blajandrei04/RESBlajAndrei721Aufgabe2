import model.Charaktere;
import model.Produkt;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private Repository<Charaktere> charaktereRepository;
    private Repository<Produkt> produktRepository;

    public Service(Repository<Charaktere> charaktereRepository, Repository<Produkt> produktRepository) {
        this.charaktereRepository = charaktereRepository;
        this.produktRepository = produktRepository;
    }

    public List<Charaktere> alleKundenZuruckgeben() {
        return charaktereRepository.getAllElements();
    }

    public List<Produkt> alleProdukteZuruckgeben() {
        return produktRepository.getAllElements();
    }

    /**
     * Creates a product and adds it to the repopsitory
     * @param name
     * @param preis
     * @param universum
     */
    public void createAProdukt(String name,int preis, String universum){
        produktRepository.addElement(new Produkt(name,preis,universum));
    }

    /**
     * Retrieves a product by its id
     * @param name
     * @return product with the id from the user input
     */
    public Produkt getProdukt(String name){
        int id = -1;
        for (Produkt p : produktRepository.getAllElements()) {
            if (p.getName().equals(name))
            {id = produktRepository.getAllElements().indexOf(p); break;}
        }
        return produktRepository.getElement(id);
    }

    /**
     * Updates a produkt by the user input
     * @param produkt
     */
    public void updateProdukt(Produkt produkt){
        for (Produkt p : produktRepository.getAllElements()){
            if (p.getName().equals(produkt.getName())){
                int index = produktRepository.getAllElements().indexOf(p);
                p.setPrice(produkt.getPrice());
                p.setUniversum(produkt.getUniversum());
                produktRepository.updateElement(index,produkt);
                break;
            }
        }
    }

    /**
     * Deletes a produkt using the id from the user input
     * @param name
     */
    public void deleteProdukt(String name){
        for (Produkt p : produktRepository.getAllElements()){
            if (p.getName().equals(name)){
                produktRepository.remove(p);
                break;
            }
        }
    }

    public void createAKunde(String name, String ort){
        int id = -1;
        for (Charaktere k : charaktereRepository.getAllElements()){
            if (id < k.getId())
                id = k.getId();
        }
        id += 1;

        charaktereRepository.addElement(new Charaktere(id,name,ort,new ArrayList<>()));
    }

    public Charaktere getCharakter(int id){
        for (Charaktere p : charaktereRepository.getAllElements()) {
            if (p.getId() == id)
                return p;
        }
        throw new RuntimeException("Kunde nicht gefunden");
    }

    public void updateCharakter(Charaktere kunde){
        for (Charaktere p : charaktereRepository.getAllElements()){
            if (p.getId() == kunde.getId()){
                int index = charaktereRepository.getAllElements().indexOf(p);
                p.setName(kunde.getName());
                p.setRegion(kunde.getRegion());
                charaktereRepository.updateElement(index,p);
                break;
            }
        }
    }

    public void deleteCharakter(int id){
        for (Charaktere p : charaktereRepository.getAllElements()){
            if (p.getId() == id){
                charaktereRepository.remove(p);
                break;
            }
        }
    }


    public List<Charaktere> filterNachRegion(String region){
        List<Charaktere> kundeList = new ArrayList<>();
        kundeList = charaktereRepository.getAllElements().stream().filter(kunde -> region.equals(kunde.getRegion())).toList();

        return kundeList;
    }

    public List<Charaktere> filterNachProduktUniversum(String universum){
        List<Charaktere> kundeList = new ArrayList<>();

        return charaktereRepository.getAllElements().stream().filter(kunde -> kunde.richtigeUniversum(universum)).toList();
    }

    public List<Produkt> nachPreissortierteProdukteEinesCharakters(int id, String sortierModus){
        Charaktere kunde = new Charaktere();
        for (Charaktere p : charaktereRepository.getAllElements()){
            if (p.getId() == id){
                kunde = p;
                break;
            }
        }
        List<Produkt> produktList = kunde.getProduktList();
        produktList.sort(Produkt::compareTo);
        if (sortierModus.equals("Steigend"))
            return produktList;
        else
        {
            return produktList.reversed();

        }
    }
}

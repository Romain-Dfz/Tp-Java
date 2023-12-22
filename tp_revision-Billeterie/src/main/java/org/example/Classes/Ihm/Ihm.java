package org.example.Classes.Ihm;

import org.example.Classes.model.Client;
import org.example.Classes.dao.ClientDAO;
import org.example.Classes.model.Evenement;
import org.example.Classes.model.Lieu;
import org.example.Classes.dao.LieuDAO;
import org.example.Classes.util.DatabaseManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ihm {

    private Connection connection;
    protected List<Lieu> listLieu = new ArrayList<>();
    protected List<Client> listCLient = new ArrayList<>();
    protected List<Evenement> listEvenement = new ArrayList<>();

    private Scanner s = new Scanner(System.in);
    private List listClient;

    public Ihm() {
        try {
            DatabaseManager connection = new DatabaseManager();
            connection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {
        this.menuGenerale();
    }

    public void menuGenerale() {
        try {
            System.out.println("----------menu---------");
            System.out.println("1/ action Lieux");
            System.out.println("2/ action Evenements");
            System.out.println("3/ action client");
            System.out.println("0/ quitter");
            System.out.println("entrer votre choix :");
            int entry = s.nextInt();
            switch (entry) {
                case 1:
                    this.menuLieux();
                    break;
                case 2:
                    this.menuEvenement();
                    break;
                case 3:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("entrer une valeur correspondant a un choix");
                    this.menuGenerale();
                    break;
            }

        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.menuGenerale();
        }

    }


    private Connection createConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/billet";
        String utilisateur = "root";
        String motDePasse = "test";
        return DriverManager.getConnection(url, utilisateur, motDePasse);
    }
    public void menuLieux() {
        try (Connection connection = createConnection()) {
            int id = 0;
            String nom = null;
            String adresse = null;
            Integer capacite = null;
            LieuDAO lieuDAO = new LieuDAO(id, nom, adresse, capacite, connection);

            // Reste du code de votre méthode menuLieux
            try {
                System.out.println("----------menu Lieux---------");
                System.out.println("1/ ajouter un lieu");
                System.out.println("2/ modifier un lieu");
                System.out.println("3/ supprimer un lieu");
                System.out.println("0/ retourner au menu generale");
                System.out.println("entrer votre choix :");
                int entry = s.nextInt();
                switch (entry) {
                    case 1:
                        addLieux(connection, lieuDAO);
                        break;
                    case 2:
                        modifLieu(connection, lieuDAO);
                        break;
                    case 3:
                        suprLieu(connection, lieuDAO);
                        break;
                    case 0:
                        // N'oubliez pas de committer avant de quitter
                        connection.commit();
                        menuGenerale();
                        break;
                    default:
                        System.out.println("entrer une valeur correspondant a un choix");
                        menuLieux();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("entrer une valeur numerique ");
                menuLieux();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addLieux(Connection connection, LieuDAO lieuDAO) {
        try {
            System.out.println("--------ajouter lieu----------");
            System.out.println("entrer le nom du lieu :");
            String nomLieux = s.next();
            System.out.println("entrer l'adresse du lieu :");
            String adresse = s.next();
            int capacite = this.entryCapacity();

            // Ajoutez le nouvel objet Lieu avec les trois paramètres nécessaires (l'ID sera généré automatiquement)
            lieuDAO.addLieu(nomLieux, adresse, capacite);

            System.out.println("le lieu a bien été ajouté !");
            this.menuLieux();
        } catch (InputMismatchException | SQLException e) {
            System.out.println("Une erreur s'est produite lors de l'ajout du lieu.");
            e.printStackTrace();
            this.menuLieux();
        }
    }


    public void modifLieu(Connection connection, LieuDAO lieuDAO) {
        try {
            afficheList(this.listLieu);
            System.out.println("quelle lieu voulez-vous modifier : ");
            int entry = s.nextInt();

            Lieu selectedLieu = this.listLieu.get(entry - 1);

            System.out.println(selectedLieu);

            System.out.println("entrer le nouveau nom : ");
            String nom = s.next();
            System.out.println("entrer la nouvelle adresse : ");
            String adresse = s.next();
            int capacite = entryCapacity();

            Lieu updatedLieu = new Lieu(nom, adresse, capacite);

            this.listLieu.set(entry - 1, updatedLieu);

            lieuDAO.updateLieu(selectedLieu.getId(), updatedLieu);

            System.out.println("Lieu mis à jour :");
            System.out.println(updatedLieu);

            menuLieux();
        } catch (InputMismatchException e) {
            System.out.println("Entrer une valeur numérique ");
            modifLieu(connection, lieuDAO);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index hors limites");
            menuLieux();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void suprLieu(Connection connection, LieuDAO lieuDAO) {
        try {
            int entry = s.nextInt();

            lieuDAO.deleteLieu(Integer.parseInt(String.valueOf(entry)));

            System.out.println("le lieu a bien ete supprime");
            menuLieux();
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            suprLieu(connection, lieuDAO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int entryCapacity() {
        int entry = 0;
        do {
            System.out.println("entrer la capacité du lieu :");
            entry = s.nextInt();
        }
        while (entry <= 0);

        return entry;
    }
    public void menuEvenement() {
        try {
            System.out.println("----------menu Evenement---------");
            System.out.println("1/ ajouter un Evenement");
            System.out.println("2/ modifier un Evenement");
            System.out.println("3/ supprimer un Evenement");
            System.out.println("4/ afficher la liste des evenements");
            System.out.println("0/ retourner au menu generale");
            System.out.println("entrer votre choix :");
            int entry = s.nextInt();
            switch (entry) {
                case 1:
                    this.addEvenement();
                    break;
                case 2:

                    break;
                case 3:
                    this.suprEvenement();
                    break;
                case 4:
                    this.afficheList(this.listEvenement);
                    break;
                case 0:
                    this.menuGenerale();
                    break;
                default:
                    System.out.println("entrer une valeur correspondant a un choix");
                    this.menuEvenement();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.menuCLient();
        }
    }

    private void menuCLient() {
    }

    public void addEvenement() {
        try {
            System.out.println("--------ajouter Evenement----------");

            System.out.println("entrer le nom de l'evenement:");
            String nom = s.next();

            System.out.println("entrer la date de l'evenement (format dd-MM-yyyy):");
            String date_string = s.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(date_string);

            System.out.println("entrer l'heure de l'evenement :");
            String heure = s.next();

            System.out.println();
            this.afficheList(listLieu);
            System.out.println("selectionner le lieu de l'evenement :");
            int lieux = s.nextInt();

            System.out.println("entrer le prix du billet");
            float prix = s.nextFloat();


            this.listEvenement.add(new Evenement(nom, date, heure, prix, this.listLieu.get(lieux - 1)));
            System.out.println("l'evenement a bien ete ajouter :");
            System.out.println(listEvenement.get(listEvenement.size() - 1));
            this.menuEvenement();
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.addEvenement();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void suprEvenement() {
        try {
            System.out.println("--------supr evenement----------");
            afficheList(this.listEvenement);
            System.out.println("quelle evenement vouler vous supprimer (0 pour retour) : ");
            int entry = s.nextInt();

            if (entry == 0) {
                this.menuEvenement();
            } else {
                this.listEvenement.remove(entry - 1);
                System.out.println("l'evenement a bien ete supprimer");
                this.menuEvenement();
            }
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.suprEvenement();
        }
    }
    public void menuClient() {
        try {
            System.out.println("----------menu Client---------");
            System.out.println("1/ ajouter un Client");
            System.out.println("2/ modifier un Client");
            System.out.println("3/ supprimer un Client");
            System.out.println("4/ acheter un billet");
            System.out.println("5/ annuler un billet");
            System.out.println("6/ afficher la liste des billets d'un client");
            System.out.println("0/ retourner au menu general");
            System.out.println("entrer votre choix :");
            int entry = s.nextInt();

            switch (entry) {
                case 1:
                    this.addClient();
                    break;
                case 2:
                    this.modifClient();
                    break;
                case 3:
                    this.suprClient();
                    break;
                case 4:
                    achatBillet(true);
                    break;
                case 5:
                    achatBillet(false);
                    break;
                case 6:
                    affichageBillet();
                    break;
                case 0:
                    this.menuGenerale();
                    break;
                default:
                    System.out.println("entrer une valeur correspondant a un choix");
                    this.menuClient();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numerique ");
            this.menuClient();
        }
    }


    public void addClient() {
        try {
            System.out.println("--------ajouter Client----------");
            System.out.println("entrer le nom du client :");
            String nom = s.next();

            System.out.println("entrer le prénom du client :");
            String prenom = s.next();

            System.out.println("entrer l'email du client : ");
            String email = s.next();

            this.listClient.add(new Client(nom, prenom, email));
            System.out.println("le Client a bien été ajouté :");
            System.out.println(listClient.get(listClient.size() - 1));
            this.menuClient();  // Correction ici
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur numérique ");
            this.addClient();
        }
    }


    public void modifClient() {
        try {
            System.out.println("--------modifier Client----------");
            afficheList(this.listClient);
            System.out.println("quelle Client voulez-vous modifier : ");
            int entry = s.nextInt();

            Client selectedClient = (Client) this.listClient.get(entry - 1);

            System.out.println(selectedClient);

            System.out.println("entrer le nouveau nom : ");
            String nom = s.next();
            System.out.println("entrer le nouveau prenom : ");
            String prenom = s.next();
            System.out.println("entrer la nouvelle adresse email : ");
            String email = s.next();

            Client updatedClient = new Client(nom, prenom, email);

            this.listClient.set(entry - 1, updatedClient);

            ClientDAO clientDAO = null;
            clientDAO.updateClient(updatedClient);

            System.out.println("Client mis à jour :");
            System.out.println(updatedClient);

            menuClient();
        } catch (InputMismatchException e) {
            System.out.println("Entrer une valeur numérique ");
            modifClient();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index hors limites");
            menuClient();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void suprClient() {
        try {
            afficheList(this.listClient);
            System.out.println("Quel client voulez-vous supprimer (0 pour retour) : ");
            int entry = s.nextInt();

            if (entry == 0) {
                this.menuClient();
            } else {
                // Obtenez la connexion à partir de votre DatabaseManager ou créez-la ici
                Connection connection = DatabaseManager.getConnection(); // Remplacez DatabaseManager.getConnection() par votre manière d'obtenir une connexion

                // Initialisez clientDAO avec une instance de ClientDAO en passant la connexion
                ClientDAO clientDAO = new ClientDAO(connection);
                clientDAO.deleteClient(String.valueOf(this.listClient.get(entry - 1).getClass()));
                this.listClient.remove(entry - 1);
                System.out.println("Le client a bien été supprimé");
                this.menuClient();
            }
        } catch (InputMismatchException | SQLException e) {
            System.out.println("Erreur lors de la suppression du client.");
            e.printStackTrace();
            this.menuClient();
        }
    }



    public void achatBillet(boolean achat) {
        try {
            if (achat) {
                System.out.println("---------achat billet -----------");
            } else {
                System.out.println("---------Annulation billet -----------");
            }

            afficheList(this.listCLient);
            System.out.println("choisiser un client :");
            int client = s.nextInt();

            System.out.println("client choisi " + this.listCLient.get(client - 1));

            afficheList(this.listEvenement);
            System.out.println("choisiser un evenemement");
            int event = s.nextInt();

            if (achat) {
                this.listCLient.get(client - 1).acheterBillet(this.listEvenement.get(event - 1));
            } else {
                this.listCLient.get(client - 1).annulerBillet(this.listEvenement.get(event - 1));
            }
            this.menuCLient();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("index out of bound");
            this.menuCLient();
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur valide");
            this.achatBillet(achat);
        }
    }

    public void affichageBillet() {
        try {
            System.out.println("---------afffichage des billets----------");
            afficheList(this.listCLient);
            System.out.println("choisiser un client :");
            int client = s.nextInt();

            this.afficheList(this.listCLient.get(client - 1).getListeBillets());

            this.menuCLient();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("index out of bound");
            this.menuCLient();
        } catch (InputMismatchException e) {
            System.out.println("entrer une valeur valide");
            this.affichageBillet();
        }
    }
    public void afficheList(List list) {
        list.forEach(System.out::println);
        System.out.println();
    }
    public void menuLieu() {
        try (Connection connection = createConnection()) {
            int id = 0;
            String nom = null;
            String adresse = null;
            Integer capacite = null;
            LieuDAO lieuDAO = new LieuDAO(id, nom, adresse, capacite, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
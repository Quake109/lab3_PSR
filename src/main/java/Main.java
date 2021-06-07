import java.util.Optional;
import java.util.Scanner;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.mapper.annotations.Update;
import models.Client;
import models.Offer;
import models.Office;

public class Main {


    public static void main(String[] args) {


        CqlSession session = CqlSession.builder().build();
        KeyspaceManager keyspaceManager = new KeyspaceManager(session, "offer");
        keyspaceManager.dropKeyspace();
        keyspaceManager.selectKeyspaces();
        keyspaceManager.createKeyspace();
        keyspaceManager.useKeyspace();

        OfferTableManager tableManager = new OfferTableManager(session);
        tableManager.createTable();

        CodecManager codecManager = new CodecManager(session);
        codecManager.registerClientCodec();
        codecManager.registerOfficeCodec();

        OfferMapper visitMapper = new OfferMapperBuilder(session).build();
        OfferDao dao = visitMapper.offerDao(CqlIdentifier.fromCql("offer"));


        Scanner scan = new Scanner(System.in);
        String option = "";
        while (!option.equals("0")) {
            System.out.println("Pick the option: ");
            System.out.println("1.Save \n2.Update \n3.Delete offer by ID \n4.Download \n5.Download offer by ID \n6.Download offer by rating \n0.Exit");
            option = scan.nextLine();
            switch (option) {
                case "0":
                    System.out.println("Exit");
                    break;
                case "1":
                    System.out.println("Save");

                    Client client1 = new Client("Krzysztof", "Siczek","666111222","+48111222333");
                    Client client2 = new Client("Jan", "Sobieski","5523412223","+4864533242");
                    Client client3 = new Client("Jacek", "Byk","6432432123","+4812351233");

                    Office office1 = new Office("RAD123","Swietokrzyska 5",10);
                    Office office2 = new Office("KIEL12","Kielcecka 12",7);
                    Office office3 = new Office("WAW125","Jacka 50",3);

                    Offer offer1 = new Offer(1, "Zakopane","Cold",2,client1,office3);
                    Offer offer2 = new Offer(2, "Gubalowka","Cold",7,client2,office1);
                    Offer offer3 = new Offer(3, "Gdansk","Warm",3,client3,office2);
                    Offer offer4 = new Offer(4, "Mazury","Cold",8,client1,office3);
                    Offer offer5 = new Offer(5, "Indie","Warm",5,client2,office2);
                    Offer offer6 = new Offer(6, "Norwegia","Cold",6,client3,office1);

                    dao.save(offer1);
                    dao.save(offer2);
                    dao.save(offer3);
                    dao.save(offer4);
                    dao.save(offer5);
                    dao.save(offer6);

                    break;
                case "2":
                  System.out.println("Update");
                  System.out.println("Enter the offers ID:");
                  int offerToEdit = new Scanner(System.in).nextInt();
                  Offer offer = dao.getByIdOffer(offerToEdit);
                  System.out.println("Enter new rating:");
                  int offerNewRating = new Scanner(System.in).nextInt();
                  dao.updateByRating(offer, offerToEdit,offerNewRating );
                  System.out.println("After edit:");
                  System.out.println(dao.getByIdOffer(offerToEdit));
                  break;
                case "3":
                    System.out.println("Delete by ID");
                    System.out.println("Enter the offers ID:");
                    int offerToDelete = new Scanner(System.in).nextInt();
                    dao.getById(offerToDelete).ifPresent(dao::delete);
                    break;
                case "4":
                    System.out.println("Download");
                    dao.getAll().forEach(System.out::println);
                    break;
                case "5":
                    System.out.println("Download by ID");
                    System.out.println("Enter ID: ");
                    int id = new Scanner(System.in).nextInt();
                    Optional<Offer> off = dao.getById(id);
                    System.out.println(off);
                    break;
                case "6":
                    System.out.println("Download by rating");
                    int findRating = new Scanner(System.in).nextInt();
                    Offer ratingNew = dao.getByRating(findRating);
                    System.out.println(ratingNew);
                    break;
            }
        }

    }

    }

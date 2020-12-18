package com.evaluation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class ServicePersonne {

    private final String CSV_FILE_PATH = "src/dataPersonne.csv";

    private List<Personne> personnes = new ArrayList<>();

    /**
     * Creation du fichier csv si il n'existe pas, renvois un message d'erreur en
     * console si il existe
     */
    public void createCSV() {

	File csv = new File("src/dataPersonne.csv");

	if (!csv.exists()) {

	    try {
		// creation du header pour notre csv
		String[] headerRecord = { "Nom", "Prenom", "tel", "mail" };
		// creation du cvs
		CSVWriter csvWriter = new CSVWriter(new FileWriter(CSV_FILE_PATH, true));
		// Ecriture du header dans le csv
		csvWriter.writeNext(headerRecord);
		// fermeture de notre Writer
		csvWriter.close();
	    } catch (IOException ex) {
		ex.printStackTrace();
	    }

	} else {
	    System.out.println(" file already exist : " + CSV_FILE_PATH);
	}
    }

    /**
     * Lire toutes les personnes du csv
     *
     * @return List de personne
     * @throws IOException :
     */
    public List<Personne> readAll() throws IOException {

	// Creation de notre reader

	Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
	CsvToBean<Personne> csvToBean = new CsvToBeanBuilder<Personne>(reader).withType(Personne.class)
		.withIgnoreLeadingWhiteSpace(true).build();
	// Ajout des elements lu dans la liste
	for (Personne personne : csvToBean) {
	    personnes.add(personne);
	}
	// Fermeture du reader
	reader.close();
	return personnes;
    }

    /**
     * Méthode d'affichage d'une liste de personnes
     *
     * @param personnes : liste de personnes
     */
    public void afficher(List<Personne> personnes) {

	for (Personne p : personnes) {
	    System.out.println("Nom : " + p.getNom());
	    System.out.println("Prenom : " + p.getPrenom());
	    System.out.println("Tel : " + p.getTel());
	    System.out.println("Mail : " + p.getMail());
	    System.out.println("==========================");
	}
    }

    /**
     * Ajout d'une personne dans notre csv
     *
     * @param personne : une personne
     * @throws IOException :
     */
    public void addPersonne(Personne personne) throws IOException {
	// CrÃ©ation du writer en conservant le contenu de notre file
	CSVWriter csvWriter = new CSVWriter(new FileWriter(CSV_FILE_PATH, true));
	csvWriter.writeNext(
		new String[] { personne.getNom(), personne.getPrenom(), personne.getTel(), personne.getMail() });
	csvWriter.close();
    }

    /**
     * Rechercher une personne par son numero de tel
     *
     * @return personne or null si pas trouvé
     * @throws IOException :
     */
    public Personne findByTel() throws IOException {
	Scanner scanner = new Scanner(System.in);
	String telSaisie;
	personnes = readAll();

	do {
	    System.out.println("Veuillez renseigner le numero de tel de la personne  ");
	    telSaisie = scanner.nextLine();
	}

	while (telSaisie == null);

	for (Personne personne : personnes) {
	    if (personne.getTel().equals(telSaisie)) {
		return personne;
	    }
	}
	return null;
    }

    /**
     * Fonction pour ecrire l'entête du fichier et ajouter les modifications.
     *
     * @throws IOException :
     */
    private void writeUpdate() throws IOException {
	// CrÃ©ation du writer en supprimant l'ancien contenu de notre file
	CSVWriter csvWriter = new CSVWriter(new FileWriter(CSV_FILE_PATH, false));
	String[] headerRecord = { "Nom", "Prenom", "tel", "mail" };
	csvWriter.writeNext(headerRecord);

	for (Personne p : personnes) {
	    csvWriter.writeNext(new String[] { p.getNom(), p.getPrenom(), p.getTel(), p.getMail() });
	}
	csvWriter.close();
    }

    /**
     * Update d'une personne
     *
     * @throws IOException :
     */
    public void update() throws IOException {
	Personne personneSearch = findByTel();

	if (personneSearch != null) {

	    Scanner scanner = new Scanner(System.in);
	    System.out.println("veuillez renseigner le nouveau numero pour le modifier ");
	    String newTel = scanner.nextLine();

	    for (Personne p : personnes) {
		if (p.getTel().equals(personneSearch.getTel())) {
		    p.setTel(newTel);
		}
	    }
	    writeUpdate();
	}
    }

    /**
     * Suppression d'une personne dans le fichier CSV et réecriture du fichier a
     * l'aide de writeUpdate()
     *
     * @throws IOException :
     */
    public void deletePersonne() throws IOException {

	Scanner scanner = new Scanner(System.in);
	System.out.println("veuillez renseigner le numero de tel de la personne que vous voulez supprimer ");
	String telSaisie = scanner.nextLine();

	for (int i = 0; i < personnes.size(); i++) {
	    if (personnes.get(i).getTel().equals(telSaisie)) {
		personnes.remove(personnes.get(i));
	    }
	    writeUpdate();
	}
    }

}
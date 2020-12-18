package com.evaluation;

public class Evaluation {

    public static void main(String[] args) {

	Evaluation e = new Evaluation();

	// Tableau d'entiers non trié
	int[] tab = { 12, 8, 6, 1, 45, 3, 16, 0, -6, 128 };
	// Deux tableaux multidimensionnels
	int[][] matriceA = { { 1, 5, 3 }, { 2, 4, 1 }, { 9, 6, 0 } };
	int[][] matriceB = { { 2, 7, 3 }, { 0, 9, 3 }, { 8, 2, 7 } };

	// Exercice 1 : recherche min d'un tableau
	System.out.println("Le minimum du tableau est : " + e.rechercheMin(tab));

	// Exercice 2 : recherche max d'un tableau
	System.out.println("Le maximum du tableau est : " + e.rechercheMax(tab));

	// Exercice 3 : somme pair et impair
	// pair
	System.out.println("La somme de 10 nombre pair est : " + e.sommePair(10));
	// impair
	System.out.println("La somme de 10 nombre impair est : " + e.sommeImpair(10));

	// Exercice 4 : addition de matrice
	e.additionMatrice(matriceA, matriceB);

	// Exercice 5 : multiplication de matrice

	// Exercice 6 : manipuler un CSV
	// --> voir Classes Personne, ServicePersonne et mainOpenCSV

	// Exercice 7 : Selection sort
	int[] tab2 = { 12, 8, 6, 1, 45, 3, 16, 0, -6, 128 };
	System.out.println("--- Avant le tri par selection ---");
	e.afficherTable(tab2);

	System.out.println("--- Après le tri par selection ---");
	e.triParSelection(tab2);
	e.afficherTable(tab2);

	// Exercice 8 : Insertion sort
	int[] tab3 = { 12, 8, 6, 1, 45, 3, 16, 0, -6, 128 };
	System.out.println("--- Avant le tri par insertion ---");
	e.afficherTable(tab3);

	System.out.println("--- Après le tri par insertion ---");
	e.triParInsertion(tab3);
	e.afficherTable(tab3);

	// Exercice 9 : Bubble sort
	int[] tab4 = { 12, 8, 6, 1, 45, 3, 16, 0, -6, 128 };
	System.out.println("--- Avant le tri à bulle ---");
	e.afficherTable(tab4);

	System.out.println("--- Après le tri à bulle ---");
	e.triABulle(tab4);
	e.afficherTable(tab4);

	// Exercice 10 : Merge sort

	// Exercice 11 : Quick sort
	int[] tab5 = { 12, 8, 6, 1, 45, 3, 16, 0, -6, 128 };
	System.out.println("--- Avant le tri rapide ---");
	e.afficherTable(tab5);

	System.out.println("--- Après le tri rapide ---");
	e.triRapide(tab5);
	e.afficherTable(tab5);

	// Exercice 12 : Shell sort
	int[] tab6 = { 12, 8, 6, 1, 45, 3, 16, 0, -6, 128 };
	System.out.println("--- Before shell sort ---");
	e.afficherTable(tab6);

	System.out.println("--- After shell sort ---");
	e.shellSort(tab6);
	e.afficherTable(tab6);

	// Exercice 13 : Binary search
	int[] tab7 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // La recherche dichotomique ne peut se faire que sur un tableau
							// trié
	System.out.println("--- Recherche dichotomique ---");
	e.afficherTable(tab7);
	int valeurRecherchee = 8;
	e.binarySearch(tab7, valeurRecherchee);

	// Exercice 22 : Factorial
	int n = 5;
	e.factoriel(n);

	// Exercice 23 : x(3) power n(5)
	int x = 3;
	e.x_power_n(x, n);

    }

    public void afficherTable(int[] table) {
	for (int i = 0; i < table.length; i++) {
	    System.out.print("|" + table[i] + "| ");
	}
	System.out.println();
    }

    // Exercice 1 : recherche min d'un tableau
    public int rechercheMin(int[] table) {
	int min = table[0];

	for (int i = 0; i < table.length; i++) {

	    if (min > table[i]) {
		min = table[i];
	    }
	}
	return min;
    }

    // Exercice 2 : recherche max d'un tableau
    /**
     * Recherche de la valeur maximale d'un tableau donné
     *
     * @param table d'entier
     * @return la valeur max du tableau
     */
    public int rechercheMax(int[] table) {
	int max = table[0];

	for (int i = 0; i < table.length; i++) {

	    if (max < table[i]) {
		max = table[i];
	    }
	}
	return max;
    }

    // Exercice 3 : Somme pair et impair
    // Somme de n pair
    public int sommePair(int n) {
	int somme = 0;

	for (int i = 1; i <= n; i++) {
	    if (i % 2 == 0) { // Si pair
		somme = somme + i;
	    }
	}
	return somme;
    }

    // Somme de n impair
    public int sommeImpair(int n) {
	int somme = 0;

	for (int i = 1; i <= n; i++) {
	    if (i % 2 != 0) { // Si impair
		somme = somme + i;
	    }
	}
	return somme;
    }

    // Exercice 4 : Addition de matrice
    public void additionMatrice(int[][] matrice1, int[][] matrice2) {
	int longueur = 3;
	int profondeur = 3;
	// Création d'une nouvelle matrice de la même taille pour stocker le resultat
	// des additions
	int[][] resultat = new int[longueur][profondeur];

	System.out.println("La somme des matrices est :");
	for (int i = 0; i < longueur; i++) { // parcours en longueur
	    for (int j = 0; j < profondeur; j++) { // parcours en profondeur
		resultat[i][j] = matrice1[i][j] + matrice2[i][j];
		System.out.print(resultat[i][j] + "   ");
	    }
	    System.out.println(); // retour à la ligne pour une meilleure lisibilité
	}
    }

    // Exercice 7 : Selection sort
    public void triParSelection(int[] table) {

	// Parcourir le tableau
	for (int i = 0; i < table.length - 1; i++) {

	    int index = i; // On bloque l'index pour parcourir et comparer

	    // Parcourir le tableau et comparer les valeurs
	    for (int j = i + 1; j < table.length; j++) {

		if (table[j] < table[index]) {
		    index = j;
		}
	    }

	    int min = table[index];
	    table[index] = table[i];
	    table[i] = min;
	}
    }

    // Exercice 8 : Insertion sort
    public void triParInsertion(int[] table) {

	for (int i = 1; i < table.length; i++) {
	    int index = table[i];
	    int j = i - 1;

	    while (j >= 0 && table[j] > index) {
		table[j + 1] = table[j];
		j--;
	    }
	    table[j + 1] = index;
	}
    }

    // Exercice 9 : tri à bulle
    public void triABulle(int[] tab) {
	int tmp;

	for (int i = 0; i < tab.length; i++) {
	    for (int j = 1; j < tab.length - i; j++) {
		if (tab[j - 1] > tab[j]) {
		    tmp = tab[j - 1];
		    tab[j - 1] = tab[j];
		    tab[j] = tmp;
		}
	    }
	}
    }

    // Exercice 11 : Tri rapide
    public void triRapide(int[] tab) {

	int tmp;

	for (int i = 0; i < tab.length; i++) {
	    for (int j = 0; j < tab.length - 1; j++) {
		if (tab[j] > tab[j + 1]) {
		    tmp = tab[j + 1];
		    tab[j + 1] = tab[j];
		    tab[j] = tmp;
		}
	    }
	}
    }

    // Exercice 12 : Shell sort
    public void shellSort(int[] tab) {
	int n = tab.length;

	for (int gap = n / 2; gap > 0; gap /= 2) {
	    for (int i = gap; i < n; i++) {
		int key = tab[i];
		int j = i;
		while (j >= gap && tab[j - gap] > key) {
		    tab[j] = tab[j - gap];
		    j -= gap;
		}
		tab[j] = key;
	    }
	}
    }

    // Exercice 13 : Binary search
    private void binarySearch(int[] tab, int valeurRecherchee) {
	int lastElement = tab.length - 1;
	int firstElement = tab[0];
	int middle = (firstElement + lastElement) / 2;
	while (firstElement <= lastElement) {
	    if (tab[middle] < valeurRecherchee) { // On divise le tableau en 2 et on parcourt la partie qui contient la
						  // valeur qu'on recherche
		firstElement = middle + 1;
	    } else if (tab[middle] == valeurRecherchee) {
		System.out.println("La valeur qu'on recherche (" + valeurRecherchee + ") se trouve à l'index " + middle
			+ " dans le tableau");
		break; // Puisqu'on a trouvé la valeur on peut arrêter la boucle while
	    } else {
		lastElement = middle - 1;
	    }
	    middle = (firstElement + lastElement) / 2; // On redéfinit le milieu par rapport à la partie du tableau
						       // qu'on garde
	}
	if (firstElement > lastElement) {
	    System.out.println("La valeur recherchée n'existe pas");
	}
    }

    // Exercice 22 : Factorial
    public void factoriel(int n) {
	int resultat = 1;
	for (int i = 1; i <= n; i++) {
	    resultat = resultat * i;
	}
	System.out.println("La factorielle de " + n + " est " + resultat);
    }

    // Exercice 23 : x power n
    public void x_power_n(int x, int n) {
	int resultat = 0;
	resultat = (int) Math.pow(x, n);
	System.out.println("La puissance de " + x + " sur " + n + " = " + resultat);
    }

}

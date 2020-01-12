package uf1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ConsultarCotxes {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		escriureFitxer();
		menu();

	}

	public static void menu() throws ClassNotFoundException, IOException {
		boolean sortir = false;

		while (!sortir) {
			System.out.println("Introdueix una opció:");
			System.out.println("1.Afegir un cotxe 2.Consultar cotxes 3.Buscar cotxe 4.Sortir");
			int opcio = 0;
			try {
				opcio = scan.nextInt();
			} catch (Exception e) {
				System.err.println("Introdueix un numero enter");
			}

			if (opcio == 1) {

				afegirCotxe();

			} else if (opcio == 2) {

				llegirFitxer();

			} else if (opcio == 3) {

				buscarCotxe();

			} else if (opcio == 4) {

				sortir = true;

			} else {
				System.err.println("Introdueix el numero corresponent.\n");
			}
		}
	}

	public static void afegirCotxe() throws IOException, ClassNotFoundException {
		//Camp variable tipus Cotxe
		Cotxe cotxe;
		//Declaració del fitxer
		File fitxer = new File("cotxesObject.txt");
		//Crea el flux de sortida
		FileOutputStream fileout = new FileOutputStream(fitxer, true);
		//Connectar el flux de bytes al flux de dades
		ObjectOutputStream dataOuCotxes = new ObjectOutputStream(fileout);

		System.out.print("Introdueix la marca: ");
		String marca = scan.next();
		System.out.print("\nIntrodueix la model: ");
		String model = scan.next();
		System.out.print("\nIntrodueix l'any: ");
		String any = scan.next();
		System.out.println("\nIntrodueix la matricula: ");
		String matricula = scan.next();

		cotxe = new Cotxe(marca, model, any, matricula);
		dataOuCotxes.writeObject(cotxe);//L'escriu al fixer
		dataOuCotxes.close();
		fileout.close();

	}

	public static void buscarCotxe() throws IOException, ClassNotFoundException {

		//Camp variable tipus Cotxe
		Cotxe cotxes;
		//Declaració del fitxer
		File fitxer = new File("cotxesObject.txt");
		//Crea el flux d'entrada
		FileInputStream filein = new FileInputStream(fitxer);
		//Connectar el flux de bytes al flux de dades
		ObjectInputStream dataInCotxes = new ObjectInputStream(filein);

		boolean sortir = false;

		while (!sortir) {
			System.out.println("Buscar per:");
			System.out.println("1.Marca 2.Model 3.Any 4.Matricula 5.Sortir");
			int opcio = 0;
			String paraula = "";
			try {
				opcio = scan.nextInt();
				System.out.println("Introdueix una paraula per fer la cerca");
				paraula = scan.next();
			} catch (Exception e) {
				System.err.println("Introdueix els valors corresponents");
			}

			if (opcio == 1) {

				try {
					while (true){//Llegeix el fitxer
						//Llegeix la comarca
						cotxes = (Cotxe) dataInCotxes.readObject();
						if (paraula.equals(cotxes.getMarca())) {
							System.out.println("Marca: " + cotxes.getMarca() +
									"	Model: "+ cotxes.getModel() +
									"	Any: " + cotxes.getAny() +
									"	Matricula: " + cotxes.getMatricula());
						}
					}
				} catch (EOFException eo) {}
				dataInCotxes.close();//Tanca el stream d'entrada
				filein.close();

			} else if (opcio == 2) {

				try {
					while (true){//Llegeix el fitxer
						//Llegeix la comarca
						cotxes = (Cotxe) dataInCotxes.readObject();
						if (paraula.equals(cotxes.getModel())) {
							System.out.println("Marca: " + cotxes.getMarca() +
									"	Model: "+ cotxes.getModel() +
									"	Any: " + cotxes.getAny() +
									"	Matricula: " + cotxes.getMatricula());
						}
					}
				} catch (EOFException eo) {}
				dataInCotxes.close();//Tanca el stream d'entrada
				filein.close();

			} else if (opcio == 3) {

				try {
					while (true){//Llegeix el fitxer
						//Llegeix la comarca
						cotxes = (Cotxe) dataInCotxes.readObject();
						if (paraula.equals(cotxes.getAny())) {
							System.out.println("Marca: " + cotxes.getMarca() +
									"	Model: "+ cotxes.getModel() +
									"	Any: " + cotxes.getAny() +
									"	Matricula: " + cotxes.getMatricula());
						}
					}
				} catch (EOFException eo) {}
				dataInCotxes.close();//Tanca el stream d'entrada
				filein.close();

			} else if (opcio == 4) {

				try {
					while (true){//Llegeix el fitxer
						//Llegeix la comarca
						cotxes = (Cotxe) dataInCotxes.readObject();
						if (paraula.equals(cotxes.getMatricula())) {
							System.out.println("Marca: " + cotxes.getMarca() +
									"	Model: "+ cotxes.getModel() +
									"	Any: " + cotxes.getAny() +
									"	Matricula: " + cotxes.getMatricula());
						}
					}
				} catch (EOFException eo) {}
				dataInCotxes.close();//Tanca el stream d'entrada
				filein.close();

			} else if (opcio == 5){

				sortir = true;

			} else {
				System.err.println("Introdueix el numero corresponent.\n");
			}
		}

	}

	public static void escriureFitxer() throws IOException {
		//Camp variable tipus Cotxe
		Cotxe cotxe;
		//Declaració del fitxer
		File fitxer = new File("cotxesObject.txt");
		//Crea el flux de sortida
		FileOutputStream fileout = new FileOutputStream(fitxer);
		//Connectar el flux de bytes al flux de dades
		ObjectOutputStream dataOuCotxes = new ObjectOutputStream(fileout);
		//Les dades per generar els objectes Comarca
		String marca[] = {"Cotxe1", "Cotxe2", "Cotxe3", "Cotxe4", "Cotxe5", "Cotxe6", "Cotxe7", "Cotxe8", "Cotxe9"};
		String model[] = {"Model1", "Model2", "Model3", "Model4", "Model5", "Model6", "Model7", "Model8", "Model9"};
		String any[] = {"2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"};
		String matricula[] = {"0001ABC", "0002ABC", "0003ABC", "0001DEF", "0002DEF", "0003DEF", "0001GHI", "0002GHI", "0003GHI"};
		//Recorre els arrays
		for (int i=0; i<marca.length; i++){//Crea la comarca
			cotxe = new Cotxe(marca[i], model[i], any[i], matricula[i]);
			dataOuCotxes.writeObject(cotxe);//L'escriu al fixer
		}
		dataOuCotxes.close();//Tanca el stream de sortida
		fileout.close();

	}

	public static void llegirFitxer() throws IOException, ClassNotFoundException {
		//Camp variable tipus Cotxe
		Cotxe cotxes;
		//Declaració del fitxer
		File fitxer = new File("cotxesObject.txt");
		//Crea el flux d'entrada
		FileInputStream filein = new FileInputStream(fitxer);
		//Connectar el flux de bytes al flux de dades
		ObjectInputStream dataInCotxes = new ObjectInputStream(filein);

		try {
			while (true){//Llegeix el fitxer
				//Llegeix la comarca
				cotxes = (Cotxe) dataInCotxes.readObject();
				System.out.println("Marca: " + cotxes.getMarca() +
						"	Model: "+ cotxes.getModel() +
						"	Any: " + cotxes.getAny() +
						"	Matricula: " + cotxes.getMatricula());
			}
		} catch (EOFException eo) {}
		dataInCotxes.close();//Tanca el stream d'entrada
		filein.close();
	}
}

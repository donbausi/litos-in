package mengenrechner;

import java.io.*;

/**
 * Die Klasse In dient zum Einlesen von Daten über Klassenmethoden bis Eingabe
 * und Ausgabe (input output kurz IO) im 2. Semester behandelt werden.
 * Dann werden die Mängel der In Klasse besprochen und diese verbessert.<br>
 * <br>
 * Folgende globale Klassenvariable ist implementiert: private static BufferedReader tastatur <br>
 * <br>
 * Die Klassenmethoden ermöglichen das Einlesen der einfachen Datentypen 
 * und einer Zeichenkette (String) von Konsole, Diee Methoden sind nach folgendem Schema benannt:
 * readDatentyp.<br>
 * <br>
 * Der Eingabestrom wird nicht geschlossen, damit mehrere Methoden gleichzeitig eingesetzt werden können. 
 * Deshalb auch die globale Klassenvariablen! <br>
 * 
 * @author Gabriele Schmidt
 * @version 1.2
 * 
 */

public class In {

	private static BufferedReader tastatur = new BufferedReader(new InputStreamReader(
			System.in));
	
	
	/**
	 * Methode zum Einlesen eines Byte<br>
	 * 
	 * Sollte das Einlesen nicht erfolgreich sein, wird auf der Konsole eine
	 * Fehlermeldung ausgegeben und als Wert 0 zurückgegeben.<br>
	 * 
	 * @return wert
	 */
	public static byte readByte() {

		byte wert = 0;

		if (tastatur != null) { // Erzeugung überprüfen
			try {
				try {
					wert = Byte.parseByte(tastatur.readLine());
				} catch (NumberFormatException e) {
					System.out.println(e);
					wert = 0;
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		} else {
			System.out
					.println("Es konnte nichts eingelesen werden! Rückgabewert 0!");
		}
		return wert;
	}

	/**
	 * Methode zum Einlesen eines Charakter (eines Zeichens)<br>
	 * 
	 * Sollte das Einlesen nicht erfolgreich sein, wird auf der Konsole eine
	 * Fehlermeldung ausgegeben und als Wert 0 zurückgegeben. <br>
	 * 
	 * Wurde eine Zeichenkette eingegeben wird nur das erste Zeichen zurückgegeben.
	 * 
	 * @return wert
	 */
	public static char readChar() {

		char c = '0';
		char cArray[];

		if (tastatur != null) { // Erzeugung überprüfen
			try {
				try {
					cArray = tastatur.readLine().toCharArray();
					switch (cArray.length) {
					case 0:
						System.out
								.println("Kein Zeichen! Es wird Null zurückgegeben.");
						break;
					case 1:
						c = cArray[0];
						break;
					default:
						System.out
								.println("Zeichenkette! Es wird das erste Zeichen zurückgegeben.");
						c = cArray[0];
						break;
					}
				} catch (NumberFormatException e) {
					System.out.println(e);
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		} else {
			System.out
					.println("Es konnte nichts eingelesen werden! Rückgabewert 0!");
		}
		return c;
	}
	
	/**
	 * Methode zum Einlesen eines Short<br>
	 * 
	 * Sollte das Einlesen nicht erfolgreich sein, wird auf der Konsole eine
	 * Fehlermeldung ausgegeben und als Wert 0 zurückgegeben.<br>
	 * 
	 * @return wert
	 */
	public static short readShort() {

		short wert = 0;

		if (tastatur != null) { // Erzeugung überprüfen
			try {
				try {
					wert = Short.parseShort(tastatur.readLine());
				} catch (NumberFormatException e) {
					System.out.println(e);
					wert = 0;
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		} else {
			System.out
					.println("Es konnte nichts eingelesen werden! Rückgabewert 0!");
		}
		return wert;
	}

	/**
	 * Methode zum Einlesen eines Integer<br>
	 * 
	 * Sollte das Einlesen nicht erfolgreich sein, wird auf der Konsole eine
	 * Fehlermeldung ausgegeben und als Wert 0 zurückgegeben.<br>
	 * 
	 * @return wert
	 */
	public static int readInt() {

		int wert = 0;

		if (tastatur != null) { // Erzeugung überprüfen
			try {
				try {
					wert = Integer.parseInt(tastatur.readLine());
				} catch (NumberFormatException e) {
					System.out.println(e);
					wert = 0;
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		} else {
			System.out
					.println("Es konnte nichts eingelesen werden! Rückgabewert 0!");
		}
		
		return wert;
	}
	
	/**
	 * Methode zum Einlesen eines Long<br>
	 * 
	 * Sollte das Einlesen nicht erfolgreich sein, wird auf der Konsole eine
	 * Fehlermeldung ausgegeben und als Wert 0 zurückgegeben.<br>
	 * 
	 * @return wert
	 */
	public static long readLong() {

		long wert = 0;

		if (tastatur != null) { // Erzeugung überprüfen
			try {
				try {
					wert = Long.parseLong(tastatur.readLine());
				} catch (NumberFormatException e) {
					System.out.println(e);
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		} else {
			System.out
					.println("Es konnte nichts eingelesen werden! Rückgabewert 0!");
		}
		return wert;
	}

	/**
	 * Methode zum Einlesen eines Float<br>
	 * 
	 * Sollte das Einlesen nicht erfolgreich sein, wird auf der Konsole eine
	 * Fehlermeldung ausgegeben und als Wert 0 zurückgegeben.<br>
	 * 
	 * @return wert
	 */
	public static float readFloat() {

		float wert = 0.0f;

		if (tastatur != null) { // Erzeugung überprüfen
			try {
				try {
					wert = Float.parseFloat(tastatur.readLine());
				} catch (NumberFormatException e) {
					System.out.println(e);
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		} else {
			System.out
					.println("Es konnte nichts eingelesen werden! Rückgabewert 0!");
		}
		return wert;
	}

	/**
	 * Methode zum Einlesen eines Doublet<br>
	 * 
	 * Sollte das Einlesen nicht erfolgreich sein, wird auf der Konsole eine
	 * Fehlermeldung ausgegeben und als Wert 0 zurückgegeben.<br>
	 * 
	 * @return wert
	 */
	public static double readDouble() {

		double wert = 0.0;

		if (tastatur != null) { // Erzeugung überprüfen
			try {
				try {
					wert = Double.parseDouble(tastatur.readLine());
				} catch (NumberFormatException e) {
					System.out.println(e);
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		} else {
			System.out
					.println("Es konnte nichts eingelesen werden! Rückgabewert 0!");
		}
		return wert;
	}

	/**
	 * Methode zum Einlesen eines String<br>
	 * 
	 * Sollte das Einlesen nicht erfolgreich sein, wird auf der Konsole eine
	 * Fehlermeldung ausgegeben und als Wert null zurückgegeben.<br>
	 * 
	 * @return wert
	 */
	public static String readString() {

		String s = null;

		if (tastatur != null) { // Erzeugung überprüfen
			try {
				s = tastatur.readLine();
			} catch (IOException e) {
				System.out.println(e);
			}
		} else {
			System.out
					.println("Es konnte nichts eingelesen werden! Rückgabewert null!");
		}
		return s;
	}

}
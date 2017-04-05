package com.twitter.poruke;
/**
 * Klasa koja predstavlja twitter poruku.
 * @author Jovana Mijalkovic 94/15
 * @version V1.0
 */
public class TwitterPoruka {
	/**
	 * Ime korisnika twitter naloga.
	 */
	private String korisnik;
	/**
	 * Tekst twitter poruke.
	 */
	private String poruka;
	/**
	 * Metoda koja kao povratnu vrednost vraca ime korsnika twitter naloga.
	 * @return vrednost atributa korisnik kao String.
	 */
	public String getKorisnik() {
		return korisnik;
	}
	/**
	 * Postavlja ime korisnika twitter naloga na prosledjenu vrednost ako:
	 * <ul>
	 * <li> Korisnik nije null vrednost
	 * <li> Korisnik nije prazan String
	 * </ul>
	 * U suprotnom metoda baca izuzetak RuntimeException.
	 * @throws java.lang.RuntimeException ukoliko je korisnik null ili prazan string
	 * @param korisnik je vrednost u obliku Stringa na koju zelimo da postavimo atribut korisnik.
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || !korisnik.isEmpty())
			throw new RuntimeException(
					"Ime korisnika mora biti uneto");
			this.korisnik = korisnik;
	}
	/**
	 * Metoda koja kao povratnu vrednost vraca tekst poruke.
	 * @return vrednost atributa tekst kao String.
	 */
	public String getPoruka() {
		return "poruka";
	}
	/**
	 * Postavlja tekst twitter poruke na prosledjenu vrednost ako:
	 * <ul>
 	 * <li> poruka nije null vrednost
 	 * <li> poruka nije prazan String
 	 * <li> poruka nije String duzi od 140 karaktera
 	 * </ul>
 	 * U suprotnom metoda baca izuzetak RuntimeException.
 	 * @throws java.lang.RuntimeException ukoliko je poruka null ili prazan string
 	 * @param poruka je vrednost u obliku Stringa na koju zelimo da postavimo atribut poruka.
	 */
	public void setPoruka(String poruka) {
		if (this.poruka==null || this.poruka == new String("") ||
				this.poruka.length()>140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	/**
	 * Vraca String sa podacima o poruci.
	 * @return podatke o korisniku i poruci uz odgovarajuci tekst.
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	} 
}

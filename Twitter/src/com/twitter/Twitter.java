package com.twitter;
	import java.util.LinkedList;
	import com.twitter.poruke.TwitterPoruka;
	/**
	 * Ova klasa predstavlja Twitter koji sadrzi listu twitter poruka.
	 * @author Jovana Mijalkovic 94/15
	 * @version V2.0
	 */
public class Twitter {
	/**
	 * Lista twitter poruka.
	 */
	private LinkedList<TwitterPoruka> poruke =
	new LinkedList<TwitterPoruka>();
	/**
	 * Metoda koja kao povratnu vrednost vraca listu sa svim twitter porukama.
	 * @return lista koja sadrzi TwitterPoruke.
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	/**
	 * Metoda koja unosi twitter poruke na kraj liste. Metoda kao ulazne parametre prima ime korisnika i tekst poruke
	 * i pravi novi objekat TwitterPoruka.
	 * @param korisnik ime korisnika kao String vrednost
	 * @param poruka tekst poruke kao String vrednost.
	 */
	public void unesi(String korisnik, String poruka) {
	//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
	//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	/**
	 * Ova metoda pretrazuje listu twitter poruka i trazi sve twitter poruke koje sadrze odredjeni 
	 * tag koji je dat u vidu parametra. Zatim ih unosi u niz ciji je kapacitet prosledjen kao parametar
	 * u vidu celog broja maxBroj.Nakon pretrage metoda vraca rezultat u obliku niza objekata TwitterPoruka.
	 * @param maxBroj ceo broj maxBroj koji predstavlja kapacitet niza,odnosno maksimalni broj poruka koje mozemo pronaci.
	 * @param tag String tag koji predstavlja naziv taga koji zelimo da pronadjemo u twitter porukama
	 * @return niz objekata TwitterPoruka u kom se nalaze sve twitter poruke koje sadrze prosledjeni tag.
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
	//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
	 //Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
	//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
	//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
	//Pretrazuju se poruke i traze se one koje sadrze tag.
	//Ako se nadje neka takva, i ako nije prekoracen maxBroj
	//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
	//se prekida.
		for (int i = 0; i < poruke.size(); i++){
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1){
				if (brojac < maxBroj){
					rezultat[brojac]=poruke.get(i);
					brojac++;
				}
				else break;
			}
		}
		return rezultat;
	} 
}

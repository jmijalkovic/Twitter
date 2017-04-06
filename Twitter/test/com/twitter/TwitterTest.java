package com.twitter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	Twitter t;
	
	@Before
	public void setUp() throws Exception {
		t=new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t=null;
	}

	@Test
	public void testVratiSvePoruke() {
		TwitterPoruka tp=new TwitterPoruka();
		tp.setKorisnik("joja");
		tp.setPoruka("poy");
		t.unesi(tp.getKorisnik(), tp.getPoruka());
		assertEquals("joja", t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("poy",t.vratiSvePoruke().getLast().getPoruka());
	}

	@Test
	public void testUnesi() {
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("Joja");
		tp.setPoruka("Poy");
		t.unesi(tp.getKorisnik(), tp.getPoruka());
		assertEquals("Joja",t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals("Poy",t.vratiSvePoruke().getLast().getPoruka());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() {
		t.vratiPoruke(100, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazan() {
		t.vratiPoruke(100, "");
	}
	
	@Test
	public void testVratiPoruke0() {
		assertEquals(t.vratiPoruke(0, "poy").length, 100);
	}
	@Test
	public void testVratiPoruke() {
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("Joja");
		tp.setPoruka("Poy poy");
		t.unesi(tp.getKorisnik(), tp.getPoruka());
		assertEquals(tp,t.vratiPoruke(1, "poy")[0]);
	}
	@Test
	 public void testVratiPorukePrekoracenje() {
	 	TwitterPoruka tp = new TwitterPoruka();
	 	tp.setKorisnik("Joja");
	 	tp.setPoruka("Poy poy");
	 	TwitterPoruka tp1 = new TwitterPoruka();
	 	tp1.setKorisnik("Aleks");
	 	tp1.setPoruka("Poy poy");
	 	t.unesi(tp.getKorisnik(), tp.getPoruka());
	 	t.unesi(tp1.getKorisnik(), tp1.getPoruka());
	 	assertEquals(tp, t.vratiPoruke(1, "poy")[0]);
	 }
	
	@Test
	 public void testVratiPorukeNekoliko() {
	 	TwitterPoruka tp = new TwitterPoruka();
	 	tp.setKorisnik("Joja");
	 	tp.setPoruka("Poy poy");
	 	TwitterPoruka tp1 = new TwitterPoruka();
	 	tp1.setKorisnik("Aleks");
	 	tp1.setPoruka("Poy poy");
	 	TwitterPoruka tp2 = new TwitterPoruka();
	 	tp2.setKorisnik("Katarina");
	 	tp2.setPoruka("Engleski2");
	 	t.unesi(tp.getKorisnik(), tp.getPoruka());
	 	t.unesi(tp1.getKorisnik(), tp1.getPoruka());
	 	t.unesi(tp2.getKorisnik(), tp2.getPoruka());
	 	TwitterPoruka[] niz = new TwitterPoruka[10];
	 	niz[0]=tp;
	 	niz[1]=tp1;
	 	assertArrayEquals(niz, t.vratiPoruke(10, "poy"));
	 }
	
}

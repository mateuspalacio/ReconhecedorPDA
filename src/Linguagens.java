import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import pda.automata.IPDA;
import pda.automata.IState;
import pda.automata.lib.PDA;

public class Linguagens {// PDA = (Q, Σ, δ, {qi}, F)
	public static void main(String linguagem) throws Exception {
		char[] sigma = " abcdefghijklmnopqrstuvxywz0123456789".toCharArray();
		System.out.println("*****************************\nProcessamento de linguagem");
		IState q = new State("q");
		IState qm = new State("qm");
		IState qa = new State("qa");
		IState qi = new State("qi");
		IState qn = new State("qn");
		IState qf = new State("qf");
		IState qw = new State("qw");
		IState qh = new State("qh");
		IState ql = new State("ql");
		IState qe = new State("qe");
		IState qo = new State("qo");
		IState qr = new State("qr");

		IState qOpenMain = new State("qOpenMain");
		IState qCloseMain = new State("qCloseMain");

		IState qOpenPar = new State("qOpenPar");
		IState t0 = new State("t0");
		IState t1 = new State("t1");
		IState t2 = new State("t2");
		IState t3 = new State("t3");
		IState t4 = new State("t4");


		IState qt = new State("qt");

		IState qb = new State("qb");


		IState qname = new State("qname");
		IState qnamee = new State("qnamee");
		IState qdef = new State("qdef");
		IState qover = new State("qover");

		IState qequals = new State("q=");

		IState qaa = new State("qaa");
		IState qI = new State("q;");
		IState qaaa = new State("qaaa");
		IState qII = new State("q;;");
		IState qaaaa = new State("qaaaa");

		IState qp = new State("q+");
		IState qpp = new State("q++");
		IState qdentro = new State("qdentro");
		IState qClosePar = new State("qClosePar");
		IState qOpenKey = new State("qOpenKey");
		IState qCloseKey = new State("qCloseKey");
		IState qif = new State("qif");
		List<IState> qs = Arrays.asList(q,qm,qa, qi, qn,qOpenPar,t0,t1,t2,t3,t4,qClosePar,qOpenKey,qCloseKey,qif);
		qif.setFinal();

		q.addTransition(qm, null, null, '$');
		qm.addTransition(qa, 'm', null, null);
		qa.addTransition(qi, 'a', null, null);
		qi.addTransition(qn, 'i', null, null);
		qn.addTransition(qOpenPar, 'n', null, null);
		qOpenPar.addTransition(qdentro, '(', null, null);

		qdentro.addTransition(qClosePar, ')', null, null);


		qClosePar.addTransition(qdentro, '{', null, '{');
		qdentro.addTransition(qw, null, null, '$');
		qdentro.addTransition(qf, null, null, '$');
		qdentro.addTransition(qi, null, null, '$');
		qdentro.addTransition(qCloseMain, '}', '{', null);
		qi.addTransition(qn, 'i', null, null);
		qi.addTransition(qb, 'b', null, null);
		qb.addTransition(qo, 'o', null, null);
		qo.addTransition(qo, 'o', null, null);
		qo.addTransition(ql, 'l', null, null);
		ql.addTransition(qe, 'e', null, null);
		qe.addTransition(qa, 'a', null, null);
		qa.addTransition(qname, 'n', null, null);

		qn.addTransition(qt, 'n', null, null);

		qt.addTransition(qname, 't', null, null);
		for(char c : sigma)
			qname.addTransition(qnamee, c, null, null);
		for(char c : sigma)
			qnamee.addTransition(qnamee, c, null, null);
		qnamee.addTransition(qequals, '=', null, null);
		qnamee.addTransition(qI, ';', null, null);
		for(char c : sigma)
			qequals.addTransition(qdef, c, null, null);
		for(char c : sigma)
			qdef.addTransition(qdef, c, null, null);
		qdef.addTransition(qI, ';', null, null);

		qI.addTransition(qn, 'i', null, null);
		qI.addTransition(qb, 'b', null, null);
		qI.addTransition(qover, null, '$', null);
		qover.addTransition(qw, null, null, '$');
		qover.addTransition(qi, null, null, '$');
		qover.addTransition(qf, null, null, '$');
		qover.addTransition(qif, null, null, '$');
		qw.addTransition(qh, 'w', null, null);
		qh.addTransition(qi, 'h', null, null);
		qi.addTransition(ql, 'i', null, null);
		ql.addTransition(qe, 'l', null, null);
		qe.addTransition(qOpenPar, 'e', null, null);
		qOpenPar.addTransition(t0, '(', null, null);
		t1.addTransition(t2, '=', null, null);
		t1.addTransition(qClosePar, ')', null, null);
		t2.addTransition(t3, '=', null, null);
		qCloseKey.addTransition(qCloseKey, '}', '{', null);
		qCloseKey.addTransition(qw, null, null, '$');
		qCloseKey.addTransition(qf, null, null, '$');
		qCloseKey.addTransition(qi, null, null, '$');
		//qCloseKey.addTransition(qCloseMain, '}', '{', null);
		qf.addTransition(qo, 'f', null, null);
		qo.addTransition(qr, 'o', null, null);
		qr.addTransition(qOpenPar, 'r', null, null);
		qOpenPar.addTransition(qa, '(', null, null);
		for(char c : sigma)
			qa.addTransition(qaa, c, null, null);
		for(char c : sigma)
			qaa.addTransition(qaa, c, null, null);
		qaa.addTransition(qI, ';', null, null);

		for(char c : sigma)
			qI.addTransition(qaaa, c, null, null);
		for(char c : sigma)
			qaaa.addTransition(qaaa, c, null, null);

		qaaa.addTransition(qII, ';', null, null);
		for(char c : sigma)
			qII.addTransition(qaaaa, c, null, null);
		for(char c : sigma)
			qaaaa.addTransition(qaaaa, c, null, null);
		qaaaa.addTransition(qp, '+', null, null);
		qp.addTransition(qpp, '+', null, null);
		qpp.addTransition(qClosePar, ' ', null
				, null);

		qpp.addTransition(qClosePar, ')', null, null);
		qpp.addTransition(qClosePar, ' ', null
				, null);
		qClosePar.addTransition(qOpenKey, '{', null, '{');
		qOpenKey.addTransition(qOpenKey, '{', null, '{');

		qdentro.addTransition(qCloseKey, '}', null, null);
		qOpenKey.addTransition(qCloseKey, '}', '{', null);
		qi.addTransition(qf, 'i', null, null);
		qf.addTransition(qOpenPar, 'f', null, null);
		qOpenPar.addTransition(t0, '(', null, null);
		t1.addTransition(t2, '=', null, null);
		t1.addTransition(qClosePar, ')', null, null);
		t2.addTransition(t3, '=', null, null);

		t4.addTransition(qClosePar, ')', null, null);

		qClosePar.addTransition(qOpenKey, '{', null, '{');
		qOpenKey.addTransition(qOpenKey, '{', null, '{');

		qdentro.addTransition(qCloseKey, '}', null, null);
		qOpenKey.addTransition(qCloseKey, '}', '{', null);
		qCloseKey.addTransition(qCloseKey, ' ', '$', null);
		qCloseKey.addTransition(qw, '}', null, null);
		qCloseKey.addTransition(qi, '}', null, null);
		qCloseKey.addTransition(qf, '}', null, null);
		qCloseKey.addTransition(qCloseMain, '}', null, null);

		qCloseMain.addTransition(qif, null, '$', null);

		for (char c : sigma) {
			t0.addTransition(t1, c, null, null);
			t1.addTransition(t1, c, null, null);
			t3.addTransition(t4, c, null, null);
			t4.addTransition(t4, c, null, null);
			qOpenKey.addTransition(qOpenKey, c, null, null); //para aceitar quarquer simbolo do alfabeto depois de {
		}
		for(IState s: qs) {
			s.addTransition(s, '\n', null, null);
		}
		// aceitar espacos
		qClosePar.addTransition(qClosePar, ' ', null, null);
		qOpenPar.addTransition(qOpenPar, ' ', null, null);
		qCloseKey.addTransition(qCloseKey, ' ', null, null);

		String w = "main(){" +
				"int identificador1;" +
				"int identificador2 = 1;" +
				"boolean teste1;" +
				"boolean teste2 = true;" +
				"if(teste){" +
				"if(teste==true){}" +
				"}" +
				"while(teste){" +
				"if(a==b){}" +
				"}" +
				"for(identificador;teste;identificador++){}" +
				"}";
		IPDA pda = new PDA(q);
		pda.makeLog();
		Util.checkout(pda.run(linguagem),linguagem);
		System.out.println("*****************************");
	}
	public static void se() throws Exception {
		char[] sigma = " abcdefghijklmnopqrstuvxywz".toCharArray();
		System.out.println("*****************************\nProcessamento de linguagem");
		IState q = new State("q");
		IState qi = new State("qi");
		IState qf = new State("qf");
		IState qOpenPar = new State("qOpenPar");
		IState t0 = new State("t0");
		IState t1 = new State("t1");
		IState t2 = new State("t2");
		IState t3 = new State("t3");
		IState t4 = new State("t4");
		IState qClosePar = new State("qClosePar");
		IState qOpenKey = new State("qOpenKey");
		IState qCloseKey = new State("qCloseKey");
		IState qif = new State("qif");
		List<IState> qs = Arrays.asList(q,qi,qf,qOpenPar,t0,t1,t2,t3,t4,qClosePar,qOpenKey,qCloseKey,qif);
		qif.setFinal();
		
		q.addTransition(qi, null, null, '$');
		qi.addTransition(qf, 'i', null, null);
		qf.addTransition(qOpenPar, 'f', null, null);
		qOpenPar.addTransition(t0, '(', null, null);
		t1.addTransition(t2, '=', null, null);
		t1.addTransition(qClosePar, ')', null, null);
		t2.addTransition(t3, '=', null, null);
		
		t4.addTransition(qClosePar, ')', null, null);
		
		qClosePar.addTransition(qOpenKey, '{', null, '{');
		qOpenKey.addTransition(qOpenKey, '{', null, '{');
		
		qOpenKey.addTransition(qCloseKey, '}', '{', null);
		qOpenKey.addTransition(qf, 'i', null, null);

		t4.addTransition(qClosePar, ')', null, null);


		qClosePar.addTransition(qOpenKey, '{', null, '{');
		qOpenKey.addTransition(qOpenKey, '{', null, '{');

		qOpenKey.addTransition(qCloseKey, '}', '{', null);
		qOpenKey.addTransition(qf, 'i', null, null);

		qCloseKey.addTransition(qCloseKey, '}', '{', null);
		qCloseKey.addTransition(qif, null, '$', null);
		qCloseKey.addTransition(qif, null, '$', null);
		
		for (char c : sigma) {
			t0.addTransition(t1, c, null, null);
			t1.addTransition(t1, c, null, null);
			t3.addTransition(t4, c, null, null);
			t4.addTransition(t4, c, null, null);
			qOpenKey.addTransition(qOpenKey, c, null, null); //para aceitar quarquer simbolo do alfabeto depois de {
		}
		for(IState s: qs) { 
			s.addTransition(s, '\n', null, null); 
		}
		// aceitar espacos
		qClosePar.addTransition(qClosePar, ' ', null, null);
		qOpenPar.addTransition(qOpenPar, ' ', null, null);
		qCloseKey.addTransition(qCloseKey, ' ', null, null);
		
		String w = "if(teste) {"
				 + "  if(teste==true){  faco algo }"
				 + "}";
		
		IPDA pda = new PDA(q);
		pda.makeLog();
		Util.checkout(pda.run(w),w);
		System.out.println("*****************************");
	}
	public static void se2() throws Exception {
		System.out.println("*******************************");
		char[] vetor = "abcdefghijklmnopqrstuvxywz".toCharArray();
		IState q0 = new State("q0");
		IState qi = new State("qi");
		IState qf = new State("qf");
		IState qC = new State("q(");
		IState qa = new State("qa");
		IState qaa = new State("qaa");
		IState qI = new State("q=");
		IState qII = new State("q==");
		IState qaaa = new State("qaaa");
		IState qCC = new State("q)");
		IState qK = new State("q{");
		IState qKK = new State("q}");
		IState IF = new State("IF");
		IState qCB = new State("qCB");

		IF.setFinal();
		q0.addTransition(qi, null, null, '$');
		qi.addTransition(qf, 'i', null, null);
		qf.addTransition(qC, 'f', null, null);

		qC.addTransition(qa, '(', null, null);
		qa.addTransition(qa, ' ', null, null);

		for(char c : vetor)
			qa.addTransition(qaa, c, null, null);

		for(char c : vetor)
			qaa.addTransition(qaa, c, null, null);


		qaa.addTransition(qCC, ')', null, null);

		qaa.addTransition(qCB, ' ', null, null);
		qCB.addTransition(qCB, ' ', null, null);
		qCB.addTransition(qCC, ')', null, null);

		qCC.addTransition(qK, '{', null, '{');

		qaa.addTransition(qI, '=', null, null);
		qI.addTransition(qII, '=', null, null);

		for(char c : vetor)
			qII.addTransition(qaaa, c, null, null);

		qaaa.addTransition(qCC, ')', null, null);
		qaaa.addTransition(qCB, ' ', null, null);
		for(char c : vetor)
			qaaa.addTransition(qaaa, c, null, null);

		for(char c : vetor)
			qK.addTransition(qK, c, null, null);

		qK.addTransition(qK, '{', null, '{');
		qK.addTransition(qf, 'i', null, null);
		qK.addTransition(qKK, '}', '{', null);

		qKK.addTransition(qKK, '}', '{', null);

		qKK.addTransition(IF, null, '$', null);
		qCB.addTransition(qI, '=', null, null);
		qII.addTransition(qII, ' ', null, null);

		String w = "if( ab  == unifor ){if( ddd==a ){}}";

		IPDA pda = new PDA(q0);
		pda.makeLog();
		Util.checkout(pda.run(w), w);
		System.out.println("*******************************");
	}

	public static void enquanto(String input) throws Exception {
		char[] sigma = " abcdefghijklmnopqrstuvxywz".toCharArray();
		System.out.println("*****************************\nProcessamento de linguagem");
		IState q = new State("q");
		IState qi = new State("qi");
		IState qf = new State("qf");
		IState qw = new State("qw");
		IState qh = new State("qh");
		IState ql = new State("ql");
		IState qe = new State("qe");
		IState qOpenPar = new State("qOpenPar");
		IState t0 = new State("t0");
		IState t1 = new State("t1");
		IState t2 = new State("t2");
		IState t3 = new State("t3");
		IState t4 = new State("t4");
		IState qClosePar = new State("qClosePar");
		IState qOpenKey = new State("qOpenKey");
		IState qCloseKey = new State("qCloseKey");
		IState qif = new State("qif");
		List<IState> qs = Arrays.asList(q,qi,qf, qw, qh, ql, qe,qOpenPar,t0,t1,t2,t3,t4,qClosePar,qOpenKey,qCloseKey,qif);
		qif.setFinal();
		q.addTransition(qw, null, null, '$');
		qw.addTransition(qh, 'w', null, null);
		qh.addTransition(qi, 'h', null, null);
		qi.addTransition(ql, 'i', null, null);
		ql.addTransition(qe, 'l', null, null);
		qe.addTransition(qOpenPar, 'e', null, null);
		qOpenPar.addTransition(t0, '(', null, null);
		t1.addTransition(t2, '=', null, null);
		t1.addTransition(qClosePar, ')', null, null);
		t2.addTransition(t3, '=', null, null);
		q.addTransition(qi, null, null, '$');
		qi.addTransition(qf, 'i', null, null);
		qf.addTransition(qOpenPar, 'f', null, null);
		qOpenPar.addTransition(t0, '(', null, null);
		t1.addTransition(t2, '=', null, null);
		t1.addTransition(qClosePar, ')', null, null);
		t2.addTransition(t3, '=', null, null);

		t4.addTransition(qClosePar, ')', null, null);

		qClosePar.addTransition(qOpenKey, '{', null, '{');
		qOpenKey.addTransition(qOpenKey, '{', null, '{');

		qOpenKey.addTransition(qCloseKey, '}', '{', null);
		qOpenKey.addTransition(qf, 'i', null, null);

		qCloseKey.addTransition(qCloseKey, '}', '{', null);
		qCloseKey.addTransition(qif, null, '$', null);

		for (char c : sigma) {
			t0.addTransition(t1, c, null, null);
			t1.addTransition(t1, c, null, null);
			t3.addTransition(t4, c, null, null);
			t4.addTransition(t4, c, null, null);
			qOpenKey.addTransition(qOpenKey, c, null, null); //para aceitar quarquer simbolo do alfabeto depois de {
		}
		for(IState s: qs) {
			s.addTransition(s, '\n', null, null);
		}
		// aceitar espacos
		qClosePar.addTransition(qClosePar, ' ', null, null);
		qOpenPar.addTransition(qOpenPar, ' ', null, null);
		qCloseKey.addTransition(qCloseKey, ' ', null, null);

		String w = "while(teste) {"
				+ "  if(a==b){  faco algo }"
				+ "}";

		IPDA pda = new PDA(q);
		pda.makeLog();
		Util.checkout(pda.run(w),w);
		System.out.println("*****************************");
	}
	public static void identificadores() throws Exception{
		char[] sigma = " abcdefghijklmnopqrstuvxywz0123456789".toCharArray();
		System.out.println("*****************************\nProcessamento de linguagem");
		IState q = new State("q");
		IState qi = new State("qi");
		IState qn = new State("qn");
		IState qt = new State("qt");

		IState qb = new State("qb");
		IState qo = new State("qo");
		IState ql = new State("ql");
		IState qe = new State("qe");
		IState qa = new State("qa");


		IState qOpenPar = new State("qOpenPar");
		IState t0 = new State("t0");
		IState t1 = new State("t1");
		IState t2 = new State("t2");
		IState t3 = new State("t3");
		IState t4 = new State("t4");

		IState qname = new State("qname");
		IState qnamee = new State("qnamee");
		IState qI = new State("q;");
		IState qdef = new State("qdef");
		IState qover = new State("qover");

		IState qequals = new State("q=");

		IState qClosePar = new State("qClosePar");
		IState qOpenKey = new State("qOpenKey");
		IState qCloseKey = new State("qCloseKey");
		IState qif = new State("qif");
		List<IState> qs = Arrays.asList(q,qi,qn,qo,qt,qOpenPar,t0,t1,t2,t3,t4,qClosePar,qOpenKey,qCloseKey,qif);
		qif.setFinal();
		q.addTransition(qi, null, null, '$');
		qi.addTransition(qn, 'i', null, null);
		qi.addTransition(qb, 'b', null, null);
		qb.addTransition(qo, 'o', null, null);
		qo.addTransition(qo, 'o', null, null);
		qo.addTransition(ql, 'l', null, null);
		ql.addTransition(qe, 'e', null, null);
		qe.addTransition(qa, 'a', null, null);
		qa.addTransition(qname, 'n', null, null);

		qn.addTransition(qt, 'n', null, null);

		qt.addTransition(qname, 't', null, null);
		for(char c : sigma)
			qname.addTransition(qnamee, c, null, null);
		for(char c : sigma)
			qnamee.addTransition(qnamee, c, null, null);
		qnamee.addTransition(qequals, '=', null, null);
		qnamee.addTransition(qI, ';', null, null);
		for(char c : sigma)
			qequals.addTransition(qdef, c, null, null);
		for(char c : sigma)
			qdef.addTransition(qdef, c, null, null);
		qdef.addTransition(qI, ';', null, null);

		qI.addTransition(qn, 'i', null, null);
		qI.addTransition(qb, 'b', null, null);
		qI.addTransition(qover, null, '$', null);
		qover.addTransition(qif, null, null, '$');


		for (char c : sigma) {
			t0.addTransition(t1, c, null, null);
			t1.addTransition(t1, c, null, null);
			t3.addTransition(t4, c, null, null);
			t4.addTransition(t4, c, null, null);
			qOpenKey.addTransition(qOpenKey, c, null, null); //para aceitar quarquer simbolo do alfabeto depois de {
		}
		for(IState s: qs) {
			s.addTransition(s, '\n', null, null);
		}
		// aceitar espacos
		qClosePar.addTransition(qClosePar, ' ', null, null);
		qOpenPar.addTransition(qOpenPar, ' ', null, null);
		qCloseKey.addTransition(qCloseKey, ' ', null, null);

		String w = "boolean mateus;" +
				"boolean mateus = true;"+
				"int mateus;" +
				"int mateus = 12;";

		IPDA pda = new PDA(q);
		pda.makeLog();
		Util.checkout(pda.run(w),w);
		System.out.println("*****************************");
	}
	public static void para() throws Exception {
		char[] sigma = " abcdefghijklmnopqrstuvxywz".toCharArray();
		System.out.println("*****************************\nProcessamento de linguagem");
		IState q = new State("q");
		IState qi = new State("qi");
		IState qf = new State("qf");
		IState qo = new State("qo");
		IState qr = new State("qr");

		IState qOpenPar = new State("qOpenPar");
		IState t0 = new State("t0");
		IState t1 = new State("t1");
		IState t2 = new State("t2");
		IState t3 = new State("t3");
		IState t4 = new State("t4");

		IState qa = new State("qa");
		IState qaa = new State("qaa");
		IState qI = new State("q;");
		IState qaaa = new State("qaaa");
		IState qII = new State("q;;");
		IState qaaaa = new State("qaaaa");

		IState qp = new State("q+");
		IState qpp = new State("q++");

		IState qClosePar = new State("qClosePar");
		IState qOpenKey = new State("qOpenKey");
		IState qCloseKey = new State("qCloseKey");
		IState qif = new State("qif");
		List<IState> qs = Arrays.asList(q,qi,qf,qo,qr,qOpenPar,t0,t1,t2,t3,t4,qClosePar,qOpenKey,qCloseKey,qif);
		qif.setFinal();
		q.addTransition(qf, null, null, '$');
		qf.addTransition(qo, 'f', null, null);
		qo.addTransition(qr, 'o', null, null);
		qr.addTransition(qOpenPar, 'r', null, null);
		qOpenPar.addTransition(qa, '(', null, null);
		for(char c : sigma)
			qa.addTransition(qaa, c, null, null);
		for(char c : sigma)
			qaa.addTransition(qaa, c, null, null);
		qaa.addTransition(qI, ';', null, null);

		for(char c : sigma)
			qI.addTransition(qaaa, c, null, null);
		for(char c : sigma)
			qaaa.addTransition(qaaa, c, null, null);

		qaaa.addTransition(qII, ';', null, null);
		for(char c : sigma)
			qII.addTransition(qaaaa, c, null, null);
		for(char c : sigma)
			qaaaa.addTransition(qaaaa, c, null, null);
		qaaaa.addTransition(qp, '+', null, null);
		qp.addTransition(qpp, '+', null, null);
		qpp.addTransition(qClosePar, ' ', null
		, null);
		qpp.addTransition(qClosePar, ')', null, null);
		qpp.addTransition(qClosePar, ' ', null
				, null);
		t4.addTransition(qClosePar, ')', null, null);


		qClosePar.addTransition(qOpenKey, '{', null, '{');
		qOpenKey.addTransition(qOpenKey, '{', null, '{');

		qOpenKey.addTransition(qCloseKey, '}', '{', null);
		qOpenKey.addTransition(qf, 'i', null, null);

		qCloseKey.addTransition(qCloseKey, '}', '{', null);
		qCloseKey.addTransition(qif, null, '$', null);


		for (char c : sigma) {
			t0.addTransition(t1, c, null, null);
			t1.addTransition(t1, c, null, null);
			t3.addTransition(t4, c, null, null);
			t4.addTransition(t4, c, null, null);
			qOpenKey.addTransition(qOpenKey, c, null, null); //para aceitar quarquer simbolo do alfabeto depois de {
		}
		for(IState s: qs) {
			s.addTransition(s, '\n', null, null);
		}
		// aceitar espacos
		qClosePar.addTransition(qClosePar, ' ', null, null);
		qOpenPar.addTransition(qOpenPar, ' ', null, null);
		qCloseKey.addTransition(qCloseKey, ' ', null, null);

		String w = "for ( identificador ; teste ; identificador++) {"
				+ "}";

		IPDA pda = new PDA(q);
		pda.makeLog();
		Util.checkout(pda.run(w),w);
		System.out.println("*****************************");
	}
}

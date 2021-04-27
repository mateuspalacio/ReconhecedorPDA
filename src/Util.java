import pda.automata.IEdge;
import pda.automata.IState;
import pda.automata.ITransition;

public class Util {// PDA = (Q, Σ, δ, {qi}, F)
    public static boolean testAB(Character a, Character b) {
    	if(a!=null) return a.equals(b);
    	if(b!=null) return b.equals(a);
    	return true;
    }
    public static IEdge instance(Character c, Character _pop, Character _push) { 
    	return new Edge(c, _pop, _push); 
    }
    public static ITransition instance(IState state, IEdge edge) { 
    	return new Transition(state, edge); 
    }
	public static void checkout(boolean b, String w) {
		if(b)
			System.out.println("reconheceu: " + w);
		else 
			System.out.println("Não reconheceu: " + w);
	}
}

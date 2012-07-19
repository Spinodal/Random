/**
 * 
 */
package exercises.elements;

/**
 * @author michael.wambeek
 * Immutable
 */
public final class Element {
	private static boolean[] ALKALI = new boolean[119];
	private static boolean[] TRANSITION_METALS = new boolean[119];
	private static boolean[] METALS = new boolean[119];
	
	static{
		ALKALI[3] = true;
		ALKALI[11] = true;
		ALKALI[19] = true;
		ALKALI[37] = true;
		ALKALI[55] = true;
		ALKALI[87] = true;
		
		TRANSITION_METALS[21] = true;
		TRANSITION_METALS[22] = true;
		TRANSITION_METALS[23] = true;
		TRANSITION_METALS[24] = true;
		TRANSITION_METALS[25] = true;
		TRANSITION_METALS[26] = true;
		TRANSITION_METALS[27] = true;
		TRANSITION_METALS[28] = true;
		TRANSITION_METALS[29] = true;
		TRANSITION_METALS[30] = true;
		TRANSITION_METALS[31] = true;
		TRANSITION_METALS[39] = true;
		TRANSITION_METALS[40] = true;
		TRANSITION_METALS[41] = true;
		TRANSITION_METALS[42] = true;
		TRANSITION_METALS[43] = true;
		TRANSITION_METALS[44] = true;
		TRANSITION_METALS[45] = true;
		TRANSITION_METALS[46] = true;
		TRANSITION_METALS[47] = true;
		TRANSITION_METALS[48] = true;
		TRANSITION_METALS[72] = true;
		TRANSITION_METALS[73] = true;
		TRANSITION_METALS[74] = true;
		TRANSITION_METALS[75] = true;
		TRANSITION_METALS[76] = true;
		TRANSITION_METALS[77] = true;
		TRANSITION_METALS[78] = true;
		TRANSITION_METALS[79] = true;
		TRANSITION_METALS[80] = true;
		TRANSITION_METALS[104] = true;
		TRANSITION_METALS[105] = true;
		TRANSITION_METALS[106] = true;
		TRANSITION_METALS[107] = true;
		TRANSITION_METALS[108] = true;
		TRANSITION_METALS[109] = true;
		TRANSITION_METALS[110] = true; 
		TRANSITION_METALS[111] = true;
		TRANSITION_METALS[112] = true;
		
		METALS[13] = true;
		METALS[49] = true;
		METALS[50] = true;
		METALS[81] = true;
		METALS[82] = true;
		METALS[83] = true;
		METALS[113] = true;
		METALS[114] = true;
		METALS[115] = true;
		METALS[116] = true;
	}
	

	private String name;
	private String symbolicName;
	private int atomicNumber;
	
	public Element(String name, String symbolicName, int atomicNumber){
		this.name = name;
		this.symbolicName = symbolicName;
		this.atomicNumber = atomicNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the symbolicName
	 */
	public String getSymbolicName() {
		return symbolicName;
	}

	/**
	 * @return the atomicNumber
	 */
	public int getAtomicNumber() {
		return atomicNumber;
	}
	
	/**
	 * @return
	 */
	public boolean isAlkali(){
		return Element.ALKALI[this.atomicNumber];
	}
	
	/**
	 * @return
	 */
	public boolean isTransitionMetal(){
		return Element.TRANSITION_METALS[this.atomicNumber];
	}
	
	/**
	 * @return
	 */
	public boolean isMetal(){
		return Element.METALS[this.atomicNumber];
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Element: " + symbolicName+" (" + name + ") - " + atomicNumber;
	}
}

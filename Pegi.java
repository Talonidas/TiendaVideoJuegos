package standard;

public enum Pegi {
	PEGI_3 (3), PEGI_7 (7), PEGI_12 (12), PEGI_16 (16), PEGI_18 (18);

	public final int EDAD_PEGI; 
	
	Pegi (int EDAD_PEGI){
		this.EDAD_PEGI = EDAD_PEGI; 
	}
	
	public int getEDAD_PEGUI() {
		return EDAD_PEGI; 
	}
}

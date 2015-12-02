package fitandfun;

public enum Sex {
	None,
	Male,
	Female;
	
	@Override
	public String toString() {
		switch(this)
		{
			case None: return "";
			case Male: return "M�nnlich";
			case Female: return "Weiblich";
			default: return this.name();
		}
	};
}

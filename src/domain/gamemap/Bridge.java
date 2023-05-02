package domain.gamemap;

public class Bridge {

	Territory t1;
	Territory t2;
	
	private void createBridge(Territory ter1, Territory ter2) {
		this.t1 = ter1;
		this.t2 = ter2;
	}
	
	public Territory[] getTerritories() {

		Territory[] terList = Territory[2];
		
		Territory[0] = t1;
		Territory[1] = t2;
		
		return terList;
		
	}
}

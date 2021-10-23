package state_machine;

public class CharacterType {
	
	public enum IpType {
		ONE_TO_NINE, ZERO, ADD, SUB, UNDEFINED;
	}
	 
	public static IpType get(int ip) {
		
		if (ip == 48) {
			return IpType.ZERO;
		}
		
		if (ip >= 49 && ip <= 58) {
			return IpType.ONE_TO_NINE;
		}
		
		if (ip == 43) {
			return IpType.ADD;
		}
		
		if (ip == 45) {
			return IpType.SUB;
		}
		
		return IpType.UNDEFINED;
	}

}

package th.part_19_ENUM.chapter_10_constants._02;

import java.util.EnumMap;

public enum Catagory {
	MONEY(Input.NICKEL, Input.DIME),
	ITEM_SECTION(Input.TOOTHPASTE,Input.CHIPS,Input.SODA,Input.SOAP),
	QUIT_TRANSACTION(Input.ABORT_TRANSCTION), 
	SHUT_DOWN(Input.STOP);
	
	private Input[] values;

	private Catagory(Input... types) {
		values = types;
	}

	private static EnumMap<Input, Catagory> map = new EnumMap<Input, Catagory>(Input.class);
	static{
		for(Catagory ca:Catagory.class.getEnumConstants()){
			for(Input type:ca.values){
				map.put(type, ca);
			}
		}
	}
	
	public static Catagory catagorize(Input input){
		return map.get(input);
	}
}

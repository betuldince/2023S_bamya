package domain;


import java.util.Random;

public class singleton_boolean {
	//singleton pattern dice
			public boolean our_boolean=true;
			private static singleton_boolean bool_instance=null;
			
			private singleton_boolean() {
				
			}


			public static singleton_boolean initiate_bool() {
				if (bool_instance == null) {
					bool_instance = new singleton_boolean();
				}
				return bool_instance;
			}
			
		
}
package domain;


import java.util.Random;

public class boolean_singleton {
	//singleton pattern dice
			public boolean our_boolean=true;
			private static boolean_singleton bool_instance=null;
			
			private boolean_singleton() {
				
			}


			public static boolean_singleton initiate_bool() {
				if (bool_instance == null) {
					bool_instance = new boolean_singleton();
				}
				return bool_instance;
			}
			
		
}



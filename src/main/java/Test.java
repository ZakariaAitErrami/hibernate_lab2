import java.util.*;

import metier.*;

public class Test {

	public static void main(String[] args)  {
		try {
			List<Object> exs = ServiceMetier.getExemplaireDispo();
			Iterator it = exs.iterator();
			while(it.hasNext()) {
				Object obj[] = (Object[])it.next();
				System.out.println("c "+ obj[0] +" t " + obj[1]);
			}
		} catch (Exception e) {
			
		}
		

	}

}

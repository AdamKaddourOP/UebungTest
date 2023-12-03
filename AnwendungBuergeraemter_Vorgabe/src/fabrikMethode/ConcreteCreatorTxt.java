package fabrikMethode;

import java.io.IOException;

public class ConcreteCreatorTxt extends Creator {

	public Product factoryMethod() throws IOException {
		
		return new ConcreteTxtProduct();
		
	}
}


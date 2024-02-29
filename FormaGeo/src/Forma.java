
public abstract class Forma {

	public Forma() {
		System.out.println("Construir uma forma.");
		
	}
public abstract float calcularArea();

public void exibirInfo() {
	System.out.println("Esta é uma forma.");
	
  }
}

public class Circulo extends Forma{}
	private float raio;
	
	public Circulo(float r) {
        super();
        this.raio = r;
        System.out.println("Construindo um círculo com raio " + raio + ".");
    }
	
public float calcularArea() {return 3.14f * raio * raio;};



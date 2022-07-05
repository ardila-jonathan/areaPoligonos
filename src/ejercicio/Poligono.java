
package ejercicio;


public abstract class Poligono {
    
    protected int numLados;

    public Poligono(int numLados) {
        this.numLados = numLados;
    }

    public int getNumLados() {
        return numLados;
    }

    @Override
    public String toString() {
        return "Poligono{" + "Numero de lados-> " + numLados + '}';
    }

    public abstract double area();
    
    
    
}

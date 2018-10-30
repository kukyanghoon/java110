package ex02;

public class Tire {
    String naem;
    int radius;
    
    
    
    
    @Override
    public String toString() {
        return "Tire [naem=" + naem + ", radius=" + radius + "]";
    }
    public Tire(String naem, int radius) {
        super();
        this.naem = naem;
        this.radius = radius;
    }
    public String getNaem() {
        return naem;
    }
    public void setNaem(String naem) {
        this.naem = naem;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    
}

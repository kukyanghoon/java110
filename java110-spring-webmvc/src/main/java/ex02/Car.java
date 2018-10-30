package ex02;

import java.sql.Date;
import java.util.Arrays;

public class Car {
    String model;
    int no;
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    String maker;
    boolean auto;
    Engine engine;
    Date createdDate;
    String[] musics;
    
    @Override
    public String toString() {
        return "Car [model=" + model + ", no=" + no + ", maker=" + maker + ", auto=" + auto + ", engine=" + engine
                + ", createdDate=" + createdDate + ", musics=" + Arrays.toString(musics) + ", tires="
                + Arrays.toString(tires) + "]";
    }
    Tire[] tires;
    
    public Tire[] getTires() {
        return tires;
    }
    public void setTires(Tire[] tires) {
        this.tires = tires;
    }
    public String[] getMusics() {
        return musics;
    }
    public void setMusics(String[] musics) {
        this.musics = musics;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public boolean isAuto() {
        return auto;
    }
    public void setAuto(boolean auto) {
        this.auto = auto;
    }
    public Engine getEngine() {
        return engine;
    }
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    
    
}

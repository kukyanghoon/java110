package ex02;

import java.beans.PropertyEditorSupport;

// String ==> ex02.Car 프로퍼티 값 변환기
//
public class CarPropertyEditor extends PropertyEditorSupport {



    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        try {
            String[] values = text.split(",");
            Car car = new Car();
            car.setModel(values[0]);
            car.setMaker(values[2]);
            car.setAuto(Boolean.parseBoolean(values[2]));
            
            this.setValue(car);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Object getValue() {
        return super.getValue();
    }
}

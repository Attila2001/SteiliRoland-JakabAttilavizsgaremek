
package Model;

public class CarModel {
    Integer id;
    String platenumber;
    Integer doornumber;
    Integer modelyear;
    String brand_id;
    String color_id;
    String propulsion_id;
    String gearbox_id;

    public CarModel(Integer id,String platenumber,Integer doornumber,Integer modelyear,String brand_id,String color_id,String propulsion_id,String gearbox_id) {
        this.id=id;
        this.platenumber = platenumber;
        this.doornumber = doornumber;
        this.modelyear = modelyear;
        this.propulsion_id=propulsion_id;
        this.gearbox_id = gearbox_id;
        this.brand_id = brand_id;
        this.color_id = color_id;
    }

   
}

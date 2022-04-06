
package Model;

public class CarModel {
    String platenumber;
    Integer doornumber;
    Integer modelyear;
    Integer brand_id;
    Integer color_id;
    Integer propulsion_id;
    Integer gearbox_id;

    public CarModel(String platenumber,Integer doornumber,Integer modelyear,Integer brand_id,Integer color_id,Integer propulsion_id,Integer gearbox_id) {
        this.platenumber = platenumber;
        this.doornumber = doornumber;
        this.modelyear = modelyear;
        this.propulsion_id=propulsion_id;
        this.gearbox_id = gearbox_id;
        this.brand_id = brand_id;
        this.color_id = color_id;
    }

   
}

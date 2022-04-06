
package Control;
import Model.API_Model;
import java.util.Vector;
public class API_Controller {
    private API_Model APIMdl;
    public API_Controller() {
        APIMdl= new API_Model();
        
    }
    public Vector<Vector<Object>> getRenters() {
        Vector<Vector<Object>> renters = new Vector<>();
        
        renters = APIMdl.tryRenters();
        
        return renters;
    }
    public Vector<Vector<Object>> getCars() {
        Vector<Vector<Object>> cars = new Vector<>();
        
        cars = APIMdl.tryCars();
        
        return cars;
    }
     public Vector<Vector<Object>> getRents() {
        Vector<Vector<Object>> rents = new Vector<>();
        
        rents = APIMdl.tryRents();
        
        return rents;
    }
    
    
}

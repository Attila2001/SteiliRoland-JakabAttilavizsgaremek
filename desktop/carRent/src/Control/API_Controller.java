
package Control;
import Model.API_Model;
import java.util.Vector;
public class API_Controller {
    private API_Model APIMdl;
    private String token;
    private String id;
    public API_Controller() {
        APIMdl= new API_Model();
        token = getToken();
        id = "";
    }
     private String getToken() {
        String token = APIMdl.tryLogin();
        return token;
    }
    public void Logout() {
        APIMdl.tryLogout(token);
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
     public Vector<Vector<Object>> getBrands() {
        Vector<Vector<Object>> brands = new Vector<>();
        
        brands = APIMdl.tryBrands();
        
        return brands;
    }
     public Vector<Vector<Object>> getColors() {
        Vector<Vector<Object>> colors = new Vector<>();
        
        colors = APIMdl.tryColors();
        
        return colors;
    }
     public Vector<Vector<Object>> getGearboxes() {
        Vector<Vector<Object>> gearboxes = new Vector<>();
        
        gearboxes = APIMdl.tryGearboxes();
        
        return gearboxes;
    }
     public Vector<Vector<Object>> getPropulsions() {
        Vector<Vector<Object>> propulsions = new Vector<>();
        
        propulsions = APIMdl.tryPropulsions();
        
        return propulsions;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    public void DeleteRenter() {
      APIMdl.tryDeleteRenters(token, id);
    }
    public void DeleteCar() {
        APIMdl.tryDeleteCars(token, id);
    }
    public void DeleteRent() {
        APIMdl.tryDeleteRents(token, id);
    }
    public void DeleteBrand() {
        APIMdl.tryDeleteBrands(token, id);
    }
    public void DeleteColor() {
        APIMdl.tryDeleteColors(token, id);
    }
    
}

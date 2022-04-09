
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
    
    public void setId(String id) {
        this.id = id;
    }
    public Boolean DeleteRenter() {
        boolean success = APIMdl.tryDeleteRenters(token, id);
        return success;
    }
    public Boolean DeleteCar() {
        boolean success = APIMdl.tryDeleteCars(token, id);
        return success;
    }
    public Boolean DeleteRent() {
        boolean success = APIMdl.tryDeleteRents(token, id);
        return success;
    }
    public Boolean UpdateRenter(){
        boolean success = APIMdl.tryUpdateRenters(token, id);
        return success;
    }
    public Boolean UpdateCar(){
        boolean success = APIMdl.tryUpdateCars(token, id);
        return success;
    }
    public Boolean UpdateRent(){
        boolean success = APIMdl.tryUpdateRents(token, id);
        return success;
    }
    
    
}

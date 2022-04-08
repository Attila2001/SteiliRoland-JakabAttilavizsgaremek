
package Model;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.OutputStream;
public class API_Model {

        public String tryLogin() {
        String result = "";
        try {
            result = Login();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    private String Login() throws Exception{
        
        URL url = new URL("http://localhost:8000/api/login");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");
        
        String data= "{\"name\":\"Roland\",\"password\":\"Roland\"}";
        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        
        OutputStream stream = conn.getOutputStream();
        stream.write(out);
        
        conn.connect();
        String text = "";
        int responseCode = conn.getResponseCode();
        if(responseCode == 200) {
            text = new String(
                conn.getInputStream().readAllBytes(), 
                StandardCharsets.UTF_8);
        }else {
            throw new RuntimeException("Http válasz: " + responseCode);
        }
        JsonObject jsonObject = new JsonParser().parse(text).getAsJsonObject();
        JsonObject tokenObject = jsonObject.getAsJsonObject("data");
        
        
        String token_raw = tokenObject.get("token").toString();
        String token = token_raw.substring(1, token_raw.length() - 1);
        
        return token;
    }
    public void tryLogout(String token) {
        try {
            
            Logout(token);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void Logout(String token) throws Exception{
    
        URL url = new URL("http://localhost:8000/api/logout");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Authorization", "Bearer " +token);
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        
        String data = token;
        byte[] out = data.getBytes(StandardCharsets.UTF_8);
        
        OutputStream stream = conn.getOutputStream();
        stream.write(out);
    }
    
       public Vector<Vector<Object>> tryRenters() {
        Vector<Vector<Object>> renters = new Vector<>();
        try {
            renters = Renters();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return renters;
        }
       private Vector<Vector<Object>> Renters() throws Exception {
        URL url = new URL("http://localhost:8000/api/renters");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.setDoOutput(true);
        
        http.connect();
 
        String text = "";
        int responseCode = http.getResponseCode();
        if (responseCode == 200) {
            text = new String(
                http.getInputStream().readAllBytes(), 
                StandardCharsets.UTF_8);
        }else {
            throw new RuntimeException("Http válasz: " + responseCode);
        }
        JsonObject jsonObject = new JsonParser().parse(text).getAsJsonObject();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        JsonArray arr = jsonObject.getAsJsonArray("data");
        
         RenterModel[] Array = gson.fromJson(arr, RenterModel[].class);
        ArrayList<RenterModel> list = new ArrayList<>(Arrays.asList(Array));

        Vector<Vector<Object>> renters = new Vector<>();
        for(RenterModel rentermodel: list) {
            
            Vector<Object> renter = new Vector<>();
            renter.add(rentermodel.id);
            renter.add(rentermodel.name);
            renter.add(rentermodel.email);
            renter.add(rentermodel.phone);
            renter.add(rentermodel.address);
            renter.add(rentermodel.identify);
            
            renters.add(renter);
            
        }
         return renters;
       }
    
       public Vector<Vector<Object>> tryCars() {
        Vector<Vector<Object>> cars = new Vector<>();
        try {
            cars = Cars();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cars;
    }
       private Vector<Vector<Object>> Cars() throws Exception {
        URL url = new URL("http://localhost:8000/api/cars");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.setDoOutput(true);
        http.connect();
 
        String text = "";
        int responseCode = http.getResponseCode();
        if (responseCode == 200) {
            text = new String(
                http.getInputStream().readAllBytes(), 
                StandardCharsets.UTF_8);
            
        }else {
            throw new RuntimeException("Http válasz: " + responseCode);
        }
        JsonObject jsonObject = new JsonParser().parse(text).getAsJsonObject();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        JsonArray arr = jsonObject.getAsJsonArray("data");
        
        CarModel[] Array = gson.fromJson(arr, CarModel[].class);
        ArrayList<CarModel> list = new ArrayList<>(Arrays.asList(Array));

        Vector<Vector<Object>> cars = new Vector<>();
        for(CarModel carmodel: list) {
            
            Vector<Object> car = new Vector<>();
            car.add(carmodel.id);
            car.add(carmodel.platenumber);
            car.add(carmodel.doornumber);
            car.add(carmodel.modelyear);
            car.add(carmodel.propulsion_id);
            car.add(carmodel.gearbox_id);
            car.add(carmodel.brand_id);
            car.add(carmodel.color_id);
            
            cars.add(car);
            
        }
         return cars;
       }
       public Vector<Vector<Object>> tryRents() {
        Vector<Vector<Object>> rents = new Vector<>();
        try {
            rents = Rents();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return rents;
       }
       private Vector<Vector<Object>> Rents() throws Exception {
        URL url = new URL("http://localhost:8000/api/rents");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("GET");
        http.setDoOutput(true);
        http.connect();
 
        String text = "";
        int responseCode = http.getResponseCode();
        if (responseCode == 200) {
            text = new String(
                http.getInputStream().readAllBytes(), 
                StandardCharsets.UTF_8);
            
        }else {
            throw new RuntimeException("Http válasz: " + responseCode);
        }
        JsonObject jsonObject = new JsonParser().parse(text).getAsJsonObject();
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        JsonArray arr = jsonObject.getAsJsonArray("data");
        
        RentModel[] Array = gson.fromJson(arr, RentModel[].class);
        ArrayList<RentModel> list = new ArrayList<>(Arrays.asList(Array));

        Vector<Vector<Object>> rents = new Vector<>();
        for(RentModel rentmodel: list) {
            
            Vector<Object> rent = new Vector<>();
            rent.add(rentmodel.id);
            rent.add(rentmodel.startdate);
            rent.add(rentmodel.enddate);
            rent.add(rentmodel.deposit);
            rent.add(rentmodel.renter_id);
            rent.add(rentmodel.car_id);
            
            rents.add(rent);
            
        }
         return rents;
       }
       
       public Boolean tryDeleteRenters(String token,String id){
            boolean success =false;
            try{
                success = DeleteRenters(token,id);

            }catch(Exception ex){
                ex.printStackTrace();
            }
            return success;
       }
       private Boolean DeleteRenters(String token, String id) throws Exception{
           URL url = new URL("http://localhost:8000/api/renters/" + id);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        
        http.setRequestProperty("Authorization", "Bearer " +token);
        http.setRequestMethod("DELETE");
        http.setDoOutput(true);

        http.connect();
        
        boolean success = false;
        String text = "";
        int responseCode = http.getResponseCode();
        
        if(responseCode == 200) {
            success = true;
            text = new String(
                http.getInputStream().readAllBytes(), 
                StandardCharsets.UTF_8);
        }else {
            throw new RuntimeException("Http válasz: " + responseCode);
        }
        
        return success;
       }
       
       public Boolean tryDeleteCars(String token,String id){
            boolean success =false;
            try{
                success = DeleteCars(token,id);

            }catch(Exception ex){
                ex.printStackTrace();
            }
            return success;
       }
       private Boolean DeleteCars(String token, String id) throws Exception{
           URL url = new URL("http://localhost:8000/api/cars/" + id);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        
        http.setRequestProperty("Authorization", "Bearer " +token);
        http.setRequestMethod("DELETE");
        http.setDoOutput(true);

        http.connect();
        
        boolean success = false;
        String text = "";
        int responseCode = http.getResponseCode();
        
        if(responseCode == 200) {
            success = true;
            text = new String(
                http.getInputStream().readAllBytes(), 
                StandardCharsets.UTF_8);
        }else {
            throw new RuntimeException("Http válasz: " + responseCode);
        }
        return success;
       }
       
       public Boolean tryDeleteRents(String token,String id){
            boolean success =false;
            try{
                success = DeleteRents(token,id);

            }catch(Exception ex){
                ex.printStackTrace();
            }
            return success;
       }
       private Boolean DeleteRents(String token, String id) throws Exception{
           URL url = new URL("http://localhost:8000/api/rents/" + id);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        
        http.setRequestProperty("Authorization", "Bearer " +token);
        http.setRequestMethod("DELETE");
        http.setDoOutput(true);

        http.connect();
        
        boolean success = false;
        String text = "";
        int responseCode = http.getResponseCode();
        
        if(responseCode == 200) {
            success = true;
            text = new String(
                http.getInputStream().readAllBytes(), 
                StandardCharsets.UTF_8);
        }else {
            throw new RuntimeException("Http válasz: " + responseCode);
        }
        return success;
       }
}

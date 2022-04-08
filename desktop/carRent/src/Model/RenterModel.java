
package Model;

public class RenterModel {
    Integer id;
    String name;
    String email;
    String phone;
    String address;
    String identify;

    public RenterModel(Integer id,String name, String email,String phone, String address, String identify) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.address=address;
        this.identify=identify;
    }


}
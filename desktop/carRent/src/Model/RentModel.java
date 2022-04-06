
package Model;

public class RentModel {
    String startdate;
    String enddate;
    Integer deposit;
    Integer renter_id;
    Integer car_id;
    public RentModel(String startdate, String enddate, Integer deposit, Integer renter_id, Integer car_id) {
        this.startdate=startdate;
        this.enddate=enddate;
        this.deposit=deposit;
        this.renter_id=renter_id;
        this.car_id=car_id;
    }
    
}

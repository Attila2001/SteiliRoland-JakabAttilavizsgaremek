
package Model;

public class RentModel {
    CarModel Carmdl;
    RenterModel Renermdl;
    Integer id;
    String startdate;
    String enddate;
    Integer deposit;
    String renter;
    String car;
    public RentModel(Integer id,String startdate, String enddate, Integer deposit, String renter, String car,CarModel Carmdl,RenterModel Rentermdl) {
        this.id=id;
        this.startdate=startdate;
        this.enddate=enddate;
        this.deposit=deposit;
        this.renter=Rentermdl.name;
        this.car=Carmdl.platenumber;
    }
    
}

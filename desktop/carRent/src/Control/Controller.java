
package Control;

public class Controller {

    public Controller() {
        API_Controller APICtr= new API_Controller();
        new ViewController(APICtr);
    }
  
}

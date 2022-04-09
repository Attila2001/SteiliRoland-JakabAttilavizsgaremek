
package Control;
import Model.ViewModel;
import java.util.Vector;
import View.carRentForm;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
public class ViewController {
    private ViewModel viewMdl;
    private API_Controller APICtr;
    private carRentForm carFrm;
    private Vector<Vector<Object>> tableData;
    
    public ViewController(API_Controller APICtr) {
        viewMdl = new ViewModel();
        this.APICtr=APICtr;
        start();
        initListeners();
       
    }
    
    private void initListeners() {
        
        carFrm.getExitBtn().addActionListener( event -> { exit(); });
        carFrm.getDeleteBtn().addActionListener( event -> { delete(); });
        carFrm.getEditBtn().addActionListener( event -> { edit(); });
        carFrm.getSaveBtn().addActionListener( event -> { save(); });
        carFrm.getSearchBtn().addActionListener( event -> { search(); });
        carFrm.getTableTb().addChangeListener( event -> { initTables(); });
    }
    
    private void start() {
        carFrm= new carRentForm();
        initTables();
        carFrm.setVisible( true );
    }
    
    
    private void initTables() {
        
        Vector<String> columnNames = new Vector<>();
        
        if( carFrm.getTableTb().getSelectedIndex() == 0 ) {
            
            columnNames = viewMdl.getRenterColumnNames();
            tableData = APICtr.getRenters();
            tableData.add( null );
            TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
            carFrm.getRenterTbl().setModel( tablMdl );
            
        }else if( carFrm.getTableTb().getSelectedIndex() == 1 ) {
            
            columnNames = viewMdl.getCarColumnNames();
            tableData = APICtr.getCars();
            tableData.add( null );
            TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
            carFrm.getCarTbl().setModel( tablMdl );
            
        }else {
            
            columnNames = viewMdl.getRentColumnNames();
            tableData = APICtr.getRents();
            tableData.add( null );
            TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
            carFrm.getRentTbl().setModel( tablMdl );
        }
    }
    
    private void search() {

    }
    
    private void save() {
        
    }

    private void edit() {
        
        switch (carFrm.getTableTb().getSelectedIndex()) {
           case 0 ->{
               updateRenters();
           }
           case 1 ->{
               updateCars();
           }
           case 2 ->{
               updateRents();
           }
        }
    }
    
    private void delete() {
        
       
       switch (carFrm.getTableTb().getSelectedIndex()) {
           case 0 ->{
               deleteRenters();
           }
           case 1 ->{
               deleteCars();
           }
           case 2 ->{
               deleteRents();
           }
       }
    }
    private void updateRenters(){
        int row = carFrm.getRenterTbl().getSelectedRow();
        String value = carFrm.getRenterTbl().getModel().getValueAt(row, 0).toString();
        APICtr.setId(value);
        
        APICtr.UpdateRenter();
                
        initTables();
    }
    private void updateCars(){
        int row = carFrm.getCarTbl().getSelectedRow();
        String value = carFrm.getCarTbl().getModel().getValueAt(row, 0).toString();
        APICtr.setId(value);
        
        APICtr.UpdateCar();
                
        initTables();
    }
    private void updateRents(){
        int row = carFrm.getRentTbl().getSelectedRow();
        String value = carFrm.getRentTbl().getModel().getValueAt(row, 0).toString();
        System.out.println(value);
        APICtr.setId(value);
        
        APICtr.UpdateRent();
                
        initTables();
        
    }
    private void deleteRenters(){
        int row = carFrm.getRenterTbl().getSelectedRow();
        String value = carFrm.getRenterTbl().getModel().getValueAt(row, 0).toString();
        APICtr.setId(value);
        
        APICtr.DeleteRenter();
                
        initTables();
    }
    private void deleteCars(){
        int row = carFrm.getCarTbl().getSelectedRow();
        String value = carFrm.getCarTbl().getModel().getValueAt(row, 0).toString();
        APICtr.setId(value);
        
        APICtr.DeleteCar();
                
        initTables();
    }
    private void deleteRents(){
        int row = carFrm.getRentTbl().getSelectedRow();
        String value = carFrm.getRentTbl().getModel().getValueAt(row, 0).toString();
        System.out.println(value);
        APICtr.setId(value);
        
        APICtr.DeleteRent();
                
        initTables();
    }
    private void exit() {
        APICtr.Logout();
        System.exit( 0 );
    }

}

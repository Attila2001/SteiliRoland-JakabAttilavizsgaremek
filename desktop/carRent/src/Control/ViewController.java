
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
        
        switch (carFrm.getTableTb().getSelectedIndex()){
        case 0 ->{
            
            columnNames = viewMdl.getRenterColumnNames();
            tableData = APICtr.getRenters();
            tableData.add( null );
            TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
            carFrm.getRenterTbl().setModel( tablMdl );
            carFrm.getDeleteBtn().setVisible(true);
            carFrm.getEditBtn().setVisible(true);
            carFrm.getSaveBtn().setVisible(true);
        }   
         case 1 ->{
            
            columnNames = viewMdl.getCarColumnNames();
            tableData = APICtr.getCars();
            tableData.add( null );
            TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
            carFrm.getCarTbl().setModel( tablMdl );
            carFrm.getDeleteBtn().setVisible(true);
            carFrm.getEditBtn().setVisible(true);
            carFrm.getSaveBtn().setVisible(true);
            
        }
         case 2 ->{
            
            columnNames = viewMdl.getRentColumnNames();
            tableData = APICtr.getRents();
            tableData.add( null );
            TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
            carFrm.getRentTbl().setModel( tablMdl );
            carFrm.getDeleteBtn().setVisible(true);
            carFrm.getEditBtn().setVisible(true);
            carFrm.getSaveBtn().setVisible(true);
        }
         case 3 ->{
            columnNames = viewMdl.getBrandColumnNames();
            tableData = APICtr.getBrands();
            tableData.add( null );
            TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
            carFrm.getBrandTbl().setModel( tablMdl );
            carFrm.getDeleteBtn().setVisible(true);
            carFrm.getEditBtn().setVisible(true);
            carFrm.getSaveBtn().setVisible(true);
         }
         case 4 ->{
            columnNames = viewMdl.getColorColumnNames();
            tableData = APICtr.getColors();
            tableData.add( null );
            TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
            carFrm.getColorTbl().setModel( tablMdl );
            carFrm.getDeleteBtn().setVisible(true);
            carFrm.getEditBtn().setVisible(true);
            carFrm.getSaveBtn().setVisible(true);
         }
         case 5 ->{
            columnNames = viewMdl.getGearboxColumnNames();
            tableData = APICtr.getGearboxes();
            tableData.add( null );
            TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
            carFrm.getGearboxTbl().setModel( tablMdl );
            carFrm.getDeleteBtn().setVisible(false);
            carFrm.getEditBtn().setVisible(false);
            carFrm.getSaveBtn().setVisible(false);
         }
         case 6 ->{
            columnNames = viewMdl.getPropulsionColumnNames();
            tableData = APICtr.getPropulsions();
            tableData.add( null );
            TableModel tablMdl = new DefaultTableModel( tableData, columnNames);
            carFrm.getPropulsionTbl().setModel( tablMdl );
            carFrm.getDeleteBtn().setVisible(false);
            carFrm.getEditBtn().setVisible(false);
            carFrm.getSaveBtn().setVisible(false);
         }
        }
    }
    
    private void search() {

    }
    
    private void save() {
        
    }

    private void edit() {

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
           case 3 ->{
               deleteBrands();
           }
           case 4 ->{
               deleteColors();
           }
       }
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
    private void deleteBrands(){
        int row = carFrm.getBrandTbl().getSelectedRow();
        String value = carFrm.getBrandTbl().getModel().getValueAt(row, 0).toString();
        APICtr.setId(value);
        
        APICtr.DeleteBrand();
                
        initTables();
    }
    private void deleteColors(){
        int row = carFrm.getColorTbl().getSelectedRow();
        String value = carFrm.getColorTbl().getModel().getValueAt(row, 0).toString();
        APICtr.setId(value);
        
        APICtr.DeleteColor();
                
        initTables();
    }
    private void exit() {
        APICtr.Logout();
        System.exit( 0 );
    }

}

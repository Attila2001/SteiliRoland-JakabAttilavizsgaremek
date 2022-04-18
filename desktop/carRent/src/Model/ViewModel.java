
package Model;

import java.util.Vector;

public class ViewModel {
        
         public Vector<String> getRenterColumnNames(){
        
        Vector<String> columnNames = new Vector<>();
        columnNames.add( "Id" );
        columnNames.add( "Név" );
        columnNames.add( "Email" );
        columnNames.add( "Telefon" );
        columnNames.add( "Cím" );
        columnNames.add( "Ig. szám" );
        
        return columnNames;
        }
     public Vector<String> getCarColumnNames(){
        
        Vector<String> columnNames = new Vector<>();
        columnNames.add( "Id" );
        columnNames.add( "Rendszám" );
        columnNames.add( "Ajtószám" );
        columnNames.add( "Évjárat" );
        columnNames.add( "Meghajtás" );
        columnNames.add( "Váltó típus" );
        columnNames.add( "Márka" );
        columnNames.add( "Szín" );
        
        return columnNames;
    }
     public Vector<String> getRentColumnNames(){
        
        Vector<String> columnNames = new Vector<>();
        columnNames.add( "Id" );
        columnNames.add( "Kölcsönzés kezdete" );
        columnNames.add( "Kölcsönzés vége" );
        columnNames.add( "Letét" );
        columnNames.add( "Kölcsönző" );
        columnNames.add( "Kölcsönzött autó" );
        return columnNames;
    }
     public Vector<String> getBrandColumnNames(){
        
        Vector<String> columnNames = new Vector<>();
        columnNames.add( "Id" );
        columnNames.add( "Név" );
        
        return columnNames;
     }
     
     public Vector<String> getColorColumnNames(){
        
        Vector<String> columnNames = new Vector<>();
        columnNames.add( "Id" );
        columnNames.add( "Név" );
        
        return columnNames;
     }
     public Vector<String> getPropulsionColumnNames(){
        
        Vector<String> columnNames = new Vector<>();
        columnNames.add( "Id" );
        columnNames.add( "Név" );
        
        return columnNames;
     }
     public Vector<String> getGearboxColumnNames(){
        
        Vector<String> columnNames = new Vector<>();
        columnNames.add( "Id" );
        columnNames.add( "Név" );
        
        return columnNames;
     }
}


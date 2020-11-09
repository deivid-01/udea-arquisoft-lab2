/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;
import com.udea.session.TransactionManager;
import java.util.List;
import javax.ejb.EJB;


public class TransactionsMBean {

 
    public TransactionsMBean() {
    }


    @EJB
    private com.udea.session.TransactionManagerLocal transactionManager;
    
    //Propiedades del modelo
    private Transactions transaction; // para actualiza los datos hacia el formulario
    
    private List<Transactions> transactions;  // para visualizar en la tabla
    
    

    
    //return list of clients to show in DataTable de JSF
    
    public List<Transactions> getTransactions()
    {
            if( transactions == null ||  transactions.isEmpty())
            {
                    refresh();
            }
            
            return transactions;
    }
    
    // Se retorna el detalle de cada cliente  en el formulario
    
    public  Transactions getDetails()
    {
        return transaction;
    }
    
    // Action handler  - llamado en una fila  de la tabla se haga click al ID del cliente
    public String showDetails(Transactions transaction )
    {
        this.transaction = transaction;
         return "DETAILS"; // Permite enlazar con CustomerDetails.xhtml
    }
    
    //Action hanlder- Cuando oprime el  boton de Update  se actualiza el modelo Customer en la BD
    
    public String update()
    {
        transaction = transactionManager.update(transaction);
        
        return "SAVED"; // Se retorna a CustomerList.xhtml
    }
    
    //ACtion  Handler-  retorna  ala vista  del DataTable  cuando  se haga click  en el boton back;
    
    public String list()
    {
        return "LIST"; // Se retorna  a CustomerList.xhtml
    }
    
    private void refresh()
    {
        transactions=transactionManager.getAllCustomers();
    }
}

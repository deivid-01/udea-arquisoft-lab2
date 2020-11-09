/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author deivid
 */
@Entity
@Table(name = "transactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t")
    , @NamedQuery(name = "Transactions.findById", query = "SELECT t FROM Transactions t WHERE t.id = :id")
    , @NamedQuery(name = "Transactions.findByClientName", query = "SELECT t FROM Transactions t WHERE t.clientName = :clientName")
    , @NamedQuery(name = "Transactions.findByEmail", query = "SELECT t FROM Transactions t WHERE t.email = :email")
    , @NamedQuery(name = "Transactions.findByCreditCardnum", query = "SELECT t FROM Transactions t WHERE t.creditCardnum = :creditCardnum")
    , @NamedQuery(name = "Transactions.findByCreditCardtype", query = "SELECT t FROM Transactions t WHERE t.creditCardtype = :creditCardtype")
    , @NamedQuery(name = "Transactions.findByCreditCardcvv", query = "SELECT t FROM Transactions t WHERE t.creditCardcvv = :creditCardcvv")
    , @NamedQuery(name = "Transactions.findByCreditCardexpirationDate", query = "SELECT t FROM Transactions t WHERE t.creditCardexpirationDate = :creditCardexpirationDate")
    , @NamedQuery(name = "Transactions.findByTransactionValue", query = "SELECT t FROM Transactions t WHERE t.transactionValue = :transactionValue")
    , @NamedQuery(name = "Transactions.findByTime", query = "SELECT t FROM Transactions t WHERE t.time = :time")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "clientName")
    private String clientName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "creditCard_num")
    private String creditCardnum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "creditCard_type")
    private String creditCardtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "creditCard_cvv")
    private String creditCardcvv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "creditCard_expirationDate")
    private String creditCardexpirationDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "transactionValue")
    private String transactionValue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "time_")
    private String time;

    public Transactions() {
    }

    public Transactions(Integer id) {
        this.id = id;
    }

    public Transactions(Integer id, String clientName, String email, String creditCardnum, String creditCardtype, String creditCardcvv, String creditCardexpirationDate, String transactionValue, String time) {
        this.id = id;
        this.clientName = clientName;
        this.email = email;
        this.creditCardnum = creditCardnum;
        this.creditCardtype = creditCardtype;
        this.creditCardcvv = creditCardcvv;
        this.creditCardexpirationDate = creditCardexpirationDate;
        this.transactionValue = transactionValue;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardnum() {
        return creditCardnum;
    }

    public void setCreditCardnum(String creditCardnum) {
        this.creditCardnum = creditCardnum;
    }

    public String getCreditCardtype() {
        return creditCardtype;
    }

    public void setCreditCardtype(String creditCardtype) {
        this.creditCardtype = creditCardtype;
    }

    public String getCreditCardcvv() {
        return creditCardcvv;
    }

    public void setCreditCardcvv(String creditCardcvv) {
        this.creditCardcvv = creditCardcvv;
    }

    public String getCreditCardexpirationDate() {
        return creditCardexpirationDate;
    }

    public void setCreditCardexpirationDate(String creditCardexpirationDate) {
        this.creditCardexpirationDate = creditCardexpirationDate;
    }

    public String getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(String transactionValue) {
        this.transactionValue = transactionValue;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.Transactions[ id=" + id + " ]";
    }
    
}

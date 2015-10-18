package edu.iit.sat.itmd4515.abhimani.mp2.question_10_jpa_inheritance.single_tbl_per_class_h;

import edu.iit.sat.itmd4515.abhimani.mp2.question_10_jpa_inheritance.Colors;
import edu.iit.sat.itmd4515.abhimani.mp2.question_10_jpa_inheritance.ConnectivityInterface;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Ankit Bhimani (abhimani) on edu.iit.sat.itmd4515.abhimani.mp2
 */
@Entity
@DiscriminatorValue("Internal_HDD")
@NamedQueries({
    @NamedQuery(name="HardDrive1.retrieveAll", query="SELECT s FROM HardDrive1 AS s"),
    @NamedQuery(name="HardDrive1.findById", query="SELECT s FROM HardDrive1 AS s WHERE s.Device_Id=:Id"),
    @NamedQuery(name="HardDrive1.findBySerial", query="SELECT s FROM HardDrive1 AS s WHERE s.Serial_No=:No")
})
public class HardDrive1
	extends StorageDevice1{
    //COLUMNS
    private ConnectivityInterface cinterface;

    private Colors color;

    private int rpms;

    private float form_factor;

    private String description;

    //CONSTRUCTS
    public HardDrive1(){
	super();
	this.setWarranty(5);
    }

    public HardDrive1(String Model_No, int Capacity, ConnectivityInterface ci, Colors color, int rpms, float form_factor){
	super(Model_No, Capacity);
	this.setWarranty(5);
	this.cinterface=ci;
	this.color=color;
	this.rpms=rpms;
	this.form_factor=form_factor;
    }

    //PROPERTIES
    public ConnectivityInterface getConnectivityInterface(){
	return cinterface;
    }

    public void setConnectivityInterface(ConnectivityInterface ci){
	this.cinterface=ci;
    }

    public Colors getColor(){
	return color;
    }

    public void setColor(Colors color){
	this.color=color;
    }

    public int getRPM(){
	return rpms;
    }

    public void setRPM(int rpms){
	this.rpms=rpms;
    }

    public String getFormFactor(){
	return (form_factor+"in. ");
    }

    public void setFormFactor(float form_factor){
	this.form_factor=form_factor;
    }

    public String getDesc(){
	return description;
    }

    public void setDesc(String desc){
	this.description=desc;
    }

    //OVERRIDES
    @Override
    public String toString(){
	try{
	    return ("/StorageDevice/HardDrive1{Id:"+this.getStorageId()+", S/N:"+this.getSerialNo()+", M/N:"+this.getModelNo()+", Capacity:\""+this.getStorageCapacity()+"\", Interface:"+this.getConnectivityInterface()+", Color:"+this.getColor()+", RPM:"+this.getRPM()+", Form Factor:\""+this.getFormFactor()+"\", Description:\""+this.getDesc()+"\"}");
	}catch(Exception ex){
	    ex.printStackTrace();
	    return ex.toString();
	}
    }
}

package edu.iit.sat.itmd4515.abhimani.mp2.question_10_jpa_inheritance.concrete_tables;

import edu.iit.sat.itmd4515.abhimani.mp2.question_10_jpa_inheritance.ConnectivityInterface;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author Ankit Bhimani (abhimani) on edu.iit.sat.itmd4515.abhimani.mp2
 */
@Entity
@Table(name="concrete_sdcards")
@NamedQueries({
    @NamedQuery(name="MemoryStick3.retrieveAll", query="SELECT s FROM MemoryStick3 AS s")
})
public class MemoryStick3
	extends StorageDevice3{
    //COLUMNS
    private ConnectivityInterface cinterface;

    @Min(1)
    @Max(10)
    private int speed_class=1;

    private float weight;

    //CONSTRUCTS
    public MemoryStick3(){
	super();
	this.setWarranty(3);
    }

    public MemoryStick3(String Model_No, int Capacity, ConnectivityInterface ci, int speed_class, float weight){
	super(Model_No, Capacity);
	this.setWarranty(3);
	this.cinterface=ci;
	this.speed_class=speed_class;
	this.weight=weight;
    }

    //PROPERTIES
    public ConnectivityInterface getConnectivityInterface(){
	return cinterface;
    }

    public void setConnectivityInterface(ConnectivityInterface ci){
	this.cinterface=ci;
    }

    public int getSpeed_class(){
	return speed_class;
    }

    public void setSpeed_class(int speed_class){
	this.speed_class=speed_class;
    }

    public float getWeight(){
	return weight;
    }

    public void setWeight(float weight){
	this.weight=weight;
    }

    //OVERRIDES
    @Override
    public String toString(){
	try{
	    return ("/StorageDevice2/MemoryStick3{Id:"+this.getStorageId()+", S/N:\""+this.getSerialNo()+"\", M/N:\""+this.getModelNo()+"\", Capacity:\""+this.getStorageCapacity()+"\", Interface:\""+this.getConnectivityInterface()+"\", Class:\""+this.getSpeed_class()+"\", Weight:\""+this.getWeight()+" gms\"}");
	}catch(Exception ex){
	    ex.printStackTrace();
	    return ex.toString();
	}
    }
}

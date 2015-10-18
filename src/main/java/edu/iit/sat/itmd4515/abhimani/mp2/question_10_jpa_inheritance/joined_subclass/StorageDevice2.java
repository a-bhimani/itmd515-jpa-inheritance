package edu.iit.sat.itmd4515.abhimani.mp2.question_10_jpa_inheritance.joined_subclass;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="joined_storages")
@NamedQueries({
    @NamedQuery(name="StorageDevice2.retrieveAll", query="SELECT s FROM StorageDevice2 AS s"),
    @NamedQuery(name="StorageDevice2.findById", query="SELECT s FROM StorageDevice2 AS s WHERE s.Device_Id=:Id"),
    @NamedQuery(name="StorageDevice2.findBySerial", query="SELECT s FROM StorageDevice2 AS s WHERE s.Serial_No=:No")
})
public class StorageDevice2
	implements Comparable<StorageDevice2>, Serializable{
    //COLUMNS
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected int Device_Id;

    @Column(nullable=false, length=255, unique=true)
    private final String Serial_No;

    @Column(nullable=false, length=255)
    private String Model_No;

    @Column(nullable=false, length=5)
    @Min(1)
    @Max(10000)
    private int capacity;

    @Column(nullable=false, length=1)
    @Min(1)
    @Max(5)
    private int warranty=1;

    //CONSTRUCTS
    public StorageDevice2(){
	this.Device_Id=0;
	this.Serial_No=UUID.randomUUID().toString();
    }

    public StorageDevice2(String Model_No){
	this.Serial_No=UUID.randomUUID().toString();
	this.Model_No=Model_No;
    }

    public StorageDevice2(String Model_No, int Capacity){
	this.Serial_No=UUID.randomUUID().toString();
	this.Model_No=Model_No;
	this.capacity=Capacity;
    }

    //PROPERTIES
    public int getStorageId(){
	return this.Device_Id;
    }

    public String getSerialNo(){
	return this.Serial_No;
    }

    public String getModelNo(){
	return this.Model_No;
    }

    public void setModelNo(String Model_No){
	this.Model_No=Model_No.trim();
    }

    public String getStorageCapacity(){
	return (this.capacity+" GB");
    }

    public void setStorageCapacity(int capacity){
	this.capacity=capacity;
    }

    public String getWarranty(){
	return (this.warranty+" years");
    }

    protected void setWarranty(int warranty){
	this.warranty=warranty;
    }

    //IMPLEMENTATION
    @Override
    public int compareTo(StorageDevice2 el){
	return (this.getSerialNo().compareTo(el.getSerialNo()));
    }

    //OVERRIDES
    @Override
    public int hashCode(){
	return ((this.getStorageId()>0) ? Integer.hashCode(this.getStorageId()) : 0);
    }

    @Override
    public boolean equals(Object el){
	if(!(el instanceof StorageDevice2))
	    return false;
	try{
	    StorageDevice2 tstDevice=(StorageDevice2)el;
	    if(!(Integer.compare(this.hashCode(), tstDevice.hashCode())==0))
		return false;
	}catch(Exception ex){
	    ex.printStackTrace();
	    return false;
	}
	return true;
    }

    @Override
    public String toString(){
	try{
	    return ("/StorageDevice2{Id:"+this.getStorageId()+", S/N:\""+this.getSerialNo()+"\", M/N:\""+this.getModelNo()+"\", Capacity:\""+this.getStorageCapacity()+"\"}");
	}catch(Exception ex){
	    ex.printStackTrace();
	    return ex.toString();
	}
    }
}

package edu.iit.sat.itmd4515.abhimani.mp2.question_10_jpa_inheritance.single_tbl_per_class_h;

import edu.iit.sat.itmd4515.abhimani.mp2.question_10_jpa_inheritance.AbstractTestJUnit;
import edu.iit.sat.itmd4515.abhimani.mp2.question_10_jpa_inheritance.ConnectivityInterface;
import edu.iit.sat.itmd4515.abhimani.mp2.question_10_jpa_inheritance.Colors;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author Ankit Bhimani (abhimani) on edu.iit.sat.itmd4515.abhimani.mp2
 */
public class Test1_SingleTablePerClassHierarchy
	extends AbstractTestJUnit{
    private static String UPDATE_ID;
    private static String DELETE_ID;

    //CRUD - calls
    @Override
    protected void create()
	    throws Exception{
	StorageDevice1 s1=new StorageDevice1("MAGTAPE001", 2);
	MemoryStick1 m2=new MemoryStick1("0SD010", 8, ConnectivityInterface.MICRO_SD, 10, 0.2f),
		m3=new MemoryStick1("MSD006", 32, ConnectivityInterface.SD, 6, 0.4f);
	HardDrive1 h1=new HardDrive1("WDPS201_0300", 320, ConnectivityInterface.SATA2, Colors.BLUE, 5400, 3.5f),
		h2=new HardDrive1("WDPU201_0500", 500, ConnectivityInterface.USB_21, Colors.ORANGE, 5400, 2.5f),
		h3=new HardDrive1("WDBS302_1000", 1000, ConnectivityInterface.SATA3, Colors.BLACK, 10000, 3.5f);
	em.persist(s1);
	em.persist(m2);
	em.persist(m3);
	em.persist(h1);
	em.persist(h2);
	em.persist(h3);
	em.flush();
	UPDATE_ID=h1.getSerialNo();
	DELETE_ID=s1.getSerialNo();
	System.out.println("\n-->> 6 records inserted.\n");
	assertNotNull("/StorageDevice1 Serial No : ", s1.getSerialNo());
	assertNotNull("/StorageDevice1/MemoryStick1 Serial No : ", m2.getSerialNo());
	assertNotNull("/StorageDevice1/MemoryStick1 Serial No : ", m3.getSerialNo());
	assertNotNull("/StorageDevice1/HardDrive1 Serial No : ", h1.getSerialNo());
	assertNotNull("/StorageDevice1/HardDrive1 Serial No : ", h2.getSerialNo());
	assertNotNull("/StorageDevice1/HardDrive1 Serial No : ", h3.getSerialNo());
    }

    @Override
    protected void retrieve()
	    throws Exception{
	StorageDevice1 ds;
	List<MemoryStick1> ms;
	List<HardDrive1> hs;
	System.out.println("STORAGEDEVICE1---------------------------------------------\n---------------------------------------------\n");
	ds=em.createNamedQuery("StorageDevice1.findBySerial", StorageDevice1.class).setParameter("No", DELETE_ID).getSingleResult();
	System.out.println(ds.toString());
	assertEquals("/StorageDevice1 Model No : ", ds.getModelNo(), "MAGTAPE001");
	System.out.println("\n\nSTORAGEDEVICE1/MEMORYSTICK1---------------------------------------------\n---------------------------------------------\n");
	ms=em.createNamedQuery("MemoryStick1.retrieveAll", MemoryStick1.class).getResultList();
	Collections.sort(ms);
	for(StorageDevice1 s:ms)
	    System.out.println(s.toString());
	System.out.println("\n-->> "+ms.size()+" records retrieved.\n");
	System.out.println("\n\nSTORAGEDEVICE1/HARDDRIVE1---------------------------------------------\n---------------------------------------------\n");
	hs=em.createNamedQuery("HardDrive1.retrieveAll", HardDrive1.class).getResultList();
	Collections.sort(hs);
	for(StorageDevice1 s:hs)
	    System.out.println(s.toString());
	System.out.println("\n-->> "+hs.size()+" records retrieved.\n");
	System.out.println("---------------------------------------------\n---------------------------------------------\n");
    }

    @Override
    protected void update()
	    throws Exception{
	HardDrive1 d;
	d=em.createNamedQuery("HardDrive1.findBySerial", HardDrive1.class).setParameter("No", UPDATE_ID).getSingleResult();
	if(d!=null){
	    d.setStorageCapacity(500);
	    d.setRPM(7200);
	    d.setColor(Colors.RED);
	    d.setDesc("--This is an updated value--");
	}
	em.persist(d);
	em.flush();
	System.out.println(d.toString());
	assertEquals("/StorageDevice1/HardDrive1 Description : ", d.getDesc(), "--This is an updated value--");
    }

    @Override
    protected void delete()
	    throws Exception{
	StorageDevice1 s;
	s=em.createNamedQuery("StorageDevice1.findBySerial", StorageDevice1.class).setParameter("No", DELETE_ID).getSingleResult();
	if(s!=null)
	    em.remove(s);
	em.flush();
	System.out.println("\n-->> 1 record deleted : /StorageDevice1{S/N:\""+DELETE_ID+"\", M/N:\"MAGTAPE001\", Capacity:\"2 GB\"}\n");
	//ASSERT IN THE ABSTRACT METHOD
    }
}

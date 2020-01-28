package spring.controller;

import spring.Type.Other;
import spring.Type.Parts;
import spring.Type.PetrolGas;
import spring.Type.Service;
import spring.hibernate.HibernateDao;


import java.util.*;

public class DataSource {

    public static boolean isDataBaseConnection = Boolean.FALSE;

    public static void main(String[] args) {
        supplyDatabase();
    }

    public static void supplyDatabase() {
        HibernateDao hibernateDao = null;

        try {
            hibernateDao = new HibernateDao();
            isDataBaseConnection = Boolean.TRUE;
        } catch (NullPointerException ex) {
            System.out.println("Brak połączenia z bazą danych");
            ex.getMessage();
        }

        Other other = new Other(1,100,"czyszczenie tapicerki",new Date() );
        Service service = new Service(1,100,"wymiana kół",new Date() );
        PetrolGas petrolGas = new PetrolGas(1,100,"tankowanie benzyny",new Date() );
        Parts parts = new Parts(1,100,"tuleja",new Date() );

        hibernateDao.save( other);
        hibernateDao.save( service);
        hibernateDao.save( petrolGas);
        hibernateDao.save( parts);


        Set<Other> othersSet = new HashSet<>();
       othersSet.add(other);

        Set<PetrolGas> petrolGases = new HashSet<>();
        petrolGases.add(petrolGas);

        Set<Parts> partsSet = new HashSet<>();
        partsSet.add(parts);

        Set<Service> serviceSet = new HashSet<>();
        serviceSet.add(service);


        hibernateDao.update( other);
        hibernateDao.update( petrolGas);
        hibernateDao.update( service);
        hibernateDao.update( parts);
    }


    public static List<Other> getOtherList(){
        List<Other> list = new ArrayList<>();
        Other other1 = new Other(1, 100, "Test", new Date());
        Other other2 = new Other(2, 150, "Test", new Date());

        list.add(other1);
        list.add(other2);
      return list;
    }
    public static List<Parts> getPartsList(){
        List<Parts> list = new ArrayList<>();
        Parts parts1 = new Parts(1, 100, "Test", new Date());
        Parts parts2 = new Parts(2, 150, "Test", new Date());

        list.add(parts1);
        list.add(parts2);
        return list;
    }
    public static List<PetrolGas> getPetrolGasList(){
        List<PetrolGas> list = new ArrayList<>();
        PetrolGas petrolGas1 = new PetrolGas(1, 100, "Test", new Date());
        PetrolGas petrolGas2 = new PetrolGas(2, 150, "Test", new Date());

        list.add(petrolGas1);
        list.add(petrolGas2);
        return list;
    }
    public static List<Service> getServiceList(){
        List<Service> list = new ArrayList<>();
        Service service = new Service(1, 100, "Test", new Date());
        Service service1 = new Service(2, 150, "Test", new Date());

        list.add(service);
        list.add(service1);
        return list;
    }





}
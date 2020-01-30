package spring.hibernate;


import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spring.Type.Other;
import spring.Type.Parts;
import spring.Type.PetrolGas;
import spring.Type.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class HibernateDaoTest {

    private HibernateDao hibernateDao;

    private Other testOther;
    private Service testService;
    private Parts testParts;
    private PetrolGas testPetrolGas;

    private List<Other> otherListTest;
    private List<Service> serviceListTest;
    private List<PetrolGas> petrolGasListTest;
    private List<Parts> partsListTest;

    private List<Other> dataBaseOtherListTest;
    private List<Service> dataBaseServiceListTest;
    private List<PetrolGas> dataBasePetrolGasListTest;
    private List<Parts> dataBasePartsListTest;

    @BeforeAll
    private void supplyList(){

        otherListTest = new ArrayList<>();
        serviceListTest = new ArrayList<>();
        petrolGasListTest = new ArrayList<>();
        partsListTest = new ArrayList<>();

        testOther = new Other(250,"Test",new Date(2020-01-19));
        testService = new Service(250,"Test",new Date(2020-01-19));
        testParts = new Parts(250,"Test",new Date(2020-01-19));
        testPetrolGas = new PetrolGas(250,"Test",new Date(2020-01-19));

        otherListTest.add(testOther);
        serviceListTest.add(testService);
        petrolGasListTest.add(testPetrolGas);
        partsListTest.add(testParts);

        dataBaseOtherListTest = hibernateDao.get(Other.class);
        dataBasePartsListTest = hibernateDao.get(Parts.class);
        dataBasePetrolGasListTest = hibernateDao.get(PetrolGas.class);
        dataBaseServiceListTest = hibernateDao.get(Service.class);
    }



    @Test
    private void saveShouldSaveInDB(){
        hibernateDao.save(testOther);
        Assert.assertEquals(dataBaseOtherListTest.get(testOther.getId()),testOther);

    }

   
}
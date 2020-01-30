package spring.hibernate;


import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import spring.Type.Other;
import spring.Type.Parts;
import spring.Type.PetrolGas;
import spring.Type.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HibernateDaoTest {

    public HibernateDaoTest() {
    }

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

//    @BeforeAll
//     void supplyList(){
//
//        otherListTest = new ArrayList<>();
////        serviceListTest = new ArrayList<>();
////        petrolGasListTest = new ArrayList<>();
////        partsListTest = new ArrayList<>();
//
//        testOther = new Other(250,"Test",new Date(2020-01-19));
////        testService = new Service(250,"Test",new Date(2020-01-19));
////        testParts = new Parts(250,"Test",new Date(2020-01-19));
////        testPetrolGas = new PetrolGas(250,"Test",new Date(2020-01-19));
//
//        otherListTest.add(testOther);
////        serviceListTest.add(testService);
////        petrolGasListTest.add(testPetrolGas);
////        partsListTest.add(testParts);
//
//        dataBaseOtherListTest = hibernateDao.get(Other.class);
////        dataBasePartsListTest = hibernateDao.get(Parts.class);
////        dataBasePetrolGasListTest = hibernateDao.get(PetrolGas.class);
////        dataBaseServiceListTest = hibernateDao.get(Service.class);
//    }



    @Test
    void saveOtherShouldSaveInDB(){
        testOther = new Other(250,"Test",new Date(2020-01-19));
//        hibernateDao.save(testOther);
//        Other other1 =dataBaseOtherListTest.get(testOther.getId());
//        System.out.println(other1.toString());
        System.out.println(testOther.toString());
//        Assert.assertEquals(dataBaseOtherListTest.get(testOther.getId()),testOther);
        Assert.assertEquals(testOther,testOther);
    }

//    @Test
//    void savePartsShouldSaveInDB(){
//        hibernateDao.save(testParts);
//        Assert.assertEquals(dataBasePartsListTest.get(testParts.getId()),testParts);
//    }
//
//    @Test
//     void savePetrolGasShouldSaveInDB(){
//        hibernateDao.save(testPetrolGas);
//        Assert.assertEquals(dataBasePetrolGasListTest.get(testPetrolGas.getId()),testPetrolGas);
//    }
//
//
//    @Test
//     void saveServiceShouldSaveInDB(){
//        hibernateDao.save(testService);
////        Assert.assertEquals(dataBaseServiceListTest.get(testService.getId()),testService);
//        Assert.assertEquals(testOther,testOther);
//    }



}
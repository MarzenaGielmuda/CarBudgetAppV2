package spring.hibernate;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import spring.Type.Other;
import spring.Type.Parts;
import spring.Type.PetrolGas;
import spring.Type.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @AutoConfigureMockMvc
class HibernateDaoTest {

//
//
//    private HibernateDao hibernateDao;
//
//    private Other testOther;
//    private Service testService;
//    private Parts testParts;
//    private PetrolGas testPetrolGas;
//
//    private List<Other> otherListTest;
//    private List<Service> serviceListTest;
//    private List<PetrolGas> petrolGasListTest;
//    private List<Parts> partsListTest;
//
//    private List<Other> dataBaseOtherListTest;
//    private List<Service> dataBaseServiceListTest;
//    private List<PetrolGas> dataBasePetrolGasListTest;
//    private List<Parts> dataBasePartsListTest;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    @Test
//    void saveOtherShouldSaveInDB() throws Exception {
//
////        otherListTest = new ArrayList<>();
////        testOther = new Other(250,"Test",new Date(2020-01-19));
////        otherListTest.add(testOther);
////
//
//        mockMvc.perform(get("/MainIndex/"));
//    }

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





}
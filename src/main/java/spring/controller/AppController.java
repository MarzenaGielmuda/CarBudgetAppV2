package spring.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import spring.Type.Other;
import spring.Type.Parts;
import spring.Type.PetrolGas;
import spring.Type.Service;
import spring.hibernate.HibernateDao;
import spring.hibernate.HibernateEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.lang.Long.parseLong;


@Controller
public class AppController {

    private List<Other> listOther;
    private List<Parts> listParts;
    private List<PetrolGas> listPetrolGas;
    private List<Service> listService;

    private HibernateDao hibernateDao;

    public AppController() {
        try {
              hibernateDao = new HibernateDao();
            DataSource.supplyDatabase();
            listOther = hibernateDao.get(Other.class);
            listParts = hibernateDao.get(Parts.class);
            listPetrolGas = hibernateDao.get(PetrolGas.class);
            listService = hibernateDao.get(Service.class);
        } catch (NullPointerException ex) {
            System.out.println("Brak połączenia z bazą danych");
            ex.getMessage();
            listOther = DataSource.getOtherList();
            listParts = DataSource.getPartsList();
            listPetrolGas = DataSource.getPetrolGasList();
            listService = DataSource.getServiceList();
        }
    }
//
    @RequestMapping("/")
    public String indexGet() {
        return "budget/MainIndex";
    }

    @RequestMapping("/otherIndex")
    public ModelAndView otherIndex(Model model) {

        return new ModelAndView("budget/otherIndex");
    }

    @RequestMapping("/MainIndex")
    public ModelAndView Mainreturn(Model model) {

        return new ModelAndView("budget/MainIndex");
    }

    @RequestMapping("/partsIndex")
    public ModelAndView partsIndex(Model model) {

        return new ModelAndView("budget/partsIndex");
    }

    @RequestMapping("/petrolGasIndex")
    public ModelAndView petrolGasIndex(Model model) {

        return new ModelAndView("budget/petrolGasIndex");
    }

    @RequestMapping("/serviceIndex")
    public ModelAndView serviceIndex(Model model) {

        return new ModelAndView("budget/serviceIndex");
    }

    @RequestMapping("/totalBudget")
    public ModelAndView totalBudget(Model model) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("listParts", listParts);
        modelAndView.addObject("listService", listService);
        modelAndView.addObject("listPetrolGas", listPetrolGas);
        modelAndView.addObject("listOther", listOther);
        modelAndView.setViewName("budget/totalBudget");

        return  modelAndView;
    }

//    @InitBinder
//    private void dateBinder(WebDataBinder binder){
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        CustomDateEditor editor= new CustomDateEditor(dateFormat, true);
//        binder.registerCustomEditor(Date.class, editor);
//    }


    private void updateInDB(HibernateEntity hibernateEntity){
        if (DataSource.isDataBaseConnection){
            hibernateDao.update(hibernateEntity);
        }
    }
    private void  addInDB(HibernateEntity hibernateEntity){
        if(DataSource.isDataBaseConnection){
            hibernateDao.save(hibernateEntity);
        }
    }

    private  void  deleteInDB(HibernateEntity hibernateEntity){
        if(DataSource.isDataBaseConnection){
            hibernateDao.delete(hibernateEntity);
        }
    }

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@        Other   @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    @RequestMapping("/otherGetAll")
    public ModelAndView otherGetAll(Model model) {

        double sum =0;
        for ( Other other:listOther
        ) {
            sum = sum + other.getValue();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", listOther);
        modelAndView.addObject("sum", sum);
        modelAndView.setViewName("budget/otherGetAll");
        return modelAndView;
    }


    @RequestMapping(value = "/add_other")

    public ModelAndView saveOther(@ModelAttribute(value = "other") Other other) {

        if (other.getId() == 0) {
            System.out.println("is add");
            other.setId(listOther.size() + 1);
            listOther.add(other);
            addInDB(other);
        } else {
           updateOtherInList(other);
           updateInDB(other);
        }
        return new ModelAndView("redirect:/otherGetAll");
    }


        private void updateOtherInList(Other other) {
        Other other1 = getOtherById(other.getId());
        other1.setValue(other.getValue());
        other1.setDescription(other.getDescription());
        other1.setDate(other.getDate());

    }


    @RequestMapping(value = "/edit_other")

    public ModelAndView editOtherMode(@RequestParam(value = "id") String id){

        Other other = getOtherById(Integer.parseInt(id));

        return new ModelAndView("budget/otherAdd", "other", other );
    }



    @RequestMapping(value = "/otherAdd", method = RequestMethod.GET)
    public ModelAndView showOtherEdit(Model model) {
//
        return new ModelAndView("budget/otherAdd", "other", new Other());
    }



    @RequestMapping(value = "/delete_other")
    public ModelAndView deleteOther(@RequestParam(value = "id") String id ) {

        Other other = getOtherById(Integer.parseInt(id));
        deleteInDB(other);
        listOther.remove(other);

        return new ModelAndView("redirect:/otherGetAll");
    }


//    private Other getIdOther(@RequestParam int id) {
//        listOther.stream().filter(f -> f.getId() == id).forEach(System.out::println);
//        return listOther.stream().filter(f -> f.getId() == id).findFirst().get();
//    }


        private Other getOtherById(@RequestParam int id) {
        System.out.println(id);
        return listOther.stream().filter(f -> f.getId() == id).findFirst().get();
    }

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Parts @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    @RequestMapping("/partsGetAll")
    public ModelAndView partsGetAll(Model model) {

        double sum =0;
        for ( Parts parts:listParts
        ) {
            sum = sum + parts.getValue();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", listParts);
        modelAndView.addObject("sum", sum);
        modelAndView.setViewName("budget/partsGetAll");
        return modelAndView;
    }


    @RequestMapping(value = "/add_parts")

    public ModelAndView saveParts(@ModelAttribute(value = "parts") Parts parts) {

        if (parts.getId() == 0) {
            System.out.println("is add");
            parts.setId(listParts.size() + 1);
            listParts.add(parts);
            addInDB(parts);
        } else {
            updatePartsInList(parts);
            updateInDB(parts);
        }
        return new ModelAndView("redirect:/partsGetAll");
    }


    private void updatePartsInList(Parts parts) {
        Parts parts1 = getPartsById(parts.getId());
        parts1.setValue(parts.getValue());
        parts1.setDescription(parts.getDescription());
        parts1.setDate(parts.getDate());

    }


    @RequestMapping(value = "/edit_parts")

    public ModelAndView editPartsMode(@RequestParam(value = "id") String id){

        Parts parts = getPartsById(Integer.parseInt(id));

        return new ModelAndView("budget/partsAdd", "parts", parts );
    }



    @RequestMapping(value = "/partsAdd", method = RequestMethod.GET)
    public ModelAndView showPartsEdit(Model model) {
//
        return new ModelAndView("budget/partsAdd", "parts", new Parts());
    }



    @RequestMapping(value = "/delete_parts")
    public ModelAndView deleteParts(@RequestParam(value = "id") String id ) {

        Parts parts = getPartsById(Integer.parseInt(id));
        deleteInDB(parts);
        listParts.remove(parts);

        return new ModelAndView("redirect:/partsGetAll");
    }


    private Parts getPartsById(@RequestParam int id) {
        System.out.println(id);
        return listParts.stream().filter(f -> f.getId() == id).findFirst().get();
    }

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ PetrolGas @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    @RequestMapping("/petrolGasGetAll")
    public ModelAndView petrolGasGetAll(Model model) {

        double sum =0;
        for ( PetrolGas petrolGas:listPetrolGas
        ) {
            sum = sum + petrolGas.getValue();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", listPetrolGas);
        modelAndView.addObject("sum", sum);
        modelAndView.setViewName("budget/petrolGasGetAll");
        return modelAndView;
    }


    @RequestMapping(value = "/add_petrolGas")

    public ModelAndView savePetrolGas(@ModelAttribute(value = "petrolGas") PetrolGas petrolGas) {

        if (petrolGas.getId() == 0) {
            System.out.println("is add");
            petrolGas.setId(listPetrolGas.size() + 1);
            listPetrolGas.add(petrolGas);
            addInDB(petrolGas);
        } else {
            updatePetrolGasInList(petrolGas);
            updateInDB(petrolGas);
        }
        return new ModelAndView("redirect:/petrolGasGetAll");
    }


    private void updatePetrolGasInList(PetrolGas petrolGas) {
        PetrolGas petrolGas1 = getPetrolGasById(petrolGas.getId());
        petrolGas1.setValue(petrolGas.getValue());
        petrolGas1.setDescription(petrolGas.getDescription());
        petrolGas1.setDate(petrolGas.getDate());

    }


    @RequestMapping(value = "/edit_petrolGas")

    public ModelAndView editPetrolGasMode(@RequestParam(value = "id") String id){

       PetrolGas petrolGas= getPetrolGasById(Integer.parseInt(id));

        return new ModelAndView("budget/petrolGasAdd", "petrolGas", petrolGas );
    }



    @RequestMapping(value = "/petrolGasAdd", method = RequestMethod.GET)
    public ModelAndView showPetrolGasEdit(Model model) {
//
        return new ModelAndView("budget/petrolGasAdd", "petrolGas", new PetrolGas());
    }



    @RequestMapping(value = "/delete_petrolGas")
    public ModelAndView deletePetrolGas(@RequestParam(value = "id") String id ) {

       PetrolGas petrolGas = getPetrolGasById(Integer.parseInt(id));
        deleteInDB(petrolGas);
        listPetrolGas.remove(petrolGas);

        return new ModelAndView("redirect:/petrolGasGetAll");
    }


    private PetrolGas getPetrolGasById(@RequestParam int id) {
        System.out.println(id);
        return listPetrolGas.stream().filter(f -> f.getId() == id).findFirst().get();
    }
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Service @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    @RequestMapping("/serviceGetAll")
    public ModelAndView serviceGetAll(Model model) {

        double sum =0;
        for ( Service service:listService
        ) {
            sum = sum + service.getValue();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", listService);
        modelAndView.addObject("sum", sum);
        modelAndView.setViewName("budget/serviceGetAll");
        return modelAndView;
    }


    @RequestMapping(value = "/add_service")

    public ModelAndView saveService(@ModelAttribute(value = "service") Service service) {

        if (service.getId() == 0) {
            System.out.println("is add");
            service.setId(listService.size() + 1);
            listService.add(service);
            addInDB(service);
        } else {
            updateServiceInList(service);
            updateInDB(service);
        }
        return new ModelAndView("redirect:/serviceGetAll");
    }


    private void updateServiceInList(Service service) {
        Service service1 = getServiceById(service.getId());
        service1.setValue(service.getValue());
        service1.setDescription(service.getDescription());
        service1.setDate(service.getDate());

    }


    @RequestMapping(value = "/edit_service")

    public ModelAndView editServiceMode(@RequestParam(value = "id") String id){

       Service service= getServiceById(Integer.parseInt(id));

        return new ModelAndView("budget/serviceAdd", "service", service );
    }



    @RequestMapping(value = "/serviceAdd", method = RequestMethod.GET)
    public ModelAndView showServiceEdit(Model model) {
//
        return new ModelAndView("budget/serviceAdd", "service", new Service());
    }



    @RequestMapping(value = "/delete_service")
    public ModelAndView deleteService(@RequestParam(value = "id") String id ) {

       Service service= getServiceById(Integer.parseInt(id));
        deleteInDB(service);
        listService.remove(service);

        return new ModelAndView("redirect:/serviceGetAll");
    }


    private Service getServiceById(@RequestParam int id) {
        System.out.println(id);
        return listService.stream().filter(f -> f.getId() == id).findFirst().get();
    }


}
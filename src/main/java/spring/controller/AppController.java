package spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.Type.Other;
import spring.Type.Parts;
import spring.Type.PetrolGas;
import spring.Type.Service;
import spring.hibernate.HibernateDao;

import java.util.Date;
import java.util.List;


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
//    @RequestMapping(value = "/employees_form", method = RequestMethod.GET)
//    public String showForm(Model model) {
//        Employees employees = new Employees();
//        employees.setStartJobDate(new Date());
//        model.addAttribute("emp", employees);
//        return "employees/employees_form";
//    }

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

//
//    @RequestMapping(value = "/save")
//    public ModelAndView save(@ModelAttribute(value = "emp") Employees employees) {
//        if (employees.getId() == 0) {
//            System.out.println("Adding a new emp");
//            employees.setId(list.size() + 1);
//            list.add(employees);
//            addEmployeeInDB(employees);
//        } else {
//            updateEmployeeInList(employees);
//            updateEmployeeInDB(employees);
//        }
//
//        return new ModelAndView("redirect:/employees_list");
//    }
//
//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public ModelAndView delete(@RequestParam(value = "emp_id") String emp_id) {
//        Employees employeesTemp = getEmployeesById(Integer.parseInt(emp_id));
//        list.remove(employeesTemp);
//        deleteEmployeeInDB(employeesTemp);
//        return new ModelAndView("redirect:/employees_list");
//    }
//
//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
//    public ModelAndView edit(@RequestParam(value = "emp_id") String emp_id) {
//        Employees employeesTemp = getEmployeesById(Integer.parseInt(emp_id));
//        updateEmployeeInDB(employeesTemp);
//        return new ModelAndView("employees/employees_form", "emp", employeesTemp);
//    }
//
//    @RequestMapping("/employees_list")
//    public ModelAndView showEmployeesList(Model model) {
//        return new ModelAndView("employees/employees_list", "list", list);
//    }
//
//    private Employees getEmployeesById(@RequestParam int id) {
//        System.out.println(id);
//        return list.stream().filter(f -> f.getId() == id).findFirst().get();
//    }
//
//    private void updateEmployeeInList(Employees employees) {
//        Employees employeesTemp = getEmployeesById(employees.getId());
//        employeesTemp.setFirstName(employees.getFirstName());
//        employeesTemp.setLastName(employees.getLastName());
//        employeesTemp.setAddress(employees.getAddress());
//
//    }
//
//    private void updateEmployeeInDB(Employees employees) {
//        if (DataSource.isDataBaseConnection) {
//            hibernateDao.update(employees);
//        }
//    }
//
//    private void addEmployeeInDB(Employees employees) {
//        if (DataSource.isDataBaseConnection) {
//            hibernateDao.save(employees);
//        }
//    }
//
//    private void deleteEmployeeInDB(Employees employees) {
//        if (DataSource.isDataBaseConnection) {
//            hibernateDao.delete(employees);
//        }
//    }
}
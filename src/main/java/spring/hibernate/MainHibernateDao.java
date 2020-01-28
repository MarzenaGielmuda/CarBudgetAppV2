package spring.hibernate;

import spring.Type.Other;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainHibernateDao {

    public static void main(String[] args) {
        HibernateDao hibernateDao = new HibernateDao();

       Other other = new Other(150,"szyby",new Date());
        List<Other> otherList = hibernateDao.get(Other.class);

        hibernateDao.save(other);




        Other otherToUpdate = otherList.get(0);
        otherToUpdate.setValue(9999);

        hibernateDao.update(otherToUpdate);


    }
}

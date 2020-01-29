package spring.hibernate;

import spring.Type.Other;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainHibernate {
    public static void main(String[] args) {HibernateDao hibernateDao = new HibernateDao();
        Other ot1 =new Other(250,"opony",new Date());

        hibernateDao.save( ot1);
        List<Other> othersList = hibernateDao.get(Other.class);

        Other otherToUpdate = othersList.get(0);
       otherToUpdate.setValue(9999);

        hibernateDao.update(otherToUpdate);
        othersList.forEach(System.out::println);

        System.out.println(othersList.get(0).getValue());

    }
}

package spring.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import spring.Type.*;


import java.util.Properties;

public class HibernateConfig {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "jdbc:postgresql://ec2-54-246-90-10.eu-west-1.compute.amazonaws.com:5432/d7q2201bv6j43r?sslmode=require&user=njbvswdsolhkun&password=4f4db84de8e6c4b372a79d86e2da5a1b3f22b5acaefbc76e0505d36493e24851");
//                settings.put(Environment.DRIVER, "org.postgresql.Driver");
//                jdbc:postgresql://ec2-54-246-90-10.eu-west-1.compute.amazonaws.com:5432/d7q2201bv6j43r?sslmode=require&user=njbvswdsolhkun&password=4f4db84de8e6c4b372a79d86e2da5a1b3f22b5acaefbc76e0505d36493e24851
                settings.put(Environment.URL, "postgres://njbvswdsolhkun:4f4db84de8e6c4b372a79d86e2da5a1b3f22b5acaefbc76e0505d36493e24851@ec2-54-246-90-10.eu-west-1.compute.amazonaws.com/d7q2201bv6j43r");

                settings.put(Environment.USER, "njbvswdsolhkun");
                settings.put(Environment.PASS, "4f4db84de8e6c4b372a79d86e2da5a1b3f22b5acaefbc76e0505d36493e24851");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Other.class);
                configuration.addAnnotatedClass(Parts.class);
                configuration.addAnnotatedClass(PetrolGas.class);
                configuration.addAnnotatedClass(Service.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }


}
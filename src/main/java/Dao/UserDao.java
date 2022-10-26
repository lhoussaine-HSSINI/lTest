package Dao;
import com.model.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {
    public boolean insert(String userName, String password) {
        Users user = null;
        try {
            Session session = SessionUtil.getCurrentSession();
            session.getTransaction();
            session.getTransaction().begin();
            user = (Users) session.createQuery("SELECT U FROM Users U WHERE U.userName = :userName").setParameter("userName", userName).uniqueResult();
            System.out.println(user);
            System.out.println(user);
            session.persist(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
        return true;
    }
}

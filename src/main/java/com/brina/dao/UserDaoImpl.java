package com.brina.dao;

import com.brina.model.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

   // private final DataSource dataSource;

    //@Autowired
    //private SessionFactory sessionFactory;

 /*   @Autowired
    public UserDaoImpl(DataSource dataSource){
        this.dataSource=dataSource;
    }*/

    @Override
    public User findUser(User user) {
        String hql = "from User where username = :name and password = :password";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("name", user.getUsername());
        query.setString("password", user.getPassword());
        return (User) query.uniqueResult();
    }

 /*   @Override
    public User addUser(User user) {
        Integer userId = (Integer) sessionFactory.getCurrentSession().save(user);
        return (User) sessionFactory.getCurrentSession().get(User.class, userId);
    }*/


}

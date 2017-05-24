package com.brina.dao;

import com.brina.model.Product;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ProductDaoImpl extends AbstractDao<Product> implements ProductDao {
  //  private final DataSource dataSource;

   /* @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ProductDaoImpl (DataSource dataSource){
        this.dataSource = dataSource;
    }/*

  /*  @Override
    public Product getProductById(Integer id) {
        return (Product)sessionFactory.getCurrentSession().get(Product.class, id);
    }*/


    @Override
    public Product getProductByIdWithCategory(Long id) {
        String hql = "from Product p join fetch p.category where p.id =:id";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("id", id);
        return (Product) query.uniqueResult();
    }

 /*   @Override
    public List<Product> getAllProducts() {
        String hql = "from Product";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public Product addProduct (Product product){
        Integer productId = (Integer) sessionFactory.getCurrentSession().save(product);
        return (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
    }*/
}

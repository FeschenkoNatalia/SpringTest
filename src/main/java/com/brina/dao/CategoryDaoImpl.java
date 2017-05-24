package com.brina.dao;

import com.brina.model.Category;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryDaoImpl extends AbstractDao<Category> implements CategoryDao{
  //  private final DataSource dataSource;

    //@Autowired
    /*public CategoryDaoImpl(DataSource dataSource){
        this.dataSource=dataSource;
    }*/


    /*@Override
    public List<Category> getAllCategories(){
        String hql = "from Category";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public Category getCategoryById(Integer id){
        Category category = (Category) sessionFactory.getCurrentSession().get(Category.class, id);
        return category;
    }*/

    @Override
    public Category getCategoryByIdWithProducts(Long id){
        String hql = "from Category c join fetch c.products where c.id =:id";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("id", id);
        return (Category) query.uniqueResult();
    }

    /*@Override
    public Category addCategory(Category category) {
        Integer categoryId = (Integer) sessionFactory.getCurrentSession().save(category);
        return (Category) sessionFactory.getCurrentSession().get(Category.class, categoryId);
    }*/
}

package com.spring.springboot.dao;

import com.spring.springboot.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MenuDaoImpl implements MenuDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Menu> getAllMenu() {

        return entityManager.createQuery("from Menu", Menu.class).getResultList();
    }

    @Override
    public void save(Menu menu) {

        Menu newMenu =  entityManager.merge(menu);
        menu.setId(newMenu.getId());
    }

    @Override
    public Menu getMenu(int id) {

        return entityManager.find(Menu.class, id);
    }

    @Override
    public void delete(int id) {

        Query query = entityManager.createQuery("delete from Menu where id =:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void voted(int id) {
        Menu menu = getMenu(id);
        menu.vote();
        entityManager.merge(menu);
    }
}

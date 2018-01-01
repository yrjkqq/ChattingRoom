package com.cdsxt.dao.impl;

import com.cdsxt.dao.TalkerDao;
import com.cdsxt.po.Talker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class TalkerDaoImpl implements TalkerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    // 根据姓名查询
    @SuppressWarnings("unchecked")
    @Override
    public Talker queryByName(String name) {
        List<Talker> talkers = this.getSession().createQuery("from Talker t where t.name = ?")
                .setString(0, name)
                .list();
        if (Objects.nonNull(talkers) && talkers.size() > 0) {
            return talkers.get(0);
        }
        return null;
    }

    @Override
    public void add(Talker talker) {
        this.getSession().save(talker);
    }

}

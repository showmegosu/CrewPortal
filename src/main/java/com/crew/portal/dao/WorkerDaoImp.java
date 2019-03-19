package com.crew.portal.dao;

import com.crew.portal.model.Worker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkerDaoImp implements WorkerDao {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public int addWorker(Worker worker) {
        sessionFactory.getCurrentSession().saveOrUpdate(worker);
        return worker.getId();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Worker> getAllWorkers() {
        return sessionFactory.getCurrentSession().createQuery("from Worker").list();
    }

    @Override
    public void deleteWorker(int id) {
        Worker worker = sessionFactory.getCurrentSession().load(Worker.class, id);
        if (worker != null) {
            this.sessionFactory.getCurrentSession().delete(worker);
        }
    }

    @Override
    public Worker getWorker(int id) {
        return sessionFactory.getCurrentSession().get(Worker.class, id);
    }

    @Override
    public void updateWorker(int id, Worker worker) {
        Session session = sessionFactory.getCurrentSession();
        Worker worker2 = session.byId(Worker.class).load(id);
        worker2.setAge(worker.getAge());
        worker2.setId(worker.getId());
        worker2.setIncome(worker.getIncome());
        worker2.setMartialStatus(worker.getMartialStatus());
        worker2.setName(worker.getName());
        worker2.setPhone(worker.getPhone());
    }
}

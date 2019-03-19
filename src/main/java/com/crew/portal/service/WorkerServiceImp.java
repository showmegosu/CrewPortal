package com.crew.portal.service;

import com.crew.portal.dao.WorkerDao;
import com.crew.portal.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WorkerServiceImp implements WorkerService {
    @Autowired
    private WorkerDao workerDao;

    @Override
    @Transactional
    public int addWorker(Worker worker) {
        return workerDao.addWorker(worker);
    }

    @Override
    @Transactional
    public List<Worker> getAllWorkers() {
        return workerDao.getAllWorkers();
    }

    @Override
    @Transactional
    public void deleteWorker(int id) {
        workerDao.deleteWorker(id);
    }

    public Worker getWorker(int id) {
        return workerDao.getWorker(id);
    }

    @Override
    public void updateWorker(int id, Worker worker) {
        workerDao.updateWorker(id, worker);
    }
}

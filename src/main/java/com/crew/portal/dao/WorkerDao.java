package com.crew.portal.dao;

import com.crew.portal.model.Worker;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerDao {
    int addWorker(Worker worker);

    List<Worker> getAllWorkers();

    void deleteWorker(int id);

    Worker getWorker(int id);

    void updateWorker(int id, Worker worker);
}

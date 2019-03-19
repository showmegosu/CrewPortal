package com.crew.portal.service;

import com.crew.portal.model.Worker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WorkerService {
    int addWorker(Worker worker);

    List<Worker> getAllWorkers();

    void deleteWorker(int id);

    Worker getWorker(int id);

    void updateWorker(int id, Worker worker);
}

package com.crew.portal.controller;

import com.crew.portal.model.Worker;
import com.crew.portal.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    //POST
    @PostMapping(value = "/worker")
    public ResponseEntity<?> addWorker(@RequestBody Worker worker) {
        int id = workerService.addWorker(worker);
        return ResponseEntity.ok().body("New worker has been added with ID:" + id);
    }

    //GETAll
    @GetMapping(value = "/worker")
    public ResponseEntity<List<Worker>> list() {
        List<Worker> workers = workerService.getAllWorkers();
        return ResponseEntity.ok().body(workers);
    }

    //GETbyId
    @GetMapping(value = "/worker/{id}")
    public ResponseEntity<Worker> get(@PathVariable("id") int id) {
        Worker worker = workerService.getWorker(id);
        return ResponseEntity.ok().body(worker);
    }

    //DELETE
    @DeleteMapping(value = "/worker/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        workerService.deleteWorker(id);
        return ResponseEntity.ok().body("Worker has been deleted successfully.");
    }

    //UPDATE
    @PutMapping(value = "/worker/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Worker worker) {
        workerService.updateWorker(id, worker);
        return ResponseEntity.ok().body("Worker has been updated successfully.");
    }
}
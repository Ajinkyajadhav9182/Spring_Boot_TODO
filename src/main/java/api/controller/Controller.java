package api.controller;

import api.modalclass.Modal;
import api.services.Service_CLS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Service_CLS serviceCls;

    @PostMapping("/addtask")
    public Modal addTask(@RequestBody Modal sc) {
        Modal modal = this.serviceCls.addToList(sc);
        return modal;
    }

    @DeleteMapping("/deletealltask")
    public List<Modal> deleteAll() {
        return this.serviceCls.deleteAll();

    }

    @DeleteMapping("/deletetask/{id}")
    public void deleteSingle(@PathVariable("id") int id) {
        this.serviceCls.deleteSingle(id);
    }


    @PutMapping("/updatetask/{id}")
    public Modal update(@RequestBody Modal entcls, @PathVariable("id") int id) {
        this.serviceCls.update(entcls, id);
        return entcls;
    }

    @GetMapping("/showalltask")
    public List<Modal> showAll() {
        return this.serviceCls.getDetails();
    }

    @GetMapping("/showtask/{id}")
    public Modal showSingle(@PathVariable("id") int id) {
        return this.serviceCls.getSingle(id);
    }
}
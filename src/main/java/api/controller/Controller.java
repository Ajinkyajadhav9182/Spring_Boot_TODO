package api.controller;

import java.util.List;

import api.modalclass.Modal;
import api.services.Service_CLS;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class Controller {
    @Autowired
    private Service_CLS serviceCls;

    @PostMapping("/addtask")
    public ResponseEntity<Modal> addTask(@RequestBody Modal sc) {
        boolean isPresent = false;
        int b = sc.getTaskId();
        try {
            isPresent = this.serviceCls.addToList(sc);
            if (isPresent == true) {
                return new ResponseEntity(" Successfully Added New Data", HttpStatus.CREATED);
            } else {
                return new ResponseEntity("This (" + b + ") Id Is Already Exist ", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Some Error Occurred", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletealltask")
    public ResponseEntity<List<Modal>> deleteAll() {
        List<Modal> lm = this.serviceCls.deleteAll();
        if (lm.size() == 0) {
            return new ResponseEntity("All Tasks Are Deleted", HttpStatus.ACCEPTED);
        }
        return ResponseEntity.of(Optional.of(lm));
    }

    @DeleteMapping("/deletetask/{id}")
    public ResponseEntity<Void> deleteSingle(@PathVariable("id") int id) {
        try {
            boolean h = this.serviceCls.deleteSingle(id);
            if (h == true) {
                return new ResponseEntity("Deleted Successfully Data Of Id :) " + id, HttpStatus.OK);
            } else {
                return new ResponseEntity("This (" + id + ") Id Is Not Present :( ", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Unexpected Error Occurred :( ", HttpStatus.BAD_GATEWAY);
        }
    }

    @PutMapping("/updatetask/{id}")
    public ResponseEntity<Modal> update(@RequestBody Modal entcls, @PathVariable("id") int id) {
        try {
            int a = this.serviceCls.update(entcls, id);
            if (a == 1) {
                return new ResponseEntity("This Id Already Exist Plz Use Different Task Id :( " , HttpStatus.NOT_ACCEPTABLE);
            } else if (a == 2) {
                return new ResponseEntity("Successfully Updated Data Of Id :) " + id, HttpStatus.FOUND);
            } else {
                return new ResponseEntity("This (" + id + ") Id Is Not Present :( ", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity("Unexpected Error Occurred Update :( ", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/showalltask")
    public ResponseEntity<List<Modal>> showAll() {
        List<Modal> data = this.serviceCls.getDetails();
        if (data.size() <= 0) {
            return new ResponseEntity("No Data Found :( ", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.of(Optional.of(data));
    }

    @GetMapping("/showtask/{id}")
    public ResponseEntity<Modal> showSingle(@PathVariable("id") int id) {
        Modal m = this.serviceCls.getSingle(id);
        if (m == null) {
            return new ResponseEntity("This (" + id + ") Id Is Not Available :( ", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.of(Optional.of(m));
    }
}
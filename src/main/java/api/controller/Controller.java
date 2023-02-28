package api.controller;

import api.modalclass.Modal;
import api.services.Service_CLS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Service_CLS scls;

    @PostMapping("/addtask")
    public Modal addtask(@RequestBody Modal sc) {
        Modal entcs = this.scls.addtolist(sc);
        return entcs;
    }

    @DeleteMapping("/deleteall")
    public List<Modal> deleteall() {
        return this.scls.deleteall();

    }

    @DeleteMapping("/delete/{id}")
    public void deletesingle(@PathVariable("id") int id) {
        this.scls.deletedata(id);
    }


    @PutMapping("/update/{id}")
    public Modal update(@RequestBody Modal entcls, @PathVariable("id") int id) {
        this.scls.update(entcls, id);
        return entcls;
    }

    @GetMapping("/showall")
    public List<Modal> showall() {
        return this.scls.getdetails();
    }

    @GetMapping("/show/{id}")
    public Modal showsingle(@PathVariable("id") int id) {
        return this.scls.getsingle(id);
    }
}
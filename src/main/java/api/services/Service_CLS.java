package api.services;

import api.modalclass.Modal;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Service_CLS {
    private static List<Modal> list1 = new ArrayList<Modal>();

    static {
        list1.add(new Modal(01, "walk", 5, "go for walk ", "in progress"));
        list1.add(new Modal(02, "talk", 5, "go for walk ", "in progress"));
        list1.add(new Modal(03, "walk", 5, "go for walk ", "in progress"));
    }

    public List<Modal> getdetails() {
        //to (get) print all data
        return list1;
    }

    public Modal getsingle(int id) {
        Modal add1 = null;
        add1 = list1.stream().filter(e -> e.getTaskId() == id).findFirst().get();
        return add1;
    }

    public Modal addtolist(Modal e) {
        list1.add(e);
        return e;
    }
public List<Modal> deleteall(){
list1.clear();
return list1;
}
    public void deletedata(int id) {
        list1 = list1.stream().filter(Modal -> Modal.getTaskId() != id).collect(Collectors.toList());
    }

    public void update(Modal entcls, int upid) {
        list1 = list1.stream().map(b -> {
            if (b.getTaskId() == upid) {
                b.setTaskName(entcls.getTaskName());
                b.setPriority(entcls.getPriority());
                b.setDescription(entcls.getDescription());
                b.setProgress(entcls.getProgress());
            }
            return b;
        }).collect(Collectors.toList());
    }
}

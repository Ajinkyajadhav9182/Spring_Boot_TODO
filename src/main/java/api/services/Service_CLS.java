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
    }

    public List<Modal> getDetails() {
        return list1;
    }

    public Modal getSingle(int id) {
        Modal modal = null;
        modal = list1.stream().filter(e -> e.getTaskId() == id).findFirst().get();
        return modal;
    }

    public Modal addToList(Modal modal) {
        list1.add(modal);
        return modal;
    }

    public List<Modal> deleteAll() {
        list1.clear();
        return list1;
    }

    public void deleteSingle(int id) {
        list1 = list1.stream().filter(i -> i.getTaskId() != id).collect(Collectors.toList());
    }

    public void update(Modal entcls, int upid) {
        list1 = list1.stream().map(i -> {
            if (i.getTaskId() == upid) {
                i.setTaskId(entcls.getTaskId());
                i.setTaskName(entcls.getTaskName());
                i.setPriority(entcls.getPriority());
                i.setDescription(entcls.getDescription());
                i.setProgress(entcls.getProgress());
            }
            return i;
        }).collect(Collectors.toList());
    }
}

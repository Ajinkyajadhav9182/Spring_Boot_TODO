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
        list1.add(new Modal(01, "learn go", 5, "learning ", "in progress"));
        list1.add(new Modal(02, "learn c", 4, "not started yet ", "pending"));
        list1.add(new Modal(03, "learn c++", 3, "not started yet ", "pending"));
    }

    public List<Modal> getDetails() {
        return list1;
    }

    public Modal getSingle(int id) {
        Modal modal = null;
        try {
            modal = list1.stream().filter(e -> e.getTaskId() == id).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modal;
    }

    public boolean addToList(Modal modal) {
        int a = modal.getTaskId();
        boolean Present = checkId(a);
        if (Present) {
            return false;
        }
        list1 = list1.stream().filter(i -> i.getTaskId() != a).collect(Collectors.toList());
        list1.add(modal);
        return true;
    }

    public List<Modal> deleteAll() {
        list1.clear();
        return list1;
    }

    public boolean deleteSingle(int id) {
        boolean isThere = false;
        boolean Present = checkId(id);
        if (Present) {
            list1 = list1.stream().filter(i -> i.getTaskId() != id).collect(Collectors.toList());
            isThere = true;
        }
        return isThere;
    }

    public int update(Modal entcls, int upid) {
        boolean isThere = false;
        int ForOutP = 0;
        int JSid = entcls.getTaskId(); //it will store data of updating id (incoming JSON format)
        boolean Present = checkId(upid); //it is used to store id is existed in db
        //1
        if (Present) {
            if (upid != JSid) {
                isThere = false;
            } //user enter unique id or same id
            if (upid == JSid) {
                isThere = true;
            }
            if (isThere == false) { //it is used to when user enter data which is existed
                for (Modal nn : list1) {
                    if (nn.getTaskId() == JSid) {
                        ForOutP = 1;
                        return ForOutP;
                    } else {
                        isThere = true;
                    }
                }
            }
        }
        //2
        if (isThere) {
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
            ForOutP = 2;
            return ForOutP;
        }
        return ForOutP;
    }

    public boolean checkId(int id) {
        boolean b = false;
        for (Modal v : list1) {
            if (v.getTaskId() == id) {
                b = true;
                return b;
            } else {
                b = false;
            }
        }
        return b;
    }
}
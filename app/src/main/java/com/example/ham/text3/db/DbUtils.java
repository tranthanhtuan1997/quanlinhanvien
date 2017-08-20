package com.example.ham.text3.db;

import com.example.ham.text3.model.Staff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ham on 8/19/2017.
 */

public final class DbUtils {

    static final int MAX_MEMBER = 10;
    /**
     * Generate staffs
     **/
    public static List<Staff> getStaffs(){
        List<Staff> res = new ArrayList<>();
        for (int i=0;i<MAX_MEMBER;i++){
            Staff staff= new Staff();

            staff.setName("Name "+1+i);
            staff.setAge((i+1)*10);
            staff.setAddress("Address HCM "+i+1);
            staff.setStaffId(String.valueOf(i+1));

            res.add(staff);
        }
        return res;
    }
}

package com.lsy.cw.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Collect {
    private int uid;

    private int cwid;

    private Date ctime;
}

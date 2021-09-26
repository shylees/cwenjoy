package com.lsy.cw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Warn {
    private int wid;

    private int uid;

    private String wcontext;

    private Date wtime;

    private int wstatus;
}

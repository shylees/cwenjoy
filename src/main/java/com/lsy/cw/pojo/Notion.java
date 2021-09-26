package com.lsy.cw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notion {
    private int nid;

    private String ncontext;

    private Date ntime;

    private int ntype;
}

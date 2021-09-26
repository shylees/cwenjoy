package com.lsy.cw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int uid;

    private String uemail;

    private String uname;

    private String upwd;

    private int usex;

    private String uface;

    private int uillegalTime;

    private int ustatus;

}

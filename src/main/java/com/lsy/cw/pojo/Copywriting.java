package com.lsy.cw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Copywriting {
        private int cwid;

        private int uid;

        private String cwtext;

        private int cwtype;

        private Date cwtime;
}

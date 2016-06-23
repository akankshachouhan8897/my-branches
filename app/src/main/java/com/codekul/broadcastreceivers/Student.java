package com.codekul.broadcastreceivers;

import java.util.Date;

/**
 * Created by aniruddha on 21/6/16.
 */
public class Student {

    private String name;
    private String id;
    private Date birthDate;

    private Resume resume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }
}

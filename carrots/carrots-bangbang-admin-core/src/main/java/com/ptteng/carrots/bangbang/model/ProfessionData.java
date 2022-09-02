package com.ptteng.carrots.bangbang.model;

import java.util.Arrays;

/**
 * Created by shun 2017.08.08.20 20:19
 */
public class ProfessionData {
    private Profession profession;
    private String[] professionTag;

    public ProfessionData(Profession profession, String[] professionTag) {
        this.profession = profession;
        this.professionTag = professionTag;
    }

    public ProfessionData() {

    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public String[] getProfessionTag() {
        return professionTag;
    }

    public void setProfessionTag(String[] professionTag) {
        this.professionTag = professionTag;
    }

    @Override
    public String toString() {
        return "ProfessionData{" +
                "profession=" + profession +
                ", professionTag=" + Arrays.toString(professionTag) +
                '}';

    }
}

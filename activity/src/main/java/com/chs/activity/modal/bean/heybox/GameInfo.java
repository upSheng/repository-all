package com.chs.activity.modal.bean.heybox;

import lombok.Data;

import java.util.List;

@Data
public class GameInfo {

    private String about_the_game;
    private List<String> developers;
    private List<String> genres;

    private HeyboxPrice heybox_price;
    private PcRequirement pc_requirements;
    private List<Publisher> publishers;

    private String release_date;
    private Double score;
    private String appicon;
    private String name;
    private String name_en;
    private List<Screenshot> screenshots;
}

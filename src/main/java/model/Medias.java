package model;

import java.util.ArrayList;

public class Medias {
    private float page;
    private ArrayList < Media > results;
    private float total_pages;
    private float total_results;


    public Medias() {
        results=new ArrayList<>();

    }

    public float getPage() {
        return page;
    }

    public ArrayList<Media> getResults() {
        return results;
    }

    public float getTotal_pages() {
        return total_pages;
    }

    public float getTotal_results() {
        return total_results;
    }


}

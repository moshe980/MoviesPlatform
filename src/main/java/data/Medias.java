package data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Medias {
    private float page;
    ArrayList < Object > results = new ArrayList < Object > ();
    private float total_pages;
    private float total_results;


    public Medias() {


    }

    public float getPage() {
        return page;
    }

    public ArrayList<Object> getResults() {
        return results;
    }

    public float getTotal_pages() {
        return total_pages;
    }

    public float getTotal_results() {
        return total_results;
    }


}

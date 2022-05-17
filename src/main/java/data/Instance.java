package data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Instance {
    @SerializedName("results")
    private ArrayList<Object> allMedia;

    @Override
    public String toString() {
      return allMedia.toString();
    }
}

package mbc.fonfon.sun.whatmovie3;

/**
 * Created by soldesk on 2016-09-08.
 */
public class MyCustomDTO {
    String title, view_count, director, date;
    int imgName;


    public MyCustomDTO(String title, String view_count, String director, String date, int imgName) {
        this.title = title;
        this.view_count = view_count;
        this.director = director;
        this.date = date;
        this.imgName = imgName;

    }

    public MyCustomDTO(String title, String view_count, String director) {
        this.title = title;
        this.view_count = view_count;
        this.director = director;

    }

    public int getImgName() {
        return imgName;
    }

    public void setImg(int img) {
        this.imgName = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getView_count() {
        return view_count;
    }

    public void setView_count(String view_count) {
        this.view_count = view_count;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
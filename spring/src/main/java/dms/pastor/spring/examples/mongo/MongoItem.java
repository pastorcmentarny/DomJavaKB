package dms.pastor.spring.examples.mongo;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;

/**
 * Author Dominik Symonowicz
 * WWW:	https://dominiksymonowicz.com/welcome
 * IT BLOG:	https://dominiksymonowicz.blogspot.co.uk
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: https://www.linkedin.com/in/dominik-symonowicz
 */
public class MongoItem {

    @Id
    public String id;

    private String textDataType;
    private Integer integerDataType;
    private Boolean booleanDataType;
    private Double doubleDataType;
    private ArrayList<String> arrayListDataType;
    private Date date; //localDate


    public MongoItem(String textDataType, Integer integerDataType, Boolean booleanDataType, Double doubleDataType, ArrayList<String> arrayListDataType, Date date) {
        this.textDataType = textDataType;
        this.integerDataType = integerDataType;
        this.booleanDataType = booleanDataType;
        this.doubleDataType = doubleDataType;
        this.arrayListDataType = arrayListDataType;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTextDataType() {
        return textDataType;
    }

    public void setTextDataType(String textDataType) {
        this.textDataType = textDataType;
    }

    public Integer getIntegerDataType() {
        return integerDataType;
    }

    public void setIntegerDataType(Integer integerDataType) {
        this.integerDataType = integerDataType;
    }

    public Boolean getBooleanDataType() {
        return booleanDataType;
    }

    public void setBooleanDataType(Boolean booleanDataType) {
        this.booleanDataType = booleanDataType;
    }

    public Double getDoubleDataType() {
        return doubleDataType;
    }

    public void setDoubleDataType(Double doubleDataType) {
        this.doubleDataType = doubleDataType;
    }

    public ArrayList<String> getArrayListDataType() {
        return arrayListDataType;
    }

    public void setArrayListDataType(ArrayList<String> arrayListDataType) {
        this.arrayListDataType = arrayListDataType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //TODO timestamp , null? , Regular expression? .Javascript code? Object ID

}

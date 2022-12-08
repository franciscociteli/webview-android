package br.com.meopay.model;

public class MyLabel {

    private String text;
    private String id;
    private Integer margintTop;
    private String belowOf;
    private Boolean isMarker;
    private Integer fontSize;
    private Integer marginBottom;

    public Integer getMarginBottom() {
        return marginBottom;
    }

    public void setMarginBottom(Integer marginBottom) {
        this.marginBottom = marginBottom;
    }


    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public Boolean getMarker() {
        return isMarker;
    }

    public void setMarker(Boolean marker) {
        isMarker = marker;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMargintTop() {
        return margintTop;
    }

    public void setMargintTop(Integer margintTop) {
        this.margintTop = margintTop;
    }

    public String getBelowOf() {
        return belowOf;
    }

    public void setBelowOf(String belowOf) {
        this.belowOf = belowOf;
    }
}

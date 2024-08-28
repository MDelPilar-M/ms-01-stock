package com.EmazonProject.ms_01_stock.adapters.driving.http.dto.request;


public class CategoryRequest {

    private String nameCtg;
    private String descriptionCtg;

    public CategoryRequest(String nameCtg, String descriptionCtg) {
        this.nameCtg = nameCtg;
        this.descriptionCtg = descriptionCtg;
    }

    public String getNameCtg() {
        return nameCtg;
    }

    public void setNameCtg(String nameCtg) {
        this.nameCtg = nameCtg;
    }

    public String getDescriptionCtg() {
        return descriptionCtg;
    }

    public void setDescriptionCtg(String descriptionCtg) {
        this.descriptionCtg = descriptionCtg;
    }
}

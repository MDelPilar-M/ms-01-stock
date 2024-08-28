package com.EmazonProject.ms_01_stock.adapter.driving.http.dto.response;


public class CategoryResponse {

    private String nameCtg;
    private String descriptionCtg;

    public CategoryResponse(String nameCtg, String descriptionCtg) {
        this.nameCtg = nameCtg;
        this.descriptionCtg = descriptionCtg;
    }
    public CategoryResponse() {

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

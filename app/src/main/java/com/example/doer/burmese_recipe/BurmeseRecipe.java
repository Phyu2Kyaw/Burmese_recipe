package com.example.doer.burmese_recipe;

public class BurmeseRecipe {
    private String name;
    private String ingredients;
    private String process;
    private String imgUrl;

    public BurmeseRecipe(String name, String ingredients, String process, String imgUrl) {
        this.setName(name);
        this.setIngredients(ingredients);
        this.setProcess(process);
        this.setImgUrl(imgUrl);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}

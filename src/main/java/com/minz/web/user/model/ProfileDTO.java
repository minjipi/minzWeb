package com.minz.web.user.model;

public class ProfileDTO {
    private String myURL;
    private String selfIntro;

    public String getMyURL() {
        return myURL;
    }

    public void setMyURL(String myURL) {
        this.myURL = myURL;
    }

    public String getSelfIntro() {
        return selfIntro;
    }

    public void setSelfIntro(String selfIntro) {
        this.selfIntro = selfIntro;
    }

    @Override
    public String toString() {
        return "ProfileDTO{" +
                "myURL='" + myURL + '\'' +
                ", selfIntro='" + selfIntro + '\'' +
                '}';
    }
}

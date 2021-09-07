package com.minz.web.user.model;

public class ProfileDTO {
    private String nickname;
    private String myURL;
    private String selfIntro;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

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
                "nickname='" + nickname + '\'' +
                ", myURL='" + myURL + '\'' +
                ", selfIntro='" + selfIntro + '\'' +
                '}';
    }
}

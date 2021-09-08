package com.minz.web.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProfileDTO {
    private String nickname;
    private String myURL;
    private String selfIntro;
}

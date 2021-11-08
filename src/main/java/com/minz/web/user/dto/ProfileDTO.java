package com.minz.web.user.dto;

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

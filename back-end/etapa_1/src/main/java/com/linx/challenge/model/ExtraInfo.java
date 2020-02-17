package com.linx.challenge.model;

import com.linx.challenge.model.pojo.ExtraInfoPOJO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExtraInfo {

    public String hash;

    public ExtraInfo(ExtraInfoPOJO extraInfo) {
        this.hash = extraInfo.hash;
    }
}

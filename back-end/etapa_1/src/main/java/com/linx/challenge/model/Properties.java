package com.linx.challenge.model;

import com.linx.challenge.model.pojo.PropertiesPOJO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.List;

@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Properties {

    String name;

    @OneToMany
    List<Image> images;

    String url;

    String status;

    public Properties(PropertiesPOJO properties) {
        this.name = properties.getName();
        this.images = Image.convertToImageList(properties.getImages());
        this.url = properties.getUrl();
        this.status = properties.getStatus();
    }
}

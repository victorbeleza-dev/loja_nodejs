package com.linx.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;

    String path;

    public Image(Map.Entry<String, String> image) {
        this.nome = image.getKey();
        this.path = image.getValue();
    }

    public static List<Image> convertToImageList(Map<String, String> images) {
        if(images != null)
            return images.entrySet().stream().map(Image::new).collect(Collectors.toList());
        return null;
    }
}

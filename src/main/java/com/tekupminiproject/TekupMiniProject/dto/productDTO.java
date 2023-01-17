package com.tekupminiproject.TekupMiniProject.dto;

import com.tekupminiproject.TekupMiniProject.entities.Category;
import lombok.Data;


@Data
public class productDTO {
    private long id;
    private String name;

    private int categoryId;
    private double price;
    private double dimension;
    private String location;
    private String description;
    private String contact ;
    private String imageName;

}

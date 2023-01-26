package com.tekupminiproject.TekupMiniProject.global;

import com.tekupminiproject.TekupMiniProject.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Product> cart ;
    static {
        cart =new ArrayList<Product>();
    }
}

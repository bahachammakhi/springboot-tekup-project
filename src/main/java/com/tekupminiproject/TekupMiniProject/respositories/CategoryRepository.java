package com.tekupminiproject.TekupMiniProject.respositories;

import com.tekupminiproject.TekupMiniProject.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category,Integer> {
}

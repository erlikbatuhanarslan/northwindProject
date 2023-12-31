package kodlama.io.northwindProject.Entities.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDto {
    private int id;
    private String productName;
    private String categoryName;

}
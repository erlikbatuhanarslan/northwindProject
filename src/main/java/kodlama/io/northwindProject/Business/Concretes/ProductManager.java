package kodlama.io.northwindProject.Business.Concretes;

import kodlama.io.northwindProject.Business.Abstracts.ProductService;
import kodlama.io.northwindProject.Core.Utilities.Results.DataResult;
import kodlama.io.northwindProject.Core.Utilities.Results.Result;
import kodlama.io.northwindProject.Core.Utilities.Results.SuccesDataResult;
import kodlama.io.northwindProject.Core.Utilities.Results.SuccessResult;
import kodlama.io.northwindProject.DataAccess.Abstracts.ProductDao;
import kodlama.io.northwindProject.Entities.Concretes.Product;
import kodlama.io.northwindProject.Entities.Dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class ProductManager implements ProductService{

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        super();
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {

        return new SuccesDataResult<List<Product>>
                (this.productDao.findAll(),"Data listelendi");

    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Ürün eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessResult<Product>
                (this.productDao.getByProductName(productName),"Data listelendi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        //business codes

        return new SuccessResult<Product>
                (this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessResult<List<Product>>
                (this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessResult<List<Product>>
                (this.productDao.getByCategoryIn(categories),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessResult<List<Product>>
                (this.productDao.getByProductNameContains(productName),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessResult<List<Product>>
                (this.productDao.getByProductNameStartsWith(productName),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessResult<List<Product>>
                (this.productDao.getByNameAndCategory(productName,categoryId),"Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo-1, pageSize);

        return new SuccessResult<List<Product>>
                (this.productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessResult<List<Product>>
                (this.productDao.findAll(sort),"Başarılı");
    }



    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccesDataResult<List<ProductWithCategoryDto>>
                (this.productDao.getProductWithCategoryDetails(),"Data listelendi");
    }

}

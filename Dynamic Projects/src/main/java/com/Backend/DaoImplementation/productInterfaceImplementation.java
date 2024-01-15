package com.Backend.DaoImplementation;

import java.util.List;

import com.Backend.Dao.productDataInterface;
import com.Backend.Function.ProductData;
import com.Backend.model.Product;

public class productInterfaceImplementation  implements productDataInterface{

    @Override
    public List<Product> getAllProducts() {
        return  ProductData.FetchAllProducts();
    }
    
}

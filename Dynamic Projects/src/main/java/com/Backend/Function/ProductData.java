package com.Backend.Function;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Backend.DataBase.DataBaseConnection;
import com.Backend.model.Product;

public class ProductData {
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    public static List<Product> FetchAllProducts(){
        List<Product> products = new ArrayList<>();
        String query = "select * from product";

        try{
            connection = DataBaseConnection.getDBConnection();
            preparedStatement = connection.prepareStatement(query);

            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                Product product = new Product();
                product.setProductId(result.getLong("productId"));
                product.setProductName(result.getString("productName"));
                product.setProductDescription(result.getString("productDescription"));
                product.setProductAmount(result.getLong("ProductAmount"));
                product.setProductSellerId(result.getLong("productSellerId"));
                product.setProductImg(result.getString("productImg"));

                products.add(product);
            }
        }
        catch(SQLException e){
            
        }
        finally{
            try{
                if(connection!=null) connection.close();
                if(preparedStatement!=null) preparedStatement.close();
            }
            catch(SQLException e){

            }
        }

        return products;
    }




    public boolean StoreProductData(List<Product> product){
        boolean isInserted = false;


        return isInserted;
    }
}

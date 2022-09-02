package com.ptteng.carrots.bangbang.service.impl;

import com.gemantic.common.exception.ServiceDaoException;
import com.gemantic.common.exception.ServiceException;
import com.ptteng.carrots.bangbang.model.Product;
import com.ptteng.carrots.bangbang.service.ProductService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Ignore
public class ProductServiceTest {

    private static final Log log = LogFactory.getLog(ProductServiceTest.class);

    private ProductService productService;


    @Before
    public void setUp() throws Exception {


        //dao
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/carrots-bangbang-admin-service/applicationContext-server.xml");
        productService = (ProductService) context.getBean("productService");
        //local server
        /**
         productService = (ProductService)  Naming.lookup("//localhost:20027/ProductRMIService");
         **/

        /** test client
         ApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/applicationContext-sca.xml");
         productService = (ProductService) context.getBean("productService");

         **/


    }


    @Test
    public void testCRUD() throws ServiceException, ServiceDaoException {

        // 1.增加

        Product product = new Product();

        product.setName("萝卜多");


        Long id = this.productService.insert(product);

        product = this.productService.getObjectById(id);

        Product product2 = this.productService.getObjectById(id);
        Assert.assertNotNull(product2);

        // 2. 更改
        product.setName("草船云");
        boolean success = this.productService.update(product);
        Assert.assertEquals(true, success);
        Product product3 = this.productService.getObjectById(id);
        //3.删除
        boolean successDelete = this.productService.delete(id);
        Assert.assertEquals(true, success);
        Product product4 = this.productService.getObjectById(id);
        Assert.assertNull(product4);

        //4.batchInsert
        List<Product> list = new ArrayList<Product>();
        Product product5 = new Product();

        product5.setName("萝卜多");


        list.add(product5);
        Product product6 = new Product();

        product6.setName("草船云");


        list.add(product6);
        List<Product> insertResults = this.productService.insertList(list);
        Assert.assertEquals(2, insertResults.size());
        //5.batchGet
        List<Long> ids = new ArrayList<Long>();
        for (Product o : insertResults) {
            ids.add(o.getId());
        }

        List<Product> getResults = this.productService.getObjectsByIds(ids);
        Assert.assertEquals(2, getResults.size());


        for (Product o : insertResults) {
//            this.productService.delete(o.getId());
        }

        //6.batchUpdate

    }


    @Test
    public void testNULL() throws ServiceException, ServiceDaoException {


    }

    ;
}


package com.pjj.listener;

import com.pjj.pojo.ProductType;
import com.pjj.service.ProductionTypeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年09月12日 12:22
 */
@WebListener
public class ProductTypeListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext_*.xml");
        ProductionTypeService typeService = (ProductionTypeService) ac.getBean("ProductionTypeServiceImpl");
        List<ProductType> types = typeService.getTypes();
        servletContextEvent.getServletContext().setAttribute("typeList", types);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

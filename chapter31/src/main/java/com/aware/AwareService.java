package com.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1、实现BeanNameAware、ResourceLoaderAware接口，获得Bean名称和资源加载的服务。
@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware{

    private String beanName;

    private ResourceLoader loader;
    //2、BeanNameAware接口的方法
    @Override
    public void setBeanName(String name) {
        this.beanName=name;
    }

    //3、实现ResourceLoaderAware需重写setResourceLoader.
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {

        this.loader=resourceLoader;
    }

    public void outputResult()throws IOException{
        System.out.println("Bean的名称为:"+beanName);
        Resource resource =loader.getResource("classpath:test.txt");
        System.out.println("ResourceLoader加载的文件内容是:");
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        while ((line=reader.readLine())!=null){
            System.out.println(line);
        }
        reader.close();
    }

    public String getBeanName() {
        return beanName;
    }

    public ResourceLoader getLoader() {
        return loader;
    }

    public void setLoader(ResourceLoader loader) {
        this.loader = loader;
    }
}

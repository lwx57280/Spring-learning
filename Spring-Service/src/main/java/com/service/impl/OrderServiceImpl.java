package com.service.impl;

import com.domain.Order;
import com.mapper.OrderMapper;
import com.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;


@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ApplicationContext context;

    // 代理对象
    private OrderServiceImpl proxy;

    @PostConstruct
    public void init(){
        proxy = context.getBean(OrderServiceImpl.class);
    }


    /**
     * @Transactional 如果存在事务, 则使用该事务, 不存在，则新建一个(默认情况下)
     *
     * @Transactional 等价于@Transactional(propagation=Propagation.REQUIRED)
     *
     * 预期结果：
     *      addOrder方法会回滚，所以插入失败
     *      addParent方法不会回滚,所以插入正常
     *
     *  实际结果:
     *      两个方法都成功了
     */
    @Transactional
    public void addParent() {

        try{
            // 它是有真实对象来调用，而不是由AOP proxy调用
//            this.addOrder();
            // 解决方案：获得代理对象，然后由代理对象调用addOrder()方法就ok
            /*OrderServiceImpl service =(OrderServiceImpl) AopContext.currentProxy();
            service.addOrder();*/

            // 第二种：cglib代理
            proxy.addOrder();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        Order order = new Order();
        order.setOrderNo("parent");
        order.setStatus(0);
        order.setAmount(1000);
        orderMapper.insert(order);
    }

    /**
     *  @Transactional(propagation = Propagation.REQUIRES_NEW)
     *  如果当前存在事务,则挂起当前事务并开启一个新的事务执行，新事务执行完毕之后,唤醒之前挂起的事务,
     *  继续执行之前的事务，如果当前不存在事务，则新建一个事务。
     * @param order
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addOrder() {
        Order order = new Order();
        order.setOrderNo("parent");
        order.setStatus(0);
        order.setAmount(1000);
        orderMapper.insert(order);
        throw new RuntimeException();
    }


}

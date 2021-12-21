package com.pjj.ba03;

import com.pjj.ba02.Student;
import org.springframework.stereotype.Service;

/**
 * @author 潘俊杰
 * @date 2021年08月24日 13:02
 * 这个类需要我们去增加切面
 */
@Service("Service")
public class MyServiceImpl implements MyService {
    @Override
    public void doSome(String name, Integer age) {
        System.out.println("目标类执行了");
    }

}

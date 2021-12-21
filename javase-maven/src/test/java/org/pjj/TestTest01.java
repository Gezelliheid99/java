package org.pjj;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author 潘俊杰
 * @date 2021年06月02日 21:09
 */
public class TestTest01 {

    @Test
    public void Testadd(){
        System.out.println("======add测试=======");
        Test01 test01 = new Test01();
        int result = test01.add(10,20);
        //判断结果是否正确
        Assert.assertEquals(30,result);
    }
}

package study.springboot.all.study.springboot.all.util;

/**
 * @author guyun
 * @package study.springboot.all.study.springboot.all.util
 * @class Test
 * @date 2018/8/1420:54
 * @description
 */
public class Test {

    public static void main(String[] args) {
        DDO ddo = new DDO();
        ddo.setA(3);
        ddo.setB(4);


        swagger(ddo);
        System.out.println(ddo.getA());
        System.out.println(ddo.getB());
    }

    public static void swagger(DDO ddo) {
        int tmp = ddo.getA();
        ddo.setA(ddo.getB());
        ddo.setB(tmp);
    }
}
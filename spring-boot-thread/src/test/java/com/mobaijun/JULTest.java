package com.mobaijun;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@SpringBootTest
public class JULTest {

    /**
     * 入门案例：
     * 包路径：java.util.logging.Logger;
     * Logger对象的创建方式，不能直接new对象
     * 取得对象的方法参数，需要引入当前类的全路径字符串，或当前类名称（根据包结构有Logger父子关系）
     */
    public static final Logger log = Logger.getLogger("com.mobaijun.JULTest");

    /**
     * 对于日志的输出，有两种方式
     * 1、第一种
     * * 直接调用日志级别相关的方法，方法中传递日志输出信息
     * * 假设现在需要输出info级别的日志
     * 2、第二种
     * * 调用通用的log方法，然后在里面通过level类型来定义日志的级别参数，以及搭配日志输出信息的参数
     */
    @Test
    public void contextLoads() {
        // 第一种
        log.info("https://www.mobaijun.com");
        // 第二种
        log.log(Level.INFO, "https://www.mobaijun.com");

        /**
         * 输出学生信息：
         *  姓名
         *  年龄
         */
        String name = "墨白";
        Integer age = 22;
        log.log(Level.INFO, "学生姓名为：" + name + ";学生年龄为：" + age + ";");

        /**
         * 对于输出的消息中，字符串的拼接弊端很多
         * 1.麻烦
         * 2.程序效率不高
         * 3.可读性不强
         * 4.维护成本高
         * 应该使用动态生成数据的方式，生产日志，可以使用占位符进行操作
         * 输出信息为：学生姓名为：墨白，学生年龄为：22
         * 类似数组下标，一一对应，0对应name，1对应age
         */
        log.log(Level.INFO, "学生姓名为：{0}，学生年龄为：{1}", new Object[]{name, age});
    }

    /**
     * 日志级别：
     * SEVERE、错误信息，一般是记录导致系统终止的信息。
     * WARNING、警告信息，一般记录程序的问题，该问题不会导致系统终止，但是却值得我们关注。
     * INFO、一般信息，一般记录一些连接信息，访问信息等。（这是JUL的默认级别）
     * CONFIG、一般记录加载配置文件等日志信息。
     * FINE、Debug日志信息，一般记录程序一般运行的状态。执行的流程参数的传递等信息。
     * FINER、与FINE 类似，只是记录的颗粒度要高一些。
     * FINEST、与上面两个类似，只是记录的颗粒度要高一些。
     * 还有两个特殊的级别：
     * OFF、可用来关闭日志信息，不输出任何级别的日志。
     * ALL、记录所有级别的日志信息。
     * 当Logger或者Handler设置了某一日志级别，低于该级别的日志信息将不会被记录。
     * 对于日志的级别，重点关注的是new对象的时候的第二个参数，是一个数值
     * OFF:Integer.MAX_VALUE、整形最大值
     * SEVERE：1000
     * WARNING：900
     * INFO：800
     * 。。。。。。。。。。。。。。。。。。
     * FINEST：300
     * ALL：Integer.MIN_VALUE、整形最小值
     * 数值表示设置的日志显示信息，日志等级，如设置ALL，最小值，就显示所有日志信息
     */
    @Test
    public void contextLoadsJul() {
        /**
         * 1.设置日志级别
         * 通过打印结果，看到了仅仅只是输出了info级别以及比info级别高的日志信息
         * 比info级别低的日志信息没有输出出来
         * 证明了info级别的日志信息，它是系统默认的日志级别
         * 在默认日志级别info的基础上，打印比它级别高的日志信息
         * 2.通过Level设置日志级别
         * * 如果仅仅是通过setLevel来设置日志级别，那么是无效的，需要搭配处理器Handler共同设置才会生效
         */
        log.setLevel(Level.ALL);
        /**
         * 2021-08-03 11:55:23.398 ERROR 5808 --- [main] c.m.SpringBootThreadApplicationTests: severe
         * 2021-08-03 11:55:23.398  WARN 5808 --- [main] c.m.SpringBootThreadApplicationTests: warning
         * 2021-08-03 11:55:23.398  INFO 5808 --- [main] c.m.SpringBootThreadApplicationTests: info
         * 2021-08-03 11:55:23.398  INFO 5808 --- [main] c.m.SpringBootThreadApplicationTests: config
         */
        log.severe("severe");
        log.warning("warning");
        log.info("info");
        log.config("config");
        log.fine("fine");
        log.finer("finer");
        log.finest("finest");
        /**
         * 2021-08-03 11:51:34.361 ERROR 20632 --- [main] c.m.SpringBootThreadApplicationTests: severe
         * 2021-08-03 11:51:34.361  WARN 20632 --- [main] c.m.SpringBootThreadApplicationTests: warning
         * 2021-08-03 11:51:34.361  INFO 20632 --- [main] c.m.SpringBootThreadApplicationTests: info
         */
    }

    /**
     * 自定义日志的级别
     */
    @Test
    public void contextJulLevel() {
        /**
         * 1、将默认的日志打印方式关闭掉
         * 2、参数设置为false，打印日志的方式就不会按照父logger默认的方式去进行操作
         */
        // 1、关闭默认的日志打印方式
        log.setUseParentHandlers(false);
        // 2、添加处理器Handler,使用控制台日志处理器，取得处理器对象
        ConsoleHandler handler = new ConsoleHandler();
        // 3、创建日志格式化组件对象
        SimpleFormatter formatter = new SimpleFormatter();
        // 4、在处理器中设置输出格式
        handler.setFormatter(formatter);
        // 5、在记录器中添加处理器
        log.addHandler(handler);
        // 6、设置日志的打印级别，此处必须将日志记录器和处理器的级别进行统一的设置，才会达到日志显示相应级别的效果
        log.setLevel(Level.ALL);
        handler.setLevel(Level.ALL);
        // 7、需要打印的日志信息
        log.severe("severe");
        log.warning("warning");
        log.info("info");
        log.config("config");
        log.fine("fine");
        log.finer("finer");
        log.finest("finest");
        /**
         * ##################################################输出的日志信息
         * 八月 03, 2021 2:17:50 下午 com.mobaijun.JULTest contextJulLevel
         * 严重: severe
         * 八月 03, 2021 2:17:50 下午 com.mobaijun.JULTest contextJulLevel
         * 警告: warning
         * 八月 03, 2021 2:17:50 下午 com.mobaijun.JULTest contextJulLevel
         * 信息: info
         * 八月 03, 2021 2:17:50 下午 com.mobaijun.JULTest contextJulLevel
         * 配置: config
         * 八月 03, 2021 2:17:50 下午 com.mobaijun.JULTest contextJulLevel
         * 详细: fine
         * 八月 03, 2021 2:17:50 下午 com.mobaijun.JULTest contextJulLevel
         * 较详细: finer
         * 八月 03, 2021 2:17:50 下午 com.mobaijun.JULTest contextJulLevel
         * 非常详细: finest
         */
    }


    /**
     * 日志持久化操作，将日志文件输出到磁盘文件中
     */
    @Test
    public void aofLogger() throws Exception {
        /**
         * 1、将默认的日志打印方式关闭掉
         * 2、参数设置为false，打印日志的方式就不会按照父logger默认的方式去进行操作
         */
        // 1、关闭默认的日志打印方式
        log.setUseParentHandlers(false);
        /**
         * 2、添加处理器Handler,使用控制台日志处理器，取得处理器对象
         * 在输出到磁盘中的时候必须要保证磁盘中存在日志文件，否则会报错：java.nio.file.NoSuchFileException:C:\test\test-jul.log
         */
        FileHandler handler = new FileHandler("C:\\test\\test-jul.log");
        // 3、创建日志格式化组件对象
        SimpleFormatter formatter = new SimpleFormatter();
        // 4、在处理器中设置输出格式
        handler.setFormatter(formatter);
        // 5、在记录器中添加处理器
        log.addHandler(handler);
        // 6、设置日志的打印级别，此处必须将日志记录器和处理器的级别进行统一的设置，才会达到日志显示相应级别的效果
        log.setLevel(Level.ALL);
        handler.setLevel(Level.ALL);
        // 7、需要打印的日志信息
        log.severe("severe");
        log.warning("warning");
        log.info("info");
        log.config("config");
        log.fine("fine");
        log.finer("finer");
        log.finest("finest");
        /**
         * 总结：
         *      用户使用Logger来进行日志的记录，Logger可以持有多个处理器Handler（日志的记录使用的是Logger，日志的输出使用的是Handler）
         *      添加了那些Handler对象，就相当于需要根据所添加的Handler将日志文件输出到指定的位置上，例如控制台、文件等。。。。。
         */
    }
}

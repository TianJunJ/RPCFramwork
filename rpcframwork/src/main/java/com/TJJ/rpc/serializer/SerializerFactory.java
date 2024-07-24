package com.TJJ.rpc.serializer;

import com.TJJ.rpc.spi.SpiLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * 序列化器工厂（用于获取序列化器对象）
 * 这是一个单例工厂
 */
public class SerializerFactory {


//    /**
//     * 序列化映射（用于实现单例）
//     * 若不采用SPI机制，用map去映射来实现单例工厂即可，如果使用SPI就不需要这段代码了、
//     * （无SPI的手段）
//     */
//    private static final Map<String, Serializer> KEY_SERIALIZER_MAP = new HashMap<String, Serializer>() {{
//        put(SerializerKeys.JDK, new JdkSerializer());
//        put(SerializerKeys.JSON, new JsonSerializer());
//        put(SerializerKeys.KRYO, new KryoSerializer());
//        put(SerializerKeys.HESSIAN, new HessianSerializer());
//    }};
//
//    /**
//     * 默认序列化器
//     */
//    private static final Serializer DEFAULT_SERIALIZER = KEY_SERIALIZER_MAP.get("jdk");
//
//    /**
//     * 获取实例
//     *
//     * @param key
//     * @return
//     */
//    public static Serializer getInstance(String key) {
//        return KEY_SERIALIZER_MAP.getOrDefault(key, DEFAULT_SERIALIZER);
//    }


    //下方为引入SPI之后的代码
    //在引入SPI之后，如果用户想要添加新的序列化器，只需要写好新的序列化器代码以及在resources文件中添加相关键值
    //强制读取文件中的键值对（一旦使用了这个工厂，首先就会去读取键值对，用于接下来的实例生成）
    static {
        SpiLoader.load(Serializer.class);
    }

    /**
     * 默认序列化器
     */
    private static final Serializer DEFAULT_SERIALIZER = new JdkSerializer();

    /**
     * 获取实例
     *
     * @param key
     * @return
     */
    public static Serializer getInstance(String key) {
        return SpiLoader.getInstance(Serializer.class, key);
    }

}


//package utils;
//
//import java.io.InputStream;
//import java.util.Properties;
//
//public class PropertiesReader {
//    public static Properties properties;
//
//    static {
//        properties = new Properties();
//        InputStream inputStream = PropertiesReader.class.getResourceAsStream("/config.properties");
//        try {
//            properties.load(inputStream);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static String get(String propertyName) {
//        return PropertiesReader.properties.getProperty(propertyName);
//    }
//}

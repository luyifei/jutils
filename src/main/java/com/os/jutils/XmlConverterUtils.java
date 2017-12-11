package com.os.jutils;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * 
 * @author sunny
 *
 */
public class XmlConverterUtils {
    private static final String ENCODEING_TYPE_UTF8 = "utf-8";

    private XmlConverterUtils() {
    }

    /**
     * xml文件字符串转换为对象
     * 
     * @param xml
     *            xml文件字符串
     * @param clz
     *            指定类
     * @return
     * @throws JAXBException
     */
    public static <T> T xml2Pojo(String xml, Class<T> clz) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(clz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object obj = unmarshaller.unmarshal(new StringReader(xml));
        return clz.cast(obj);
    }

    /**
     * 对象转换为xml文件格式字符串，默认字符集utf-8
     * 
     * @param obj
     *            数据对象
     * @return
     * @throws JAXBException
     */
    public static String pojo2Xml(Object obj) throws JAXBException {
        return pojo2Xml(obj, ENCODEING_TYPE_UTF8);
    }

    /**
     * 对象转换为xml文件格式字符串
     * 
     * @param obj
     *            数据对象
     * @param encoding
     *            编码
     * @return
     * @throws JAXBException
     */
    public static String pojo2Xml(Object obj, String encoding) throws JAXBException {
        String result = null;
        StringWriter writer = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            writer = new StringWriter();
            writer.write("<?xml version=\'1.0\' encoding=\'" + encoding + "\'?>\n");
            marshaller.marshal(obj, writer);
            result = writer.toString();
            return result;
        } catch (JAXBException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (null != writer) {
                try {
                    writer.close();
                    writer = null;
                } catch (IOException e) {
                }
            }
        }
    }

}

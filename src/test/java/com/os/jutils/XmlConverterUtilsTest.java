package com.os.jutils;

import javax.xml.bind.JAXBException;

import org.junit.Test;

public class XmlConverterUtilsTest {

    @Test
    public void pojo2XmlTest() throws JAXBException {
        XmlObject obj = new XmlObject();
        obj.setAge("25");
        obj.setGender("male");
        obj.setName("zhangsan");
        obj.setTall("1.80");
        String xmlString = XmlConverterUtils.pojo2Xml(obj);
        System.out.println(xmlString);
    }

    @Test
    public void xml2PojoTest() throws JAXBException {
        String s = "<?xml version='1.0' encoding='utf-8'?><data><name>zhangsan</name><age>22</age><tall>1.80</tall><gender>male</gender></data>";
        XmlObject obj = XmlConverterUtils.xml2Pojo(s, XmlObject.class);
        System.out.println(obj);
    }
}

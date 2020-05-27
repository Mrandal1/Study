package study.dom4j;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.dom4j
 * @data 2020/5/27 21:18
 */
public class Dom4jTest {
    @Test
    public void test() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/study/dom4j/books.xml");
        System.out.println(document);
    }

    /**
     * 读取xml生成bean
     */
    @Test
    public void test2() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/study/dom4j/books.xml");
        //获取根元素
        Element root = document.getRootElement();
        //获取book节点
        List<Element> bookElements = root.elements("book");
        //获取迭代器
        Iterator<Element> i=root.elementIterator();


        for (Element e : bookElements) {
            //将 Element 转化为 String
            //System.out.println(e.asXML());
            String name = e.elementText("name");
            BigDecimal price = new BigDecimal(e.elementText("price"));
            String author = e.elementText("author");
            String sn = e.attributeValue("sn");
            System.out.println(new Book(name, sn, price, author).toString());
        }

    }
}

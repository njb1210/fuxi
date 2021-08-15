package com;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLDateDemo {
    static File file = new File("D:\\Java_WorkSpcae\\SCXM\\fuxi\\src\\com\\Persons.xml");// Persons.xml文件绝对路径

    public static void main(String[] args) throws Exception {
       add();// 添加数据
       //delete();// 删除数据
       // update();// 修改数据
       // select();// 查找数据
    }

    public static void add() throws Exception {
        // ①获得解析器DocumentBuilder的工厂实例DocumentBuilderFactory 然后拿到DocumentBuilder对象
        DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        // ②获取一个与磁盘文件关联的非空Document对象
        Document doc = newDocumentBuilder.parse(file);
        // ③通过文档对象获得该文档对象的根节点
        Element root = doc.getDocumentElement();

        // 创建一个新的person节点
        Element person = doc.createElement("person");
        // 创建person的几个子节点
        Element name = doc.createElement("name");
        Element age = doc.createElement("age");
        Element sex = doc.createElement("sex");
        // 给子节点设置值
        name.setTextContent("李星寅");
        age.setTextContent("20");
        sex.setTextContent("男");
        // 将子节点追加到person
        person.appendChild(name);
        person.appendChild(age);
        person.appendChild(sex);
        // 给person的id设置值
        person.setAttribute("id", "3");
        // 将person追加到根节点
        root.appendChild(person);

        // 注意：XML文件是被加载到内存中 修改也是在内存中 ==》因此需要将内存中的数据同步到磁盘中
        /*
         * static TransformerFactory newInstance():获取 TransformerFactory 的新实例。 abstract
         * Transformer newTransformer():创建执行从 Source 到 Result 的复制的新 Transformer。
         * abstract void transform(Source xmlSource, Result outputTarget):将 XML Source
         * 转换为 Result。
         */
        // 获取一个转换器对象transformer
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Source source = new DOMSource(doc);// 获取内存里面的数据（doc ==> document对象）
        Result result = new StreamResult(file);// 获取磁盘上的文件
        transformer.transform(source, result);// 将 XML==>Source 转换为 Result
    }

    public static void delete() throws Exception {
        // ①获得解析器DocumentBuilder的工厂实例DocumentBuilderFactory 然后拿到DocumentBuilder对象
        DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        // ②获取一个与磁盘文件关联的非空Document对象
        Document doc = newDocumentBuilder.parse(file);
        // ③通过文档对象获得该文档对象的根节点
        Element root = doc.getDocumentElement();

        // 查找指定节点
        // 通过根节点获得子节点
        NodeList personList = root.getElementsByTagName("person");
        // 这里获取第2个节点
        Node item = personList.item(1);
        // 移出节点
        root.removeChild(item);

        // 注意：XML文件是被加载到内存中 修改也是在内存中 ==》因此需要将内存中的数据同步到磁盘中
        /*
         * static TransformerFactory newInstance():获取 TransformerFactory 的新实例。 abstract
         * Transformer newTransformer():创建执行从 Source 到 Result 的复制的新 Transformer。
         * abstract void transform(Source xmlSource, Result outputTarget):将 XML Source
         * 转换为 Result。
         */
        // 获取一个转换器对象transformer
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Source source = new DOMSource(doc);// 获取内存里面的数据（doc ==> document对象）
        Result result = new StreamResult(file);// 获取磁盘上的文件
        transformer.transform(source, result);// 将 XML==>Source 转换为 Result
    }

    public static void update() throws Exception {
        // ①获得解析器DocumentBuilder的工厂实例DocumentBuilderFactory 然后拿到DocumentBuilder对象
        DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        // ②获取一个与磁盘文件关联的非空Document对象
        Document doc = newDocumentBuilder.parse(file);
        // ③通过文档对象获得该文档对象的根节点
        Element root = doc.getDocumentElement();

        // 查找指定节点
        // 通过根节点获得子节点
        NodeList personList = root.getElementsByTagName("person");
        // 这里获取第1个节点
        Node item = personList.item(0);
        // System.out.println(item.getTextContent());
        Element personElement = (Element) item;
        // 获取personElement下面的子节点
        NodeList nameList = personElement.getElementsByTagName("name");
        // System.out.println(nameList.item(0).getTextContent());
        // 修改
        nameList.item(0).setTextContent("这里是我修改的名字");

        // 注意：XML文件是被加载到内存中 修改也是在内存中 ==》因此需要将内存中的数据同步到磁盘中
        /*
         * static TransformerFactory newInstance():获取 TransformerFactory 的新实例。 abstract
         * Transformer newTransformer():创建执行从 Source 到 Result 的复制的新 Transformer。
         * abstract void transform(Source xmlSource, Result outputTarget):将 XML Source
         * 转换为 Result。
         */
        // 获取一个转换器对象transformer
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Source source = new DOMSource(doc);// 获取内存里面的数据（doc ==> document对象）
        Result result = new StreamResult(file);// 获取磁盘上的文件
        transformer.transform(source, result);// 将 XML==>Source 转换为 Result
    }

    public static void select() throws Exception {
        // ①获得解析器DocumentBuilder的工厂实例DocumentBuilderFactory 然后拿到DocumentBuilder对象
        DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        // ②获取一个与磁盘文件关联的非空Document对象
        Document doc = newDocumentBuilder.parse(file);
        // ③通过文档对象获得该文档对象的根节点
        Element root = doc.getDocumentElement();

        // 通过根节点获得子节点
        NodeList personList = root.getElementsByTagName("person");
        // System.out.println(personList);

        // 这里获取第1个节点12321312312312321
        Node item = personList.item(0);
        System.out.println(item.getTextContent());// 获取第一个节点的所有子节点值

        Element element = (Element) item;// 这里转换成子类类型 ==》原因：父类没有对应的方法 这里只看类型不看值

        // 这里获取第1个节点下 name节点值
        NodeList nameList = element.getElementsByTagName("name");
        System.out.println(nameList.item(0).getTextContent());
    }
}

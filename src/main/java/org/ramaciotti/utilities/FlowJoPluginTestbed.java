package org.ramaciotti.utilities;
import com.treestar.lib.xml.SElement;
import com.treestar.lib.xml.XMLUtil;
import com.treestar.lib.xml.*;
import org.xml.sax.SAXException;
import weka.core.PropertyPath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.FileSystems;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class FlowJoPluginTestbed {

        public static SElement getFcmlFromFile(String stringPath) throws IOException, ParserConfigurationException, SAXException {
            File fXmlFile = new File(stringPath);
            return JdomUtil.read(fXmlFile, true);
        }

        public static File createFileObject(String path) {
            return new File(path);
        }

    public static void main(String argv[]) {

        try {

            File fXmlFile = new File("/Users/nicbarker/Documents/test gating/Fj10 E 14F_20170222_ana 20170914/FlowJo Plugin Data Dump/fcmlQueryElement.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            DOMSource source = new DOMSource(doc);
            System.out.println(source.getNode());

//            NodeList nList = doc.getElementsByTagName("staff");
//
//            System.out.println("----------------------------");
//
//            for (int temp = 0; temp < nList.getLength(); temp++) {
//
//                Node nNode = nList.item(temp);
//
//                System.out.println("\nCurrent Element :" + nNode.getNodeName());
//
//                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//
//                    Element eElement = (Element) nNode;
//
//                    System.out.println("Staff id : " + eElement.getAttribute("id"));
//                    System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
//                    System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
//                    System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
//                    System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
//
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
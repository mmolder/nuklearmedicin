package com.nuklearmedicin;

import android.content.Context;
import android.content.res.AssetManager;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

/**
 * Created by Mikael on 2016-05-02.
 */
public class HandleXml {

    DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = null;
    Document document = null;

    public String[] getContent(Context context, int num, String fragment){
        AssetManager assetManager = context.getAssets();
        try {
            builder = builderFactory.newDocumentBuilder();
            document = builder.parse(assetManager.open("content.xml"));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XPath xpath = XPathFactory.newInstance().newXPath();
        String content[] = new String[num];
        String expr[] = new String[num];
        switch (fragment) {
            case "Before":
                break;
            case "During":
                expr[0] = "/content/during/desc";
                expr[1] = "/content/during/desc_2";
                break;
            case "After":
                expr[0] = "/content/after/restriction_1";
                expr[1] = "/content/after/restriction_2";
                expr[2] = "/content/after/restriction_3";
                expr[3] = "/content/after/restriction_4";
                expr[4] = "/content/after/restriction_5";
                expr[5] = "/content/after/restriction_6";
                break;
            case "Restrictions":
                expr[0] = "/content/restrictions/info";
                expr[1] = "/content/restrictions/more_info";
                break;
        }
        Node node = null;

        for(int i = 0; i < num; i++) {
            try {
                node = (Node) xpath.evaluate(expr[i], document, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }
            if (node== null)
                System.out.println("Element does not exists");
            else {
                content[i] = node.getTextContent();
            }
        }
        return content;
    }
}

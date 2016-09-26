package tw.com.pcschool.t092601;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by student on 2016/9/26.
 */
public class MyDataHandler extends DefaultHandler{
    boolean isTitle = false, isItem = false, isLink = false;

    public ArrayList<String> data = new ArrayList();
    public ArrayList<String> link = new ArrayList();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("title"))
        {
            isTitle = true;
        }
        if (qName.equals("link"))
        {
            isLink = true;
        }
        if (qName.equals("item"))
        {
            isItem = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("title"))
        {
            isTitle = false;
        }
        if (qName.equals("link"))
        {
            isLink = false;
        }
        if (qName.equals("item"))
        {
            isItem = false;
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if (isTitle == true && isItem == true)
        {
            String fetchStr = new String(ch).substring(start, start + length);
            data.add(fetchStr);
        }
        if (isLink == true && isItem == true)
        {
            String fetchStr = new String(ch).substring(start, start + length);
            link.add(fetchStr);
        }
    }


}

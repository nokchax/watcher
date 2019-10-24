package com.nokchax.watcher.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.regex.Pattern;

public class JsoupTest {
    private Document document;

    @Before
    public void init() throws IOException {
        Connection connect = Jsoup.connect("https://naver.com");

        document = connect.get();
    }
    @Test
    public void connectTest() {
        System.out.println(document); //print whole html
        System.out.println("=====================================================");
        System.out.println(document.body()); //print body only
    }

    @Test
    public void findElementTest() {
        Elements elementsByClass = document.getElementsByClass("find by class");
        Elements elementsByTag = document.getElementsByTag("find by tag");
        Elements elementsByAttribute = document.getElementsByAttribute("find by attribute");
        // notice : by id return only one element
        Element elementById = document.getElementById("find by id");
        Elements elementsByAttributeStarting = document.getElementsByAttributeStarting("prefix key");
        Elements elementsByAttributeKeyAndValue = document.getElementsByAttributeValue("key", "value");
        Elements valueContaining = document.getElementsByAttributeValueContaining("key", "containing value");
        Elements valueEnding = document.getElementsByAttributeValueEnding("key", "ending");
        Elements valueMatchingWithRegex = document.getElementsByAttributeValueMatching("key", "regex");
        Elements valueMatchingWithPattern = document.getElementsByAttributeValueMatching("key", Pattern.compile("regex"));
        Elements valueNotMatching= document.getElementsByAttributeValueNot("key", "not matching value");
        Elements elementsByIndexEquals = document.getElementsByIndexEquals(0);
        Elements elementsByIndexGreaterThan = document.getElementsByIndexGreaterThan(0);
        Elements elementsByIndexLessThan = document.getElementsByIndexLessThan(0);
        // 자손에 포함되어 있으면 안됨??
        Elements containingOwnText = document.getElementsContainingOwnText("some text");
        Elements containingText = document.getElementsContainingText("some text");
        Elements matchingOwnText = document.getElementsMatchingOwnText("regex");
        Elements matchingOwnTextUsingPattern = document.getElementsMatchingOwnText(Pattern.compile("regex"));
        Elements matchingText = document.getElementsMatchingText("regex");
        Elements matchingTextUsingPattern = document.getElementsMatchingText(Pattern.compile("regex"));
    }

    @Test
    public void etcTest() {
        document.body();
        document.charset();
        document.head();
        document.createElement("tag name");
        //get url
        document.location();
        //????
        document.nodeName();
        document.normalise();
    }
}

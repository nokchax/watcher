package com.nokchax.watcher.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;

public class JsoupTest {
    @Test
    public void JsoupConnectTest() throws IOException {
        Connection connect = Jsoup.connect("https://naver.com");

        Document document = connect.get();

        System.out.println(document); //print whole html
        System.out.println("=====================================================");
        System.out.println(document.body()); //print body only
    }
}

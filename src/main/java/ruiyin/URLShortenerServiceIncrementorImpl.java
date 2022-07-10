package ruiyin;/**
 * @author Weiyan Xiang on 2021/12/9
 */

import kt.A;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class URLShortenerServiceIncrementorImpl implements URLShortenerService {
    private static final String PREFIX = "www.tinyUrl.com/";
    // shortUrl, longUrl
    private Map<String, String> urlMap;
    // longUrl, count
    private Map<String, Integer> counterMap;
    private AtomicInteger incrementor;

    public URLShortenerServiceIncrementorImpl() {
        this.urlMap = new HashMap<>();
        this.counterMap = new HashMap<>();
        this.incrementor = new AtomicInteger();
    }

    @Override
    public String shortern(String url) {
        if (counterMap.containsKey(url)) return urlMap.get(PREFIX + counterMap.get(url));
        else {
            int increment = incrementor.getAndIncrement();
            String shortUrl = "www.tinyUrl.com/" + increment;
            counterMap.put(url, increment);
            urlMap.put(shortUrl, url);
            return shortUrl;
        }
    }

    @Override
    public String lookup(String shortcode) {
        return urlMap.get(shortcode);
    }

    public static void main(String[] args) {
        URLShortenerServiceIncrementorImpl testObj = new URLShortenerServiceIncrementorImpl();
        String url1 = "www.weiya.com/dsahuoids/dbsahicxz/cxbzhui";
        String url2 = "www.dandan.com/nc_jxozis/dbsahicxz/cxbzhui";
        System.out.println(testObj.shortern(url1));
        System.out.println(testObj.shortern(url2));
        System.out.println(testObj.lookup(PREFIX + 0));
        System.out.println(testObj.lookup(PREFIX + 1));
        // url3 == url1, so the lookup should not work on count 3, instead, should be 0
        String url3 = "www.weiya.com/dsahuoids/dbsahicxz/cxbzhui";
        System.out.println(testObj.shortern(url3));
        System.out.println(testObj.lookup(PREFIX + 2));
        System.out.println(testObj.lookup(PREFIX + 0));
    }
}

package ruiyin; /**
 * @author Weiyan Xiang on 2021/12/8
 */

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class URLShortenerServiceImpl implements URLShortenerService {

    // key: shortUrl, value: url
    private Map<String, String> cache;
    // key: url, value: count
    private Map<String, Integer> countCache;
    private AtomicInteger counter;

    public URLShortenerServiceImpl() {
        this.cache = new ConcurrentHashMap<>();
        this.countCache = new ConcurrentHashMap<>();
        counter = new AtomicInteger();
    }

    /**
     * "1-1" -> www.com "2-2" -> abc.com "3-3" -> def.com
     * <p>
     * tho.com the hashcode is 1 again, 4-1 etc
     */
    @Override
    public String shortern(String url) {
        String shortUrl;
        String hash = generateHashCode(url);
        // if collision, generate count
        if (countCache.containsKey(url)) {
            int count = counter.incrementAndGet();
            shortUrl = generateKey(count, hash);
            countCache.put(url, count);
        } else {
            shortUrl = hash;
        }
        cache.put(shortUrl, url);
        return shortUrl;
    }

    @NotNull
    private String generateKey(int count, String hashCode) {
        return count + "-" + hashCode;
    }


    private String generateHashCode(String url) {
        return String.valueOf(new HashCodeBuilder(17, 89).append(url).toHashCode());
    }

    @Override
    public String lookup(String shortUrl) {
        return cache.getOrDefault(shortUrl, null);
    }

    public static void main(String[] args) {
        URLShortenerService service = new URLShortenerServiceImpl();
        String url = "1";
        String shortUrl = service.shortern(url);
        if (service.lookup(shortUrl) == url) System.out.println("valid");
    }

}

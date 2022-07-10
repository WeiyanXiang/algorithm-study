package ruiyin; /**
 * @author Weiyan Xiang on 2021/12/8
 */

import java.util.*;

interface URLShortenerService {

    /**
     * http://www.ubs.com/aoeuaoeuaoeuaoeuaoeuaoeuaoeu.p.ydico.8pig9o8ig8945ogi9o.piop.i&ik89ig5=uu43uau
     * ->
     * "abcd"
     *
     * we should be able to loop up by abcd to revert back to long one
     *
     * aabbccccc
     * ->
     * a2b2c5
     *
     * hash a String of url -> hashed url
     * key value pair: hashed url | long url
     * when look up, we get hashed url -> long url
     *
     *
     */
    String shortern(String url);

    String lookup(String shortcode);

}


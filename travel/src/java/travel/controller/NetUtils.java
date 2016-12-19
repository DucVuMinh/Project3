/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

/**
 *
 * @author GiangTHQ
 */
public class NetUtils {
    
        public static String GetResult(String url){
        try {
            String content = Request.Get(url)
                    .setHeader("Accept-Charset", "utf-8")
                    .execute().returnContent().asString();
            return content;
        } catch (ClientProtocolException e) {
            Logger.getLogger(NetUtils.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException e){
            Logger.getLogger(NetUtils.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}

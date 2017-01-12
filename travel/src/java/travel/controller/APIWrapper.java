/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travel.controller;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.jboss.logging.Logger;
import travel.model.User;

/**
 *
 * @author GiangTHQ
 */
public class APIWrapper {
    
    private static String appID = "361231914229921";
    private static String appSecret = "0ab03d5fb40067315035bd55a6b0c4bd";
    private static String redirectUrl = "/customLoginFb.htm";
    private static String accessToken;
    private Gson gson;

    public static String getAppID() {
        return appID;
    }

    public static void setAppID(String appID) {
        APIWrapper.appID = appID;
    }

    public static String getAppSecret() {
        return appSecret;
    }

    public static void setAppSecret(String appSecret) {
        APIWrapper.appSecret = appSecret;
    }

    public static String getRedirectUrl() {
        return redirectUrl;
    }

    public static void setRedirectUrl(String redirectUrl) {
        APIWrapper.redirectUrl = redirectUrl;
    }

    public static String getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(String accessToken) {
        APIWrapper.accessToken = accessToken;
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }
    
    public APIWrapper(){
        gson = new Gson();
    }
    
    public static String getDialogLink(String domain){
        String dialogLink = "https://www.facebook.com/dialog/oauth?client_id=%s&redirect_uri=%s";
        APIWrapper.redirectUrl=domain+redirectUrl;
        System.out.println(redirectUrl);
        return String.format(dialogLink, appID, redirectUrl);
        
    }
    
    public String getAccessToken(String code){
        String accessTokenLink = "https://graph.facebook.com/oauth/access_token?"
                                + "client_id=%s"
                                + "&redirect_uri=%s"
                                + "&client_secret=%s"                               
                                + "&code=%s";
        accessTokenLink = String.format(accessTokenLink, appID, redirectUrl, appSecret, code);
        String result = NetUtils.GetResult(accessTokenLink);
        String token = result.substring(result.indexOf("=") + 1, result.indexOf("&"));
        return token;
    }
    
    public User getUserFB(){
        String infoUrl = "https://graph.facebook.com/me?access_token=%s";
        infoUrl = String.format(infoUrl, this.accessToken);
        
        String result = NetUtils.GetResult(infoUrl);
        
        User userfb = gson.fromJson(result, User.class);
        return userfb;
    }
}

package com.jary.daily.utils;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;

/**
 * @author fanzhengjie
 * @create 2018/7/2 下午5:51
 * @description
 */
public class HttpClientUtils {

    private static final X509TrustManager trustManager = new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    };

    private static final OkHttpClient httpsClient = new OkHttpClient.Builder()
        .connectTimeout(5000l, TimeUnit.MILLISECONDS)
        .readTimeout(5000l, TimeUnit.MILLISECONDS)
        .sslSocketFactory(createSSLSocketFactory(), trustManager)
        .hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                return true;
            }
        })
        .build();

    private static final OkHttpClient httpClient = new OkHttpClient.Builder()
        .connectTimeout(5000l, TimeUnit.MILLISECONDS)
        .readTimeout(5000l, TimeUnit.MILLISECONDS)
        .build();

    private static SSLSocketFactory createSSLSocketFactory(){
        SSLSocketFactory sslSocketFactory = null;
        try{
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{trustManager}, new SecureRandom());
            sslSocketFactory = sslContext.getSocketFactory();
        }catch (Exception e){

        }
        return sslSocketFactory;
    }

    public static OkHttpClient getClient(){
        boolean useHttpsProtocol = false;
        if(useHttpsProtocol){
            return httpsClient;
        }
        return httpClient;
    }

}

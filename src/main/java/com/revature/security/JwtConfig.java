package com.revature.security;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

@Component
public class JwtConfig {


    private static final String header;

    private static final String prefix;

    private static final String secret;

    private long expiration;

    static{
        header = System.getenv("Header");
        prefix = System.getenv("Prefix");
        secret = System.getenv("Secret");


    }

    private static final SignatureAlgorithm sigAlg = SignatureAlgorithm.HS256;

    private Key signingKey;

    public String getHeader() {
        return header;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSecret() {
        return secret;
    }

    public long getExpiration() {
        return expiration;
    }

    public SignatureAlgorithm getSigAlg() {
        return sigAlg;
    }

    public Key getSigningKey() {
        return signingKey;
    }

    @PostConstruct
    public void postConstruct() {
        byte[] secretBytes = DatatypeConverter.parseBase64Binary(secret);
        signingKey = new SecretKeySpec(secretBytes, sigAlg.getJcaName());
    }

}

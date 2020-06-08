package com.mysite.work.util.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysite.work.user.vo.UserVO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtServiceUtil  {

    private String secretKey = "Trouth2897SecurityKey";

    private Logger logger = LoggerFactory.getLogger(JwtServiceUtil.class);    
    
    public String makeJwt(HttpServletRequest res,UserVO userVO) throws Exception {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Date expireTime = new Date();
        expireTime.setTime(expireTime.getTime() + 1000 * 60 * 5);
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        Map<String, Object> headerMap = new HashMap<String, Object>();
        headerMap.put("typ","JWT");
        headerMap.put("alg","HS256");
        
        Map<String, Object> map= new HashMap<String, Object>(); 
        map.put("serialVersionUID",userVO.getSerialVersionUID());
        map.put("uid",userVO.getUid());
        map.put("name",userVO.getName());
        map.put("email",userVO.getEmail());
        map.put("grade",userVO.getGrade());
        map.put("reg_dt",userVO.getReg_dt());
        JwtBuilder builder = Jwts.builder().setHeader(headerMap)
                .setClaims(map)
                .setExpiration(expireTime)
                .signWith(signatureAlgorithm, signingKey);

        return builder.compact();
    }
 
    public boolean checkJwt(String jwt) throws Exception {
        try {
            Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
                    .parseClaimsJws(jwt).getBody(); // 정상 수행된다면 해당 토큰은 정상토큰

            logger.info("expireTime :" + claims.getExpiration());
            logger.info("name :" + claims.get("name"));
            logger.info("Email :" + claims.get("email"));
            logger.info("serialVersionUID :" + claims.get("serialVersionUID"));

            return true;
        } catch (ExpiredJwtException exception) {
            logger.info("토큰 만료");
            return false;
        } catch (JwtException exception) {
            logger.info("토큰 변조");
            return false;
        }
    }

    public String makeJwt(HttpServletRequest res) throws Exception {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Date expireTime = new Date();
        expireTime.setTime(expireTime.getTime() + 1000 * 60 * 1);
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        Map<String, Object> headerMap = new HashMap<String, Object>();

        headerMap.put("typ","JWT");
        headerMap.put("alg","HS256");

        Map<String, Object> map= new HashMap<String, Object>();

        String name = res.getParameter("name");
        String email = res.getParameter("email");

        map.put("name", name);
        map.put("email", email);

        JwtBuilder builder = Jwts.builder().setHeader(headerMap)
                .setClaims(map)
                .setExpiration(expireTime)
                .signWith(signatureAlgorithm, signingKey);

        return builder.compact();
    }
}
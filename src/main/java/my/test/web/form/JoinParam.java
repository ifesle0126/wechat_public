package my.test.web.form;


import my.test.utils.SHA1Util;

import java.util.Arrays;

public class JoinParam {

    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;


    public boolean validate() {
        if (signature == null || signature.length() <= 0) {
            throw new RuntimeException("parameters error. signature can not be empty");
        }
        return signature.equals(encrypt());
    }

    private String encrypt() {
        String str = sort();
        return SHA1Util.getSHA1(str);
    }

    private String sort() {
        String[] params = new String[]{this.signature, this.timestamp, this.nonce};
        Arrays.sort(params);
        StringBuilder sb = new StringBuilder();
        sb.append(params);
        return sb.toString();
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }
}

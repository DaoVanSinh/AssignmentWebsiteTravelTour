package com.tourvn.service;

import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class VNPayService {

    private final String vnp_TmnCode = "LQCHL2XW";
    private final String vnp_HashSecret = "NUQXU14OVQ6SDS6UCPFKJOLYYAJX3GTU";

    private final String vnp_PayUrl = "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html";

    private final String vnp_ReturnUrl = "http://localhost:8080/api/payments/vnpay-return";

    public String createPaymentUrl(Long bookingId, Double amount) {

        try {

            String txnRef = String.valueOf(System.currentTimeMillis());

            long vnpAmount = (long) (amount * 100);

            Map<String, String> params = new HashMap<>();

            params.put("vnp_Version", "2.1.0");
            params.put("vnp_Command", "pay");
            params.put("vnp_TmnCode", vnp_TmnCode);
            params.put("vnp_Amount", String.valueOf(vnpAmount));
            params.put("vnp_CurrCode", "VND");
            params.put("vnp_TxnRef", txnRef);
            params.put("vnp_OrderInfo", "Thanh toan tour " + bookingId);
            params.put("vnp_OrderType", "other");
            params.put("vnp_Locale", "vn");
            params.put("vnp_ReturnUrl", vnp_ReturnUrl);
            params.put("vnp_IpAddr", "127.0.0.1");

            String createDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

            params.put("vnp_CreateDate", createDate);

            List<String> fieldNames = new ArrayList<>(params.keySet());

            Collections.sort(fieldNames);

            StringBuilder hashData = new StringBuilder();
            StringBuilder query = new StringBuilder();

            for (int i = 0; i < fieldNames.size(); i++) {

                String fieldName = fieldNames.get(i);
                String value = params.get(fieldName);

                String encodedValue = URLEncoder.encode(value, StandardCharsets.UTF_8);

                hashData.append(fieldName).append("=").append(encodedValue);
                query.append(fieldName).append("=").append(encodedValue);

                if (i < fieldNames.size() - 1) {
                    hashData.append("&");
                    query.append("&");
                }
            }

            String secureHash = hmacSHA512(vnp_HashSecret, hashData.toString());

            query.append("&vnp_SecureHash=").append(secureHash);

            return vnp_PayUrl + "?" + query;

        } catch (Exception e) {

            throw new RuntimeException("VNPay error");
        }
    }

    private String hmacSHA512(String key, String data) throws Exception {

        Mac mac = Mac.getInstance("HmacSHA512");

        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "HmacSHA512");

        mac.init(secretKey);

        byte[] hash = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));

        StringBuilder hex = new StringBuilder();

        for (byte b : hash) {

            hex.append(String.format("%02x", b));

        }

        return hex.toString();
    }
}

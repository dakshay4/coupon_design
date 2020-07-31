package com.dakshay.response;

/**
 * Created by Dakshay on 10/28/2018.
 */
public class PromoCodeResponseBean extends CommonResponseBean{
    String PromoCode;

    public PromoCodeResponseBean(String errorMessage) {
        super(errorMessage);
    }

    public PromoCodeResponseBean(int code, String errorMessage) {
        super(code, errorMessage);
    }

    public String getPromoCode() {
        return PromoCode;
    }

    public void setPromoCode(String promoCode) {
        PromoCode = promoCode;
    }
}

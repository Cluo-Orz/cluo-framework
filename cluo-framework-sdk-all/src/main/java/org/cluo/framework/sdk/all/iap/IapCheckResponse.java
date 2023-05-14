package org.cluo.framework.sdk.all.iap;

import java.io.Serializable;

/**
 * author: thone
 * time: 2019/6/19 下午9:08
 * desc: //TODO
 **/
public class IapCheckResponse implements Serializable {
    private Integer status;

    private Receipt receipt;

    public static class Receipt implements Serializable{
        private String original_purchase_date_pst;

        private String purchase_date_ms;

        private String unique_identifier;

        private String original_transaction_id;

        private String bvrs;

        private String transaction_id;

        private String quantity;

        private String unique_vendor_identifier;

        private String item_id;

        private String version_external_identifier;

        private String bid;

        private String is_in_intro_offer_period;

        private String product_id;

        private String purchase_date;

        private String is_trial_period;

        private String purchase_date_pst;

        private String original_purchase_date;

        private String original_purchase_date_ms;

        public String getOriginal_purchase_date_pst() {
            return original_purchase_date_pst;
        }

        public void setOriginal_purchase_date_pst(String original_purchase_date_pst) {
            this.original_purchase_date_pst = original_purchase_date_pst;
        }

        public String getPurchase_date_ms() {
            return purchase_date_ms;
        }

        public void setPurchase_date_ms(String purchase_date_ms) {
            this.purchase_date_ms = purchase_date_ms;
        }

        public String getUnique_identifier() {
            return unique_identifier;
        }

        public void setUnique_identifier(String unique_identifier) {
            this.unique_identifier = unique_identifier;
        }

        public String getOriginal_transaction_id() {
            return original_transaction_id;
        }

        public void setOriginal_transaction_id(String original_transaction_id) {
            this.original_transaction_id = original_transaction_id;
        }

        public String getBvrs() {
            return bvrs;
        }

        public void setBvrs(String bvrs) {
            this.bvrs = bvrs;
        }

        public String getTransaction_id() {
            return transaction_id;
        }

        public void setTransaction_id(String transaction_id) {
            this.transaction_id = transaction_id;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public String getUnique_vendor_identifier() {
            return unique_vendor_identifier;
        }

        public void setUnique_vendor_identifier(String unique_vendor_identifier) {
            this.unique_vendor_identifier = unique_vendor_identifier;
        }

        public String getItem_id() {
            return item_id;
        }

        public void setItem_id(String item_id) {
            this.item_id = item_id;
        }

        public String getVersion_external_identifier() {
            return version_external_identifier;
        }

        public void setVersion_external_identifier(String version_external_identifier) {
            this.version_external_identifier = version_external_identifier;
        }

        public String getBid() {
            return bid;
        }

        public void setBid(String bid) {
            this.bid = bid;
        }

        public String getIs_in_intro_offer_period() {
            return is_in_intro_offer_period;
        }

        public void setIs_in_intro_offer_period(String is_in_intro_offer_period) {
            this.is_in_intro_offer_period = is_in_intro_offer_period;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getPurchase_date() {
            return purchase_date;
        }

        public void setPurchase_date(String purchase_date) {
            this.purchase_date = purchase_date;
        }

        public String getIs_trial_period() {
            return is_trial_period;
        }

        public void setIs_trial_period(String is_trial_period) {
            this.is_trial_period = is_trial_period;
        }

        public String getPurchase_date_pst() {
            return purchase_date_pst;
        }

        public void setPurchase_date_pst(String purchase_date_pst) {
            this.purchase_date_pst = purchase_date_pst;
        }

        public String getOriginal_purchase_date() {
            return original_purchase_date;
        }

        public void setOriginal_purchase_date(String original_purchase_date) {
            this.original_purchase_date = original_purchase_date;
        }

        public String getOriginal_purchase_date_ms() {
            return original_purchase_date_ms;
        }

        public void setOriginal_purchase_date_ms(String original_purchase_date_ms) {
            this.original_purchase_date_ms = original_purchase_date_ms;
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }
}

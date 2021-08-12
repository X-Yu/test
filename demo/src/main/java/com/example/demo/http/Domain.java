package com.example.demo.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @ClassName : Domain  //类名
 * @Description :   //描述
 * @Author : lhy  //作者
 * @Date: 2020-12-15 09:58  //时间
 */
public class Domain {
    public static void main(String[] args) throws IOException {
        String url="http://106.75.224.100:8901/zsresearch/property-card/add?f_project_number=TXN00001&f_property_name=资产01&f_property_number=ZC001&f_use_state=研发中&f_economics_use=经济用途&f_company=公司&f_use_department=使用部门&f_original_moeny&f_original_currency&f_exchange_rate&f_property_original&f_entry_time&f_begin_use_time&f_plan_use_year_accounting&f_plan_use_year_tax_law&f_plan_use_period_accounting&f_plan_use_period_tax_law&f_depreciation_method&f_plan_balance&f_contract_name=合同名&f_contract_number=HT0001&f_contract_type&f_contract_signed_time&f_contract_money&f_contract_file_id&f_receive_entrust_name&f_receive_entrust_flag&f_entrust_mode&f_contract_flag&f_contract_register_time";
        m1(url);
    }

    public static void m1(String url) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
//        httpGet.setHeader(new BasicHeader());
        HttpResponse response = client.execute(httpGet);
        int code = response.getStatusLine().getStatusCode();
        if (code == 200) {
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "UTF-8");
            System.out.println(result);
        }
    }
}

package com.hps.integrator.tests.checks;

import PosGateway.Exchange.Hps.Enums;
import com.hps.integrator.entities.check.HpsCheck;
import com.hps.integrator.entities.check.HpsCheckResponse;
import com.hps.integrator.infrastructure.HpsCheckException;
import com.hps.integrator.infrastructure.HpsException;
import com.hps.integrator.services.HpsCheckService;
import com.hps.integrator.tests.testdata.TestCheck;
import com.hps.integrator.tests.testdata.TestServicesConfig;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CertRetailTests {
    // start ACH Debit Consumer Tests

    @Test
    public void check_ACHDebitConsumer1Swipe() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertServicesConfigWithDescriptor());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(11.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());

        HpsCheckResponse voidResponse = service.voidSale(response.getTransactionID());
        assertEquals("0", voidResponse.getResponseCode());
        assertEquals("Transaction Approved", voidResponse.getResponseText());
    }

    @Test
         public void check_ACHDebitConsumer2SwipeCheckingBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setCheckType(Enums.checkTypeType.BUSINESS);
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertServicesConfigWithDescriptor());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(12.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_ACHDebitConsumer3SwipeSavings() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setAccountType(Enums.accountTypeType.SAVINGS);
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertServicesConfigWithDescriptor());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(14.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_ACHDebitConsumer4SwipeSavingsBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setAccountType(Enums.accountTypeType.SAVINGS);
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);
        check.setCheckType(Enums.checkTypeType.BUSINESS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertServicesConfigWithDescriptor());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(15.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_ACHDebitConsumer5() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertServicesConfigWithDescriptor());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(16.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());

        HpsCheckResponse voidResponse = service.voidSale(response.getTransactionID());
        assertEquals("0", voidResponse.getResponseCode());
        assertEquals("Transaction Approved", voidResponse.getResponseText());
    }

    @Test
    public void check_ACHDebitConsumer6CheckingBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setCheckType(Enums.checkTypeType.BUSINESS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertServicesConfigWithDescriptor());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(17.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_ACHDebitConsumer7SavingsPersonal() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setAccountType(Enums.accountTypeType.SAVINGS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertServicesConfigWithDescriptor());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(18.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_ACHDebitConsumer8SavingsBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setAccountType(Enums.accountTypeType.SAVINGS);
        check.setCheckType(Enums.checkTypeType.BUSINESS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertServicesConfigWithDescriptor());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(19.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    // end ACH Debit Consumer Tests

    // start ACH Debit Corporate Tests

    @Test
    public void check_ACHDebitCorporate9Swipe() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("CCD"); // this may need to be lowercase
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);
        check.getCheckHolder().setCheckName("Heartland Pays");

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertServicesConfigWithDescriptor());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(11.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_ACHDebitCorporate10SwipeCheckingBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("CCD"); // this may need to be lowercase
        check.setCheckType(Enums.checkTypeType.BUSINESS);
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);
        check.getCheckHolder().setCheckName("Heartland Pays");

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertServicesConfigWithDescriptor());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(12.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());

        HpsCheckResponse voidResponse = service.voidSale(response.getTransactionID());
        assertEquals("0", voidResponse.getResponseCode());
        assertEquals("Transaction Approved", voidResponse.getResponseText());
    }

    @Test
    public void check_ACHDebitCorporate11SwipeSavingsPersonal() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("CCD"); // this may need to be lowercase
        check.setAccountType(Enums.accountTypeType.SAVINGS);
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);
        check.getCheckHolder().setCheckName("Heartland Pays");

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertServicesConfigWithDescriptor());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(14.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_ACHDebitCorporate12SwipeSavingsBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("CCD"); // this may need to be lowercase
        check.setAccountType(Enums.accountTypeType.SAVINGS);
        check.setCheckType(Enums.checkTypeType.BUSINESS);
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);
        check.getCheckHolder().setCheckName("Heartland Pays");

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertServicesConfigWithDescriptor());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(15.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_ACHDebitConsumerCorporate13() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("CCD"); // this may need to be lowercase
        check.getCheckHolder().setCheckName("Heartland Pays");

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertServicesConfigWithDescriptor());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(16.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_ACHDebitCorporate14CheckingBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("CCD"); // this may need to be lowercase
        check.setCheckType(Enums.checkTypeType.BUSINESS);
        check.getCheckHolder().setCheckName("Heartland Pays");

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertServicesConfigWithDescriptor());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(17.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());

        HpsCheckResponse voidResponse = service.voidSale(response.getTransactionID());
        assertEquals("0", voidResponse.getResponseCode());
        assertEquals("Transaction Approved", voidResponse.getResponseText());
    }

    @Test
    public void check_ACHDebitCorporate15SavingsPersonal() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("CCD"); // this may need to be lowercase
        check.setAccountType(Enums.accountTypeType.SAVINGS);
        check.getCheckHolder().setCheckName("Heartland Pays");

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertServicesConfigWithDescriptor());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(18.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_ACHDebitCorporate16SavingsBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("CCD"); // this may need to be lowercase
        check.setAccountType(Enums.accountTypeType.SAVINGS);
        check.setCheckType(Enums.checkTypeType.BUSINESS);
        check.getCheckHolder().setCheckName("Heartland Pays");

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertServicesConfigWithDescriptor());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(19.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    // end ACH Debit Corporate Tests

    // start ACH eGold Tests

    @Test
    public void check_EGold17Swipe() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("POP"); // this may need to be lowercase
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validEGoldConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(11.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_EGold18SwipeCheckingBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setCheckType(Enums.checkTypeType.BUSINESS);
        check.setSecCode("POP"); // this may need to be lowercase
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validEGoldConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(12.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_EGold19SwipeSavingsPersonal() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("POP"); // this may need to be lowercase
        check.setAccountType(Enums.accountTypeType.SAVINGS);
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validEGoldConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(14.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());

        HpsCheckResponse voidResponse = service.voidSale(response.getTransactionID());
        assertEquals("0", voidResponse.getResponseCode());
        assertEquals("Transaction Approved", voidResponse.getResponseText());
    }

    @Test
    public void check_EGold20SwipeSavingsBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("POP"); // this may need to be lowercase
        check.setAccountType(Enums.accountTypeType.SAVINGS);
        check.setCheckType(Enums.checkTypeType.BUSINESS);
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validEGoldConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(15.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
         public void check_EGold21() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("POP"); // this may need to be lowercase

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validEGoldConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(16.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
         public void check_EGold22CheckingBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("POP"); // this may need to be lowercase
        check.setCheckType(Enums.checkTypeType.BUSINESS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validEGoldConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(17.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_EGold23SavingsPersonal() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("POP"); // this may need to be lowercase
        check.setAccountType(Enums.accountTypeType.SAVINGS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validEGoldConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(18.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());

        HpsCheckResponse voidResponse = service.voidSale(response.getTransactionID());
        assertEquals("0", voidResponse.getResponseCode());
        assertEquals("Transaction Approved", voidResponse.getResponseText());
    }

    @Test
    public void check_EGold24SavingsBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("POP"); // this may need to be lowercase
        check.setAccountType(Enums.accountTypeType.SAVINGS);
        check.setCheckType(Enums.checkTypeType.BUSINESS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validEGoldConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(19.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    // end ACH eGold Tests

    // start ACH eSilver Tests

    @Test
    public void check_ESilver25Swipe() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("POP"); // this may need to be lowercase
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validEGoldConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(11.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_ESilver26SwipeCheckingBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("POP"); // this may need to be lowercase
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);
        check.setCheckType(Enums.checkTypeType.BUSINESS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validEGoldConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(12.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_ESilver27SwipeSavingsPersonal() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("POP"); // this may need to be lowercase
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);
        check.setAccountType(Enums.accountTypeType.SAVINGS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validEGoldConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(14.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_ESilver28SwipeSavingsBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("POP"); // this may need to be lowercase
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);
        check.setAccountType(Enums.accountTypeType.SAVINGS);
        check.setCheckType(Enums.checkTypeType.BUSINESS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validEGoldConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(15.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());

        HpsCheckResponse voidResponse = service.voidSale(response.getTransactionID());
        assertEquals("0", voidResponse.getResponseCode());
        assertEquals("Transaction Approved", voidResponse.getResponseText());
    }

    @Test
    public void check_ESilver29() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("POP"); // this may need to be lowercase

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validEGoldConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(16.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_ESilver30CheckingBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("POP"); // this may need to be lowercase
        check.setCheckType(Enums.checkTypeType.BUSINESS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validEGoldConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(17.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_ESilver31SavingsPersonal() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("POP"); // this may need to be lowercase
        check.setAccountType(Enums.accountTypeType.SAVINGS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validEGoldConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(18.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_ESilver32SavingsBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("POP"); // this may need to be lowercase
        check.setAccountType(Enums.accountTypeType.SAVINGS);
        check.setCheckType(Enums.checkTypeType.BUSINESS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validEGoldConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(19.00));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());

        HpsCheckResponse voidResponse = service.voidSale(response.getTransactionID());
        assertEquals("0", voidResponse.getResponseCode());
        assertEquals("Transaction Approved", voidResponse.getResponseText());
    }

    // end ACH eSilver Tests

    // start ACH eBronze Tests

    @Test
    public void check_EBronzeVerify33SwipeCheckingPersonal() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("eBronze"); // this may need to be lowercase
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertMultiUseConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(1));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_EBronzeVerify34SwipeCheckingBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("eBronze"); // this may need to be lowercase
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);
        check.setCheckType(Enums.checkTypeType.BUSINESS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertMultiUseConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(1));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_EBronzeVerify35SwipeSavingsPersonal() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("eBronze"); // this may need to be lowercase
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);
        check.setAccountType(Enums.accountTypeType.SAVINGS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertMultiUseConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(1));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_EBronzeVerify36SwipeSavingsBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("eBronze"); // this may need to be lowercase
        check.setDataEntryMode(Enums.dataEntryModeType.SWIPE);
        check.setAccountType(Enums.accountTypeType.SAVINGS);
        check.setCheckType(Enums.checkTypeType.BUSINESS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertMultiUseConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(1));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_EBronzeVerify37CheckingPersonal() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("eBronze"); // this may need to be lowercase

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertMultiUseConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(1));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_EBronzeVerify38CheckingBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("eBronze"); // this may need to be lowercase
        check.setCheckType(Enums.checkTypeType.BUSINESS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertMultiUseConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(1));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_EBronzeVerify39SavingsPersonal() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("eBronze"); // this may need to be lowercase
        check.setAccountType(Enums.accountTypeType.SAVINGS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertMultiUseConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(1));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    @Test
    public void check_EBronzeVerify40SavingsBusiness() throws HpsException, HpsCheckException {
        HpsCheck check = TestCheck.certification();
        check.setSecCode("eBronze"); // this may need to be lowercase
        check.setAccountType(Enums.accountTypeType.SAVINGS);
        check.setCheckType(Enums.checkTypeType.BUSINESS);

        HpsCheckService service = new HpsCheckService(TestServicesConfig.validCertMultiUseConfig());
        HpsCheckResponse response = service.sale(TestCheck.certification(), new BigDecimal(1));
        assertNotNull(response);
        assertEquals("0", response.getResponseCode());
        assertEquals("Transaction Approved", response.getResponseText());
    }

    // end ACH eBronze Tests
}

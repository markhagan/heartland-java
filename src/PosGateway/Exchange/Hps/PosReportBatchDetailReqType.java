package PosGateway.Exchange.Hps;

import java.util.Hashtable;

import org.ksoap2.serialization.*;

public class PosReportBatchDetailReqType extends AttributeContainer implements KvmSerializable {

    public Integer BatchId;

    public Enums.tzoneConversionType TzConversion;

    public PosReportBatchDetailReqType() {
    }

    public PosReportBatchDetailReqType(AttributeContainer inObj, ExtendedSoapSerializationEnvelope envelope) {

        if (inObj == null)
            return;


        SoapObject soapObject = (SoapObject) inObj;
        if (soapObject.hasProperty("BatchId")) {
            Object obj = soapObject.getProperty("BatchId");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                if (j.toString() != null) {
                    this.BatchId = Integer.parseInt(j.toString());
                }
            } else if (obj != null && obj instanceof Integer) {
                this.BatchId = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("TzConversion")) {
            Object obj = soapObject.getProperty("TzConversion");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                if (j.toString() != null) {
                    this.TzConversion = Enums.tzoneConversionType.fromString(j.toString());
                }
            } else if (obj != null && obj instanceof Enums.tzoneConversionType) {
                this.TzConversion = (Enums.tzoneConversionType) obj;
            }
        }


    }

    @Override
    public Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if (propertyIndex == 0) {
            return BatchId != null ? BatchId : SoapPrimitive.NullSkip;
        }
        if (propertyIndex == 1) {
            return TzConversion != null ? TzConversion.toString() : SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 2;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        if (propertyIndex == 0) {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "BatchId";
            info.namespace = "http://Hps.Exchange.PosGateway";
        }
        if (propertyIndex == 1) {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "TzConversion";
            info.namespace = "http://Hps.Exchange.PosGateway";
        }
    }

    @Override
    public void setProperty(int arg0, Object arg1) {
    }

}

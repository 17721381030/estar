package com.estar.judgment.evaluation.web.frame.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Map;

import ognl.DefaultTypeConverter;

/**
 * @author zhousy
 * @version 1.0
 */
public class MoneyConverter extends DefaultTypeConverter {

    @SuppressWarnings("unchecked")
	public Object convertValue(Map context, Object object, Class toType) {
        DecimalFormat format = new DecimalFormat("$#0.00");
        if (toType == String.class) {
            BigDecimal d = (BigDecimal) object;
            if (d == null) {
                d = new BigDecimal(0);
            }

            return format.format(d.doubleValue());
        } else if (toType == BigDecimal.class) {
            String s = ((String[]) object)[0];
            try {
                return new BigDecimal(format.parse(s).doubleValue());
            } catch (ParseException e) {
                DecimalFormat backup = new DecimalFormat("#0.00");
                try {
                    return new BigDecimal(backup.parse(s).doubleValue());
                } catch (ParseException e1) {
                }
            }
        }
        return null;
    }
}
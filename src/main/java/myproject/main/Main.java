package myproject.main;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import myproject.service.CurrencyService;
import myproject.wsdl.currency.Currency;

public class Main {
    private static Logger log = Logger.getLogger(Main.class);
 
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CurrencyService currencyService = context.getBean(CurrencyService.class);
 
        Currency fromCurrency = Currency.USD;
        Currency toCurrency = Currency.GBP;
        Double conversionRate = currencyService.getConversionRate(fromCurrency, toCurrency);
 
        log.info(String.format("The conversion rate from %s to %s is %s.", fromCurrency, toCurrency, conversionRate));
    }
}
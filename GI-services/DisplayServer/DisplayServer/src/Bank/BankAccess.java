package Bank;

import EJBModule.Interface.BankClientInformation;
import EJBModule.Response.BankClient;
import EJBModule.glassfish7.Lookup;

public class BankAccess{
    
    
    
    public static BankClient getBankInfo(String NCI) throws Exception
    {
        Lookup<BankClientInformation> lookup = new Lookup<BankClientInformation>("localhost", "3700");
        BankClientInformation bk = lookup.getObject("Bank/ImplementationBankClientInformation", "EJBModule.Interface.BankClientInformation");

        return bk.getInformation(NCI);
    }

    
    public static String getBankHtmlInfo(String NCI) throws Exception
    {
        BankClient b = BankAccess.getBankInfo(NCI);
        return "<div class=\"col-lg-4 col-md-6 u-s-m-b-30\">\n" +
               "    <div class=\"bp-mini bp-mini--img u-h-100\">\n" +
               "        <div class=\"bp-mini__thumbnail\">\n" +
               "            <a class=\"aspect aspect--bg-grey aspect--1366-768 u-d-block\">\n" +
               "                <img class=\"aspect__img\" src=\"images/blog/post-2.jpg\" alt=\"\"></a>\n" +
               "        </div>\n" +
               "        <div class=\"bp-mini__content\">\n" +
               "            <div class=\"bp-mini__stat\">\n" +
               "                <span class=\"bp-mini__stat-wrap\">\n" +
               "                    <span class=\"bp-mini__publish-date\">\n" +
               "                        <a>\n" +
               "                            <span> Total amount </span></a></span></span>\n" +
               "                <span class=\"bp-mini__stat-wrap\">\n" +
               "                    <span class=\"bp-mini__author\">\n" +
               "                        <a>Dayle</a></span></span>\n" +
               "            </div>\n" +
               "            <span class=\"bp-mini__h1\">\n" +
               "                <a> AR"+ b.getAmount() +" </a></span>\n" +
               "        </div>\n" +
               "    </div>\n"  
               ;
    }
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) throws Exception 
    {
        System.out.println(BankAccess.getBankInfo("54651248"));

    }

}

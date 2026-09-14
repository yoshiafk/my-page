package com.mypage.leads.portlet;

import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.mypage.admin.product.model.TravelInternationalPremi;
import com.mypage.leads.constants.MypageLeadsPortletKeys;
import com.mypage.leads.constants.PaymentPortletKeys;
import com.mypage.leads.model.Payment;
import com.mypage.leads.service.PaymentLocalService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Gositus
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.add-default-resource=true",
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.private-session-attributes=false",
			"com.liferay.portlet.use-default-template=true",
			"javax.portlet.display-name=Payment",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/payment/list.jsp",
			"javax.portlet.name=" + PaymentPortletKeys.PAYMENT,
			"javax.portlet.resource-bundle=content.Language", 
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.init-param.add-process-action-success-action=false"
		},
		service = Portlet.class
	)
public class PaymentPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		// TODO Auto-generated method stub
		super.render(renderRequest, renderResponse);
	}
	
	public void addPayment(ActionRequest actionRequest,
            ActionResponse actionResponse) throws IOException, PortletException, PortalException, ParseException {
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Payment.class.getName(),
				actionRequest);
		long userId = serviceContext.getUserId();
		long paymentId = ParamUtil.getLong(actionRequest, "paymentId");
		
		String newFormatDate = "dd-MM-yyyy HH:mm:ss";
		
		String TransactionId = ParamUtil.getString(actionRequest, "TransactionId");
		String SessionId = ParamUtil.getString(actionRequest, "SessionId");
		Long LeadsId = ParamUtil.getLong(actionRequest, "LeadsId");
		Double Amount = ParamUtil.getDouble(actionRequest, "Amount");
		Double Discount = ParamUtil.getDouble(actionRequest, "Discount");
		Double DiscountAmount = ParamUtil.getDouble(actionRequest, "DiscountAmount");
		String PaymentStatus = ParamUtil.getString(actionRequest, "PaymentStatus");
		String PaymentChannelId = ParamUtil.getString(actionRequest, "PaymentChannelId");
		String LinkAjaRefNum = ParamUtil.getString(actionRequest, "LinkAjaRefNum");
		String Tenor = ParamUtil.getString(actionRequest, "Tenor");
		String PaymentCode = ParamUtil.getString(actionRequest, "PaymentCode");
		String PaymentMessage = ParamUtil.getString(actionRequest, "PaymentMessage");
		String CreditCardType = ParamUtil.getString(actionRequest, "CreditCardType");
		
		String TransactionDateTime = "";
		String getTransactionDateTime = ParamUtil.getString(actionRequest, "TransactionDateTime");
		String TransactionDateTime_time = ParamUtil.getString(actionRequest, "TransactionDateTime_time");
		if(!getTransactionDateTime.isEmpty() && !TransactionDateTime_time.isEmpty()) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			getTransactionDateTime += " " + TransactionDateTime_time;
			Date transactionDate = sdf.parse(getTransactionDateTime);
			sdf.applyPattern(newFormatDate);
			TransactionDateTime = sdf.format(transactionDate);
		}
		
		String PaymentDateTime = "";
		String getPaymentDateTime = ParamUtil.getString(actionRequest, "PaymentDateTime");
		String PaymentDateTime_time = ParamUtil.getString(actionRequest, "PaymentDateTime_time");
		
		if(!getPaymentDateTime.isEmpty() && !PaymentDateTime_time.isEmpty()) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			getPaymentDateTime += " " + PaymentDateTime_time;
			Date paymentDate = sdf.parse(getPaymentDateTime);
			sdf.applyPattern(newFormatDate);
			PaymentDateTime = sdf.format(paymentDate);
		}
		
		String Bank = ParamUtil.getString(actionRequest, "Bank");
		long ManagedBy = ParamUtil.getLong(actionRequest, "ManagedBy");
		int ReportGenerated = ParamUtil.getInteger(actionRequest, "ReportGenerated");
		int DailyReportGenerated = ParamUtil.getInteger(actionRequest, "DailyReportGenerated");
		int WeeklyReportGenerated = ParamUtil.getInteger(actionRequest, "WeeklyReportGenerated");
		int MonthlyReportGenerated = ParamUtil.getInteger(actionRequest, "MonthlyReportGenerated");
		String CheckStatusCounter = ParamUtil.getString(actionRequest, "CheckStatusCounter");
		long UserCreditId = ParamUtil.getLong(actionRequest, "UserCreditId");
		String CreditPaymentStatus = ParamUtil.getString(actionRequest, "CreditPaymentStatus");
		String CreditTransactionId = ParamUtil.getString(actionRequest, "CreditTransactionId");
		String CreditPaymentDate = "";
		String getCreditPaymentDate = ParamUtil.getString(actionRequest, "CreditPaymentDate");
		String CreditPaymentDate_time = ParamUtil.getString(actionRequest, "CreditPaymentDate_time");

		if(!getCreditPaymentDate.isEmpty() && !CreditPaymentDate_time.isEmpty()) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			getCreditPaymentDate += " " + CreditPaymentDate_time;
			Date creditDate = sdf.parse(getCreditPaymentDate);
			sdf.applyPattern(newFormatDate);
			CreditPaymentDate = sdf.format(creditDate);
		}
		
		String CreditPaymentChannelId = ParamUtil.getString(actionRequest, "CreditPaymentChannelId");
		String CreditBank = ParamUtil.getString(actionRequest, "CreditBank");
		String CreditPaymentCode = ParamUtil.getString(actionRequest, "CreditPaymentCode");
		String CreditPaymentMessage = ParamUtil.getString(actionRequest, "CreditPaymentMessage");
		int ReportSettlementGenerated = ParamUtil.getInteger(actionRequest, "ReportSettlementGenerated");
		String CreditSettlementAttachmentId = ParamUtil.getString(actionRequest, "CreditSettlementAttachmentId");
		long UtmId = ParamUtil.getLong(actionRequest, "UtmId");
		int Sojern = ParamUtil.getInteger(actionRequest, "Sojern");
		int InvolveAsia = ParamUtil.getInteger(actionRequest, "InvolveAsia");
		int Ada = ParamUtil.getInteger(actionRequest, "Ada");
		int active = ParamUtil.getInteger(actionRequest, "active");

		JSONObject data = JSONFactoryUtil.createJSONObject();
		data.put("TransactionId", TransactionId);
		data.put("SessionId", SessionId);
		data.put("LeadsId", LeadsId);
		data.put("Amount", Amount);
		data.put("Discount", Discount);
		data.put("DiscountAmount", DiscountAmount);
		data.put("PaymentStatus", PaymentStatus);
		data.put("PaymentChannelId", PaymentChannelId);
		data.put("LinkAjaRefNum", LinkAjaRefNum);
		data.put("Tenor", Tenor);
		data.put("PaymentCode", PaymentCode);
		data.put("PaymentMessage", PaymentMessage);
		data.put("CreditCardType", CreditCardType);
		data.put("TransactionDateTime", TransactionDateTime);
		data.put("PaymentDateTime", PaymentDateTime);
		data.put("Bank", Bank);
		data.put("ManagedBy", ManagedBy);
		data.put("ReportGenerated", ReportGenerated);
		data.put("DailyReportGenerated", DailyReportGenerated);
		data.put("WeeklyReportGenerated", WeeklyReportGenerated);
		data.put("MonthlyReportGenerated", MonthlyReportGenerated);
		data.put("CheckStatusCounter", CheckStatusCounter);
		data.put("UserCreditId", UserCreditId);
		data.put("CreditPaymentStatus", CreditPaymentStatus);
		data.put("CreditTransactionId", CreditTransactionId);
		data.put("CreditPaymentDate", CreditPaymentDate);
		data.put("CreditPaymentChannelId", CreditPaymentChannelId);
		data.put("CreditBank", CreditBank);
		data.put("CreditPaymentCode", CreditPaymentCode);
		data.put("CreditPaymentMessage", CreditPaymentMessage);
		data.put("ReportSettlementGenerated", ReportSettlementGenerated);
		data.put("CreditSettlementAttachmentId", CreditSettlementAttachmentId);
		data.put("UtmId", UtmId);
		data.put("Sojern", Sojern);
		data.put("InvolveAsia", InvolveAsia);
		data.put("Ada", Ada);
		data.put("Active", active);
		
		_paymentLocalService.addPayment(userId, paymentId, data, serviceContext);
		
		SessionMessages.add(actionRequest, "success-save-payment");
		actionResponse.setRenderParameter("mvcPath", "/payment/list.jsp");
	}
	
	@Reference
	private PaymentLocalService _paymentLocalService;
}

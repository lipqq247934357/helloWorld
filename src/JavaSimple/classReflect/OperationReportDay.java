package JavaSimple.classReflect;

import java.util.List;

/**
 * 
 * @Description: 运营报告_日报
 * @Author zhengrj
 * @Date 2016年7月7日上午10:05:03
 */
public class OperationReportDay {

	// 日期
	private Long date;

	// 注册用户数
	private Long registCount;

	// 实名人数
	private Long realCount;

	// 充值人数
	private Long rechargeCount;

	// 直投人数 (统计日当日注册当日投资人数)
	private Long inRegInInvCount;

	// 新用户(当日第一次投资用户数)
	private Long newInvestCount;

	// 投资人数 (统计有成功投资记录的人数，直投)
	private Long investCount;

	// 活期投资用户 (当日有活期投资记录)
	private Long xInvestCount;

	// 新增活期投资用户 (统计新做活期投资的用户，必须有活期投资操作，余额不限，且无直投)
	private Long newxInvestCount;

	// 直投转让发起人数(当日发起直投转让的人数，判定是否发起成功，不判定是否交易成功)
	private Long bondCount;

	// 在投人数 (有直投待收人数)
	private Long investingCount;

	// 直投回款人数 (直投项目回款)
	private Long collectCount;

	// 30天平均直投转化率
	private String avgInvReg30;

	// 直投投资额(统计日当日注册当日投资的总额)
	private String inRegInInvAmt;

	// 新用户投资金额
	private String newInvestAmt;

	// 充值金额
	private String rechargeAmt;

	// 定期投资额
	private String investAmt;

	// 新用户人均投资30天的日均值
	private String avgNewInvest30;

	// 年标投资额
	private String yearInvestAmt;

	// 回款额
	private String repayAmt;

	// 新增活期用户转入额
	private String newXInAmt;

	// 活期买入直投额
	private String xInBidAmt;

	// 活期转入额
	private String xInAmt;

	// 活期转出额
	private String xOutAmt;

	// 统计日第一次投资用户投资总额与第一次投资用户数的比值
	private String avgNewInv;

	// 新用户人均投资30天的日均值
	private String avgNewInv30;

	// 统计日总投资与投资人比值
	private String avgInv;

	// 人均投资30天均值
	private String avgInv30;

	// 昨日在投
	private Long yesInvestingCount;

	// 昨日投资人数
	private Long yesInvestCount;

	public OperationReportDay(Long date) {
		super();
		this.date = date;
	}

	public OperationReportDay() {
		super();
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public Long getRegistCount() {
		return registCount;
	}

	public void setRegistCount(Long registCount) {
		this.registCount = registCount;
	}

	public Long getRealCount() {
		return realCount;
	}

	public void setRealCount(Long realCount) {
		this.realCount = realCount;
	}

	public Long getRechargeCount() {
		return rechargeCount;
	}

	public void setRechargeCount(Long rechargeCount) {
		this.rechargeCount = rechargeCount;
	}

	public Long getInRegInInvCount() {
		return inRegInInvCount;
	}

	public void setInRegInInvCount(Long inRegInInvCount) {
		this.inRegInInvCount = inRegInInvCount;
	}

	public Long getNewInvestCount() {
		return newInvestCount;
	}

	public void setNewInvestCount(Long newInvestCount) {
		this.newInvestCount = newInvestCount;
	}

	public Long getInvestCount() {
		return investCount;
	}

	public void setInvestCount(Long investCount) {
		this.investCount = investCount;
	}

	public Long getXInvestCount() {
		return xInvestCount;
	}

	public void setXInvestCount(Long xInvestCount) {
		this.xInvestCount = xInvestCount;
	}

	public Long getNewxInvestCount() {
		return newxInvestCount;
	}

	public void setNewxInvestCount(Long newxInvestCount) {
		this.newxInvestCount = newxInvestCount;
	}

	public Long getBondCount() {
		return bondCount;
	}

	public void setBondCount(Long bondCount) {
		this.bondCount = bondCount;
	}

	public Long getInvestingCount() {
		return investingCount;
	}

	public void setInvestingCount(Long investingCount) {
		this.investingCount = investingCount;
	}

	public Long getCollectCount() {
		return collectCount;
	}

	public void setCollectCount(Long collectCount) {
		this.collectCount = collectCount;
	}

	public String getAvgInvReg30() {
		return avgInvReg30;
	}

	public void setAvgInvReg30(String avgInvReg30) {
		this.avgInvReg30 = avgInvReg30;
	}

	public String getInRegInInvAmt() {
		return inRegInInvAmt;
	}

	public void setInRegInInvAmt(String inRegInInvAmt) {
		this.inRegInInvAmt = inRegInInvAmt;
	}

	public String getNewInvestAmt() {
		return newInvestAmt;
	}

	public void setNewInvestAmt(String newInvestAmt) {
		this.newInvestAmt = newInvestAmt;
	}

	public String getRechargeAmt() {
		return rechargeAmt;
	}

	public void setRechargeAmt(String rechargeAmt) {
		this.rechargeAmt = rechargeAmt;
	}

	public String getInvestAmt() {
		return investAmt;
	}

	public void setInvestAmt(String investAmt) {
		this.investAmt = investAmt;
	}

	public String getAvgNewInvest30() {
		return avgNewInvest30;
	}

	public void setAvgNewInvest30(String avgNewInvest30) {
		this.avgNewInvest30 = avgNewInvest30;
	}

	public String getYearInvestAmt() {
		return yearInvestAmt;
	}

	public void setYearInvestAmt(String yearInvestAmt) {
		this.yearInvestAmt = yearInvestAmt;
	}

	public String getRepayAmt() {
		return repayAmt;
	}

	public void setRepayAmt(String repayAmt) {
		this.repayAmt = repayAmt;
	}

	public String getNewXInAmt() {
		return newXInAmt;
	}

	public void setNewXInAmt(String newXInAmt) {
		this.newXInAmt = newXInAmt;
	}

	public String getXInAmt() {
		return xInAmt;
	}

	public void setXInAmt(String xInAmt) {
		this.xInAmt = xInAmt;
	}

	public String getXInBidAmt() {
		return xInBidAmt;
	}

	public void setXInBidAmt(String xInBidAmt) {
		this.xInBidAmt = xInBidAmt;
	}

	public String getXOutAmt() {
		return xOutAmt;
	}

	public void setXOutAmt(String xOutAmt) {
		this.xOutAmt = xOutAmt;
	}

	public String getAvgNewInv() {
		return avgNewInv;
	}

	public void setAvgNewInv(String avgNewInv) {
		this.avgNewInv = avgNewInv;
	}

	public String getAvgNewInv30() {
		return avgNewInv30;
	}

	public void setAvgNewInv30(String avgNewInv30) {
		this.avgNewInv30 = avgNewInv30;
	}

	public String getAvgInv() {
		return avgInv;
	}

	public void setAvgInv(String avgInv) {
		this.avgInv = avgInv;
	}

	public String getAvgInv30() {
		return avgInv30;
	}

	public void setAvgInv30(String avgInv30) {
		this.avgInv30 = avgInv30;
	}

	public Long getYesInvestingCount() {
		return yesInvestingCount;
	}

	public void setYesInvestingCount(Long yesInvestingCount) {
		this.yesInvestingCount = yesInvestingCount;
	}

	public Long getYesInvestCount() {
		return yesInvestCount;
	}

	public void setYesInvestCount(Long yesInvestCount) {
		this.yesInvestCount = yesInvestCount;
	}

}

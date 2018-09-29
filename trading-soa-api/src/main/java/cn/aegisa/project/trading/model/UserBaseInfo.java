package cn.aegisa.project.trading.model;

import java.io.Serializable;


/**
 * UserBaseInfo Entity.
 */
public class UserBaseInfo implements Serializable{
	
	//列信息
	private Long uid;
	
	private Long userId;
	
	private String userName;
	
	private String imgUrl;
	
	private String region;
	
	private String mobile;
	
	private String loginPwd;
	
	private String gender;
	
	private String birthday;
	
	private String place;
	
	private java.util.Date createTime;
	
	private java.util.Date lastModifyTime;
	
	private Short userStatus;
	
	private Short userType;
	
	private String openId;
	
	private Integer integral;
	
	private Byte bindType;
	
	private Short grade;
	
	private Integer experience;
	
	private java.util.Date upgradeTime;
	
	private Integer newFlag;
	
	private String registChannel;
	
	private Integer updateVersion;
	
	private String identityCard;
	
	private Integer employeeStatus;
	

		
	public void setUid(Long value) {
		this.uid = value;
	}
	
	public Long getUid() {
		return this.uid;
	}
		
		
	public void setUserId(Long value) {
		this.userId = value;
	}
	
	public Long getUserId() {
		return this.userId;
	}
		
		
	public void setUserName(String value) {
		this.userName = value;
	}
	
	public String getUserName() {
		return this.userName;
	}
		
		
	public void setImgUrl(String value) {
		this.imgUrl = value;
	}
	
	public String getImgUrl() {
		return this.imgUrl;
	}
		
		
	public void setRegion(String value) {
		this.region = value;
	}
	
	public String getRegion() {
		return this.region;
	}
		
		
	public void setMobile(String value) {
		this.mobile = value;
	}
	
	public String getMobile() {
		return this.mobile;
	}
		
		
	public void setLoginPwd(String value) {
		this.loginPwd = value;
	}
	
	public String getLoginPwd() {
		return this.loginPwd;
	}
		
		
	public void setGender(String value) {
		this.gender = value;
	}
	
	public String getGender() {
		return this.gender;
	}
		
		
	public void setBirthday(String value) {
		this.birthday = value;
	}
	
	public String getBirthday() {
		return this.birthday;
	}
		
		
	public void setPlace(String value) {
		this.place = value;
	}
	
	public String getPlace() {
		return this.place;
	}
		
		
	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}
	
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
		
		
	public void setLastModifyTime(java.util.Date value) {
		this.lastModifyTime = value;
	}
	
	public java.util.Date getLastModifyTime() {
		return this.lastModifyTime;
	}
		
		
	public void setUserStatus(Short value) {
		this.userStatus = value;
	}
	
	public Short getUserStatus() {
		return this.userStatus;
	}
		
		
	public void setUserType(Short value) {
		this.userType = value;
	}
	
	public Short getUserType() {
		return this.userType;
	}
		
		
	public void setOpenId(String value) {
		this.openId = value;
	}
	
	public String getOpenId() {
		return this.openId;
	}
		
		
	public void setIntegral(Integer value) {
		this.integral = value;
	}
	
	public Integer getIntegral() {
		return this.integral;
	}
		
		
	public void setBindType(Byte value) {
		this.bindType = value;
	}
	
	public Byte getBindType() {
		return this.bindType;
	}
		
		
	public void setGrade(Short value) {
		this.grade = value;
	}
	
	public Short getGrade() {
		return this.grade;
	}
		
		
	public void setExperience(Integer value) {
		this.experience = value;
	}
	
	public Integer getExperience() {
		return this.experience;
	}
		
		
	public void setUpgradeTime(java.util.Date value) {
		this.upgradeTime = value;
	}
	
	public java.util.Date getUpgradeTime() {
		return this.upgradeTime;
	}
		
		
	public void setNewFlag(Integer value) {
		this.newFlag = value;
	}
	
	public Integer getNewFlag() {
		return this.newFlag;
	}
		
		
	public void setRegistChannel(String value) {
		this.registChannel = value;
	}
	
	public String getRegistChannel() {
		return this.registChannel;
	}
		
		
	public void setUpdateVersion(Integer value) {
		this.updateVersion = value;
	}
	
	public Integer getUpdateVersion() {
		return this.updateVersion;
	}
		
		
	public void setIdentityCard(String value) {
		this.identityCard = value;
	}
	
	public String getIdentityCard() {
		return this.identityCard;
	}
		
		
	public void setEmployeeStatus(Integer value) {
		this.employeeStatus = value;
	}
	
	public Integer getEmployeeStatus() {
		return this.employeeStatus;
	}
		
}


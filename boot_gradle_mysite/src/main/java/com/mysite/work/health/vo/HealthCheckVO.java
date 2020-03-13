package com.mysite.work.health.vo;

public class HealthCheckVO {

	public HealthCheckVO() {}
	public HealthCheckVO(String ip, String port, String url, String aliveYn) {
		super();
		this.ip = ip;
		this.port = port;
		this.url = url;
		this.aliveYn = aliveYn;
	}
	private String ip ;
	private String port;
	private String url;
	private String aliveYn ="N";
	private String hostName;
	private String serviceCode;
	private String message;
	private int dbCnt;
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAliveYn() {
		return aliveYn;
	}
	public void setAliveYn(String aliveYn) {
		this.aliveYn = aliveYn;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	@Override
	public String toString() {
		return "HealthCheckVO [ip=" + ip + ", port=" + port + ", url=" + url + ", aliveYn=" + aliveYn + ", hostName="
				+ hostName + ", serviceCode=" + serviceCode + ", message=" + message + ", dbCnt=" + dbCnt + "]";
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getDbCnt() {
		return dbCnt;
	}
	public void setDbCnt(int dbCnt) {
		this.dbCnt = dbCnt;
	}

}

package cn.zzdz.dto;

public class ExceptionDto {
	private Object errorType;
	private Object localized;
	private Object cause;
	private Object message;
	private Object suppressed;
	private Object errorclass;

	public Object getErrorType() {
		return errorType;
	}

	public void setErrorType(Object errorType) {
		this.errorType = errorType;
	}

	public Object getLocalized() {
		return localized;
	}

	public void setLocalized(Object localized) {
		this.localized = localized;
	}

	public Object getCause() {
		return cause;
	}

	public void setCause(Object cause) {
		this.cause = cause;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public Object getSuppressed() {
		return suppressed;
	}

	public void setSuppressed(Object suppressed) {
		this.suppressed = suppressed;
	}

	public Object getErrorclass() {
		return errorclass;
	}

	public void setErrorclass(Object errorclass) {
		this.errorclass = errorclass;
	}
}

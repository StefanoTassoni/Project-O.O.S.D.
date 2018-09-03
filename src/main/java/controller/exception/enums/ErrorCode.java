package controller.exception.enums;

public enum ErrorCode {
	
	// FRONT OFFICE
	GENERIC_ERROR("error.technical"),
	TEACHER_ALREADY_ADDED_COURSE("error.service.teacher_already_added_course"),
	TEACHER_NO_SELECTED("error.service.teacher_no_selected"),
	TEACHER_NOT_FOUND("error.service.teacher_not_found"),
	COURSE_ALREADY_EXISTS("error.service.course_already_exists"),
	COURSE_NOT_FOUND("error.service.course_not_found"),
	USER_NOT_FOUND("error.service.user_not_found"),
	RETRIEVE_DATA_FROM_DB("error.dao.retrieve_from_db"),
	
	// BACK OFFICE 
	USERNAME_ALREADY_EXISTS("alert.user_already_exists"),
	COURSECODE_ALREADY_EXISTS("alert.courseCode_already_exists")
	
	;
	
	private final String code;
	
	private ErrorCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}

}

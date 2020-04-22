package co.david.cadena.algorithms.dto;

import java.time.LocalTime;

public abstract class ResponseDTO {

	private String tId;
	private LocalTime time = LocalTime.now();

	public ResponseDTO(String tId) {
		this.tId = tId;
	}

	public String gettId() {
		return tId;
	}

	protected void settId(String tId) {
		this.tId = tId;
	}

	public LocalTime getTime() {
		return time;
	}

}

package co.david.cadena.algorithms.dto;

public class SearchRequestDTO {

	private int[] numbers;
	private int item;

	public SearchRequestDTO() {
	}

	public SearchRequestDTO(int[] numbers, int item) {
		this.numbers = numbers;
		this.item = item;
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

}

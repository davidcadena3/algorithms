package co.david.cadena.algorithms.dto;

public class BinarySearchRequestDTO {

	private int[] numbers;
	private int item;

	public BinarySearchRequestDTO() {
	}

	public BinarySearchRequestDTO(int[] numbers, int item) {
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

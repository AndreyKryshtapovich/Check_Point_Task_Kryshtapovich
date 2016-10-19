package by.epamtr.veloshop.bean;

public class DeleteProductRequest extends Request {
	private int idToDelete;

	public int getIdToDelete() {
		return idToDelete;
	}

	public void setIdToDelete(int idToDelete) {
		this.idToDelete = idToDelete;
	}
	
}

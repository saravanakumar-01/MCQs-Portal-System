package mcqs.app.entities;

public class Attendance {
	
	private int id;
	private int courseId;
	private boolean isAttended;
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Attendance(int id, int courseId, boolean isAttended) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.isAttended = isAttended;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public boolean isAttended() {
		return isAttended;
	}
	public void setAttended(boolean isAttended) {
		this.isAttended = isAttended;
	}
	@Override
	public String toString() {
		return "\n Attendance [id=" + id + ", courseId=" + courseId + ", isAttended=" + isAttended + "]";
	}
	
	

}

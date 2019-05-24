
public class Vector {
	public int x, y;
	Vector(){
		this.x = 0;
		this.y = 0;
	}
	Vector(int x, int y){
		this.x = x;
		this.y = y;
	}
	Vector plus(Vector v2){
		return new Vector(x + v2.x, y + v2.y);
	}
	Vector sub(Vector v2){
		return new Vector(x - v2.x, y - v2.y);
	}
	double dist(){
		return Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
	}
	double dist(Vector v2){
		return Math.sqrt(Math.pow(this.x-v2.x,2) + Math.pow(this.y-v2.y,2));
	}
	Vector rotate(float angle) {
		int tempX, tempY;
		tempX = (int)Math.round(x*Math.cos(angle) + y*Math.sin(angle));
		tempY = (int)Math.round(y*Math.cos(angle) + x*Math.sin(angle));
		return new Vector(tempX, tempY);
	}
}


//public class Vector<T> {
//	public T x, y;
//	Vector(){
//	}
//	Vector(T x, T y){
//		this.x = x;
//		this.y = y;
//	}
//	Vector plus(Vector v2){
//		return new Vector(x + v2.x, y + v2.y);
//	}
//	Vector sub(Vector v2){
//		return new Vector(x - v2.x, y - v2.y);
//	}
//	double dist(){
//		return Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
//	}
//}

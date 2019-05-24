package maths;

public class Vector {
	public int x, y;
	public Vector(){
		this.x = 0;
		this.y = 0;
	}
	public Vector(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Vector plus(Vector v2){
		return new Vector(x + v2.x, y + v2.y);
	}
	public Vector sub(Vector v2){
		return new Vector(x - v2.x, y - v2.y);
	}
	public Vector multiply(double m) {
		return multiply((float)m);
	}
	public Vector multiply(float m) {
		return new Vector(Math.round(x*m), Math.round(y*m));
	}
	public double dist(){
		return Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
	}
	public double dist(Vector v2){
		return Math.sqrt(Math.pow(this.x-v2.x,2) + Math.pow(this.y-v2.y,2));
	}
	public Vector rotate(float angle) {
		int tempX, tempY;
		tempX = (int)Math.round(x*Math.cos(angle) + y*Math.sin(angle));
		tempY = (int)Math.round(y*Math.cos(angle) + x*Math.sin(angle));
		return new Vector(tempX, tempY);
	}
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
	public boolean equals(Vector v2) {
		return this.x == v2.x && this.y == v2.y;
	}
	public int compareTo(Vector v2) {
		if(this.x<v2.x) {
			return -1;
		}else if(this.x>v2.x) {
			return 1;
		}else {
			if(this.y<v2.y) {
				return -1;
			}else if(this.y>v2.y) {
				return 1;
			}else {
				return 0;
			}
		}
	}
	public Vector copy() {
		return new Vector(x,y);
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

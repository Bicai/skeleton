/**
*this is a Planet class
*/

public class Planet {

	public double x;
	public double y;
	public double xVelocity;
	public double yVelocity;
	public double mass;
	public String img;
	public double xNetForce;
	public double yNetForce;
	public double xAccel;
	public double yAccel;

	public Planet (double x1, double y1, double xVelocity1,
              double yVelocity1, double mass1, String img1) {
		x = x1;
		y = y1;
		xVelocity = xVelocity1;
		yVelocity = yVelocity1;
		mass = mass1;	 				
		img =img1;
	}

	public double calcDistance(Planet p) {
		double dist;
		double dx;
		double dy;
		dx = this.x - p.x;
		dy = this.y - p.y;
		dist = Math.sqrt(dx*dx + dy*dy);
		return dist;
	}

	public double calcPairwiseForce(Planet p) {
		double g = 6.67E-11;
		double force;
		force = g * (this.mass * p.mass) / (this.calcDistance(p) * this.calcDistance(p));
		return force; 
	}

	public double calcPairwiseForceX(Planet p) {
		double force;
		double forceX;
		double dx;
		dx = -(this.x - p.x);
		force = this.calcPairwiseForce(p);
		forceX = force * dx / this.calcDistance(p);
		return forceX;
	}

	public double calcPairwiseForceY(Planet p) {
		double force;
		double forceY;
		double dy;
		dy = -(this.y - p.y);
		force = this.calcPairwiseForce(p);
		forceY = force * dy / this.calcDistance(p);
		return forceY;
	}

	public void setNetForce(Planet[] planets) {
		this.xNetForce = 0;
		this.yNetForce = 0;
		for (int i = 0; i < planets.length; i++) {
			if (planets[i].equals(this)) continue;
			this.xNetForce = this.xNetForce + this.calcPairwiseForceX(planets[i]);
			this.yNetForce = this.yNetForce + this.calcPairwiseForceY(planets[i]);
		}
	}

	public void draw() {
		StdDraw.picture(this.x, this.y, this.img);
	}

	public void update(double dt) {
		double xAccel = this.xNetForce / this.mass;
		double yAccel = this.yNetForce / this.mass;
		xVelocity = xVelocity + dt * xAccel;
		yVelocity = yVelocity + dt * yAccel;
		x = x + dt * xVelocity;
		y = y + dt * yVelocity;
		//draw();
	}

}
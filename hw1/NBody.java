public class NBody {

	public static Planet getPlanet(In in) {
		Planet p;
		
                //String[] s = in.readLine();
        double x1 = in.readDouble();
        double y1 = in.readDouble();
        double xVelocity1 = in.readDouble();
        double yVelocity1 = in.readDouble();
        double mass1 = in.readDouble();
        String img1 = in.readString();
        p = new Planet(x1, y1, xVelocity1, yVelocity1, mass1, img1);
        return p;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		In in = new In(filename);
		int N = in.readInt();
		double R = in.readDouble();
		Planet[] planets = new Planet[N];
		for (int i = 0; i < planets.length; i++) {
			planets[i] = getPlanet(in);
		}
		//StdDraw.picture(0, 0, images/starfield.jpg);
		StdDraw.setScale(-R, R);
		StdDraw.picture(0, 0, "starfield.jpg");
		for (int i = 0 ; i < planets.length; i++) {
			planets[i].draw();
		}

		for (double t = 0; t < T; t = t + dt) {

			for (int i = 0 ; i < planets.length; i++) {
				planets[i].setNetForce(planets);
				planets[i].update(dt);
			}
			StdDraw.picture(0, 0, "starfield.jpg");
			for (int i = 0 ; i < planets.length; i++) {
				planets[i].draw();
			}
			StdDraw.show(10);
		}
	}
}
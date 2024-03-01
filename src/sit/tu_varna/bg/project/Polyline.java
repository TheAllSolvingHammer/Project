package sit.tu_varna.bg.project;

public class Polyline {
    // ne sum preglejdal vuzmojnost dali moje kato masiv ot linii ili kato masiv ot krodinati;

    // moje da se nareche polygon no bez da svurzvame kraishtata mu, variant e da nasledim ot polyline - polygon
    // zashtoto polygon e zatvoren uchastuk
    private double[] arrayOfCoords;

    public Polyline(double[] arrayOfCoords) {
        this.arrayOfCoords = arrayOfCoords;
    }
}

package pl.sternik.kk.gpw;

public class Tik {
    private final String nazwa;
    private final double cena;

    public Tik(String nazwa, double cena) {
        super();
        this.nazwa = nazwa;
        this.cena = cena;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        final int przesuniecie = 32;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(cena);
        result = prime * result + (int) (temp ^ (temp >>> przesuniecie));
        result = prime * result + ((nazwa == null) ? 0 : nazwa.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Tik other = (Tik) obj;
        if (Double.doubleToLongBits(cena) != Double.doubleToLongBits(other.cena)) {
            return false;
        }
        if (nazwa == null) {
            if (other.nazwa != null) {
                return false;
            }
        } else if (!nazwa.equals(other.nazwa)) {
            return false;
        }
        return true;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }

	@Override
	public String toString() {
		return "Tik [nazwa=" + nazwa + ", cena=" + cena + "]";
	}
    
}

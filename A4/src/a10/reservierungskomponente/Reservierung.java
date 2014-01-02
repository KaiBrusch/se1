package a10.reservierungskomponente;

import java.util.List;

import a10.gastkomponente.Gast;

public class Reservierung {

	private Gast gast;
	private Integer nr;
	private Integer zimmerNr;
	private List<Zusatzleistung> zLeistungen;

	public Reservierung(Integer nr, Integer zimmerNr, Gast gast) {
		this.nr = nr;
		this.zimmerNr = zimmerNr;
		this.gast = gast;
	}

	@Override
	public String toString() {
		return "Reservierung{nr=" + nr + ", zimmerNr=" + zimmerNr + "}";
	}

	public Integer getNr() {
		return nr;
	}

	public void setNr(Integer nr) {
		this.nr = nr;
	}

	public Integer getZimmerNr() {
		return zimmerNr;
	}

	public void setZimmerNr(Integer zimmerNr) {
		this.zimmerNr = zimmerNr;
	}

	public List<Zusatzleistung> getzLeistungen() {
		return zLeistungen;
	}

	public boolean addLeistungen(Zusatzleistung leistung) {
		return this.zLeistungen.add(leistung);
	}

	@Override
	public int hashCode() {
		long longBits = Double.doubleToLongBits(Double.valueOf(this.nr));
		return (int) (longBits ^ (longBits >>> 32));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Reservierung))
			return false;
		Reservierung r = (Reservierung) obj;
		return r.getNr().compareTo(this.getNr()) == 0
				&& r.getZimmerNr().compareTo(this.getZimmerNr()) == 0;
	}

}

package persistance.entities;
// Generated 24 mars 2021 � 13:36:36 by Hibernate Tools 4.0.1.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CommandeId generated by hbm2java
 */
@Embeddable
public class CommandeId implements java.io.Serializable {

	private BigDecimal idproduit;
	private BigDecimal idclient;

	public CommandeId() {
	}

	public CommandeId(BigDecimal idproduit, BigDecimal idclient) {
		this.idproduit = idproduit;
		this.idclient = idclient;
	}

	@Column(name = "IDPRODUIT", nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdproduit() {
		return this.idproduit;
	}

	public void setIdproduit(BigDecimal idproduit) {
		this.idproduit = idproduit;
	}

	@Column(name = "IDCLIENT", nullable = false, precision = 22, scale = 0)
	public BigDecimal getIdclient() {
		return this.idclient;
	}

	public void setIdclient(BigDecimal idclient) {
		this.idclient = idclient;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CommandeId))
			return false;
		CommandeId castOther = (CommandeId) other;

		return ((this.getIdproduit() == castOther.getIdproduit()) || (this.getIdproduit() != null
				&& castOther.getIdproduit() != null && this.getIdproduit().equals(castOther.getIdproduit())))
				&& ((this.getIdclient() == castOther.getIdclient()) || (this.getIdclient() != null
						&& castOther.getIdclient() != null && this.getIdclient().equals(castOther.getIdclient())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdproduit() == null ? 0 : this.getIdproduit().hashCode());
		result = 37 * result + (getIdclient() == null ? 0 : this.getIdclient().hashCode());
		return result;
	}

}

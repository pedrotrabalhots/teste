package br.com.irrfweb.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daves
 */
@Entity
@Table(catalog = "irrf", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calculo.findAll", query = "SELECT h FROM Calculo h")
    , @NamedQuery(name = "Calculo.findById", query = "SELECT h FROM Calculo h WHERE h.id = :id")
    , @NamedQuery(name = "Calculo.findByDataCalculo", query = "SELECT h FROM Calculo h WHERE h.dataCalculo = :dataCalculo")
    , @NamedQuery(name = "Calculo.findByNome", query = "SELECT h FROM Calculo h WHERE h.nome = :nome")})
public class Calculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, unique = true, length = 50)
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCalculo;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double rendimento;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double contribuicaoOficial;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int numeroDependente;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double deducaoPensao;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double deducaoSaude;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double deducaoEducacao;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private double deducaoOutra;

    public Calculo() {
    }

    public Calculo(Integer id, String nome, Date dataCalculo, double rendimento, double contribuicaoOficial, int numeroDependente, double deducaoPensao, double deducaoSaude, double deducaoEducacao, double deducaoOutra) {
        this.id = id;
        this.nome = nome;
        this.dataCalculo = dataCalculo;
        this.rendimento = rendimento;
        this.contribuicaoOficial = contribuicaoOficial;
        this.numeroDependente = numeroDependente;
        this.deducaoPensao = deducaoPensao;
        this.deducaoSaude = deducaoSaude;
        this.deducaoEducacao = deducaoEducacao;
        this.deducaoOutra = deducaoOutra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCalculo() {
        return dataCalculo;
    }

    public void setDataCalculo(Date dataCalculo) {
        this.dataCalculo = dataCalculo;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public double getContribuicaoOficial() {
        return contribuicaoOficial;
    }

    public void setContribuicaoOficial(double contribuicaoOficial) {
        this.contribuicaoOficial = contribuicaoOficial;
    }

    public int getNumeroDependente() {
        return numeroDependente;
    }

    public void setNumeroDependente(int numeroDependente) {
        this.numeroDependente = numeroDependente;
    }

    public double getDeducaoPensao() {
        return deducaoPensao;
    }

    public void setDeducaoPensao(double deducaoPensao) {
        this.deducaoPensao = deducaoPensao;
    }

    public double getDeducaoSaude() {
        return deducaoSaude;
    }

    public void setDeducaoSaude(double deducaoSaude) {
        this.deducaoSaude = deducaoSaude;
    }

    public double getDeducaoEducacao() {
        return deducaoEducacao;
    }

    public void setDeducaoEducacao(double deducaoEducacao) {
        this.deducaoEducacao = deducaoEducacao;
    }

    public double getDeducaoOutra() {
        return deducaoOutra;
    }

    public void setDeducaoOutra(double deducaoOutra) {
        this.deducaoOutra = deducaoOutra;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.dataCalculo);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.rendimento) ^ (Double.doubleToLongBits(this.rendimento) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.contribuicaoOficial) ^ (Double.doubleToLongBits(this.contribuicaoOficial) >>> 32));
        hash = 17 * hash + this.numeroDependente;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.deducaoPensao) ^ (Double.doubleToLongBits(this.deducaoPensao) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.deducaoSaude) ^ (Double.doubleToLongBits(this.deducaoSaude) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.deducaoEducacao) ^ (Double.doubleToLongBits(this.deducaoEducacao) >>> 32));
        return hash;
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
        final Calculo other = (Calculo) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return "<tr>"
                + "<td>" + sdf.format(dataCalculo) + "</td>"
                + "<td>" + nome + "</td>"
                + "<td> R$" + df.format(rendimento) + "</td>"
                + "<td> R$" + df.format(deducoes()) + "</td>"
//                + "<td>" + df.format(baseCalculo()) + "</td>"
                + "<td> R$" + df.format(imposto()) + "</td>"
                + "<td> 8 de R$ " + df.format(imposto()/8) + "</td>"
                + "<td>" + df.format(aliquotaEfetiva()) + " %</td>"
                + "</tr>";
    }

    public double calculoDependentes() {
        return numeroDependente * (189.59 * 12);
    }

    public double deducoes() {
        return calculoDependentes() + deducaoEducacao + deducaoOutra + 
                deducaoPensao + deducaoSaude + contribuicaoOficial;
    }

    public double baseCalculo() {
        return rendimento - deducoes();
    }

    public double imposto() {
        double faixa4 = 1903.98 + 922.67 + 924.40 + 913.63;
        double faixa3 = 1903.98 + 922.67 + 924.40;
        double faixa2 = 1903.98 + 922.67;
        double faixa1 = 1903.98;
        double resultado = 0;
        double redo4, redo3, redo2, redo1;
        redo4 = redo3 = redo2 = redo1 = 0;
        if (baseCalculo() > faixa4) {
            redo4 = baseCalculo() - faixa4;
            resultado += redo4 * 0.275;
        } if (baseCalculo() > faixa3) {
            redo3 = baseCalculo() - redo4 - faixa3;
            resultado += redo3 * 0.225;
        } if (baseCalculo() > faixa2) {
            redo2 = baseCalculo() - redo4 - redo3 - faixa2;
            resultado += redo2 * 0.15;
        } if (baseCalculo() > faixa1) {
            redo1 = baseCalculo() - redo4 - redo3 - redo2 - faixa1;
            resultado += redo1 * 0.075;
        }
        return resultado;
    }

    public double aliquotaEfetiva() {
        return (100*imposto())/baseCalculo();
    }

}

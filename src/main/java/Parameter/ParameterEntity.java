package Parameter;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import javax.persistence.*;

@Entity
@Indexed
@Table(name = "Parameter", schema = "public", catalog = "test")
public class ParameterEntity {
    @Field
    private String paramName;
    private int paramId;
    @Field
    private String paramDetails;
    @Field
    private Double paramMax;
    @Field
    private Double paramMin;

    @Basic
    @Column(name = "param_name", nullable = false, length = -1)
    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    @Id
    @Column(name = "param_id", nullable = false)
    public int getParamId() {
        return paramId;
    }

    public void setParamId(int paramId) {
        this.paramId = paramId;
    }

    @Basic
    @Column(name = "param_details", nullable = false, length = -1)
    public String getParamDetails() {
        return paramDetails;
    }

    public void setParamDetails(String paramDetails) {
        this.paramDetails = paramDetails;
    }

    @Basic
    @Column(name = "param_max", nullable = true, precision = 0)
    public Double getParamMax() {
        return paramMax;
    }

    public void setParamMax(Double paramMax) {
        this.paramMax = paramMax;
    }

    @Basic
    @Column(name = "param_min", nullable = true, precision = 0)
    public Double getParamMin() {
        return paramMin;
    }

    public void setParamMin(Double paramMin) {
        this.paramMin = paramMin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParameterEntity that = (ParameterEntity) o;

        if (paramId != that.paramId) return false;
        if (paramName != null ? !paramName.equals(that.paramName) : that.paramName != null) return false;
        if (paramDetails != null ? !paramDetails.equals(that.paramDetails) : that.paramDetails != null) return false;
        if (paramMax != null ? !paramMax.equals(that.paramMax) : that.paramMax != null) return false;
        if (paramMin != null ? !paramMin.equals(that.paramMin) : that.paramMin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paramName != null ? paramName.hashCode() : 0;
        result = 31 * result + paramId;
        result = 31 * result + (paramDetails != null ? paramDetails.hashCode() : 0);
        result = 31 * result + (paramMax != null ? paramMax.hashCode() : 0);
        result = 31 * result + (paramMin != null ? paramMin.hashCode() : 0);
        return result;
    }
}

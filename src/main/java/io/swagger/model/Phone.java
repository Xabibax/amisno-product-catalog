package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

/**²
 * Phone
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-18T10:50:13.013Z")
@Document(collection="phone")
public class Phone   {
    @JsonProperty("id")
    @Id
    private Long id = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("price")
    private Float price = null;
    
    @JsonProperty("img")
    private String img = null;
    /**
     * phone status in the store
     */
    public enum StatusEnum {
        AVAILABLE("available"),

        PENDING("pending"),

        SOLD("sold");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static StatusEnum fromValue(String text) {
            for (StatusEnum b : StatusEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("status")
    private StatusEnum status = null;

    public Phone id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     **/
    @ApiModelProperty(value = "")


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Phone name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     **/
    @ApiModelProperty(example = "iPhone12", required = true, value = "")
    @NotNull


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Phone price(Float price) {
        this.price = price;
        return this;
    }

    /**
     * Get price
     * @return price
     **/
    @ApiModelProperty(example = "793.97", required = true, value = "")
    @NotNull


    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Phone img(String img) {
        this.img = img;
        return this;
    }

    /**
     * Get img
     * @return img
     **/
    @ApiModelProperty(example = "https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcQI5f1oCs5beJGKgcb2ya_zVYz4hyDDdVIrQXRxFv9LUmF1eT-UBw&usqp=CAc", required = false, value = "")


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Phone status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * phone status in the store
     * @return status
     **/
    @ApiModelProperty(example = "available", value = "phone status in the store")


    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Phone phone = (Phone) o;
        return Objects.equals(this.id, phone.id) &&
                Objects.equals(this.name, phone.name) &&
                Objects.equals(this.status, phone.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Phone {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}


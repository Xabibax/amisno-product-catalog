package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Body
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-02-16T11:09:14.251Z[GMT]")


public class Body   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("price")
  private Float price = null;

  @JsonProperty("img")
  private String img = null;

  public Body name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Updated name of the phone
   * @return name
   **/
  @Schema(description = "Updated name of the phone")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Body status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Updated name of the phone
   * @return status
   **/
  @Schema(description = "Updated name of the phone")
  
    public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Body price(Float price) {
    this.price = price;
    return this;
  }

  /**
   * Updated status of the phone
   * @return price
   **/
  @Schema(description = "Updated status of the phone")
  
    public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public Body img(String img) {
    this.img = img;
    return this;
  }

  /**
   * Updated status of the phone
   * @return img
   **/
  @Schema(description = "Updated status of the phone")
  
    public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body body = (Body) o;
    return Objects.equals(this.name, body.name) &&
        Objects.equals(this.status, body.status) &&
        Objects.equals(this.price, body.price) &&
        Objects.equals(this.img, body.img);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, status, price, img);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    img: ").append(toIndentedString(img)).append("\n");
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

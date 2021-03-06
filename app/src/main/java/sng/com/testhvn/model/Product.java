package sng.com.testhvn.model;

/**
 * Created by son.nguyen on 3/19/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("availabilityStatus")
    @Expose
    private String availabilityStatus;
    @SerializedName("brandID")
    @Expose
    private BrandID brandID;
    @SerializedName("colour")
    @Expose
    private String colour;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("dateCreated")
    @Expose
    private DateCreated dateCreated;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("objectId")
    @Expose
    private String objectId;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("productName")
    @Expose
    private String productName;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("comment")
    @Expose
    private String comment;
    @SerializedName("productID")
    @Expose
    private ProductID productID;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("userID")
    @Expose
    private UserID userID;

    /**
     *
     * @return
     * The availabilityStatus
     */
    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    /**
     *
     * @param availabilityStatus
     * The availabilityStatus
     */
    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    /**
     *
     * @return
     * The brandID
     */
    public BrandID getBrandID() {
        return brandID;
    }

    /**
     *
     * @param brandID
     * The brandID
     */
    public void setBrandID(BrandID brandID) {
        this.brandID = brandID;
    }

    /**
     *
     * @return
     * The colour
     */
    public String getColour() {
        return colour;
    }

    /**
     *
     * @param colour
     * The colour
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The createdAt
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The dateCreated
     */
    public DateCreated getDateCreated() {
        return dateCreated;
    }

    /**
     *
     * @param dateCreated
     * The dateCreated
     */
    public void setDateCreated(DateCreated dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The objectId
     */
    public String getObjectId() {
        return objectId;
    }

    /**
     *
     * @param objectId
     * The objectId
     */
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    /**
     *
     * @return
     * The price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     *
     * @param price
     * The price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     *
     * @return
     * The productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     *
     * @param productName
     * The productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     *
     * @return
     * The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updatedAt
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     * The comment
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     * The comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return
     * The productID
     */
    public ProductID getProductID() {
        return productID;
    }

    /**
     *
     * @param productID
     * The productID
     */
    public void setProductID(ProductID productID) {
        this.productID = productID;
    }

    /**
     *
     * @return
     * The rating
     */
    public Integer getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     * The rating
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     * The userID
     */
    public UserID getUserID() {
        return userID;
    }

    /**
     *
     * @param userID
     * The userID
     */
    public void setUserID(UserID userID) {
        this.userID = userID;
    }

}
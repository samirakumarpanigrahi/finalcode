package com.mindtree.ShoppingCart.entity;


import javax.persistence.*;

@Entity
@Inheritance(
        strategy = InheritanceType.SINGLE_TABLE
)
@DiscriminatorColumn(name="product_type")
@NamedNativeQueries({
        @NamedNativeQuery(name = "product.findByProductName", query = "select p from Product p where p.productName=?"),
        @NamedNativeQuery(name = "product.findByProductType", query = "select p from Product p where p.product_type=?"), })
public class ProductEntity implements  Comparable<ProductEntity>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    private String productName;

    @Column(columnDefinition = "float default 0.0")
    private float productPrice;


    @Column(columnDefinition = "int default 0")
    private int productQuantity;


    @ManyToOne(cascade = CascadeType.ALL)
    private CartEntity cart;


    public ProductEntity(int productId, String productName, float productPrice, int productQuantity, CartEntity cart) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.cart = cart;
    }

    public ProductEntity() {

    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

    @Override
    public int compareTo(ProductEntity product) {
        if(productQuantity==product.getProductQuantity())
        {
            return 0;
        }
        else if(productQuantity>product.productQuantity)
        {
            return 1;
        }
        else
            return -1;

    }
}

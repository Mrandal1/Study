package study.dom4j;

import java.math.BigDecimal;

/**
 * @author Randal1
 * @version V1.0
 * @Package study.dom4j
 * @data 2020/5/27 21:02
 */
public class Book {
    private String name;
    private String sn;
    private BigDecimal price;
    private String author;

    public Book() {
    }

    public Book(String name, String sn, BigDecimal price, String author) {
        this.name = name;
        this.sn = sn;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", sn='" + sn + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}

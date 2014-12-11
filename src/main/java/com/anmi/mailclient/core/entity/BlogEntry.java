package com.anmi.mailclient.core.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="blog_entries")
public class BlogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", nullable = false,
           foreignKey = @ForeignKey(name = "fk_blog_entries_account_accounts__id"))
    private Account author;

    @Column
    private java.lang.String body;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

/*    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }*/

    public java.lang.String getBody() {
        return body;
    }

    public void setBody(java.lang.String body) {
        this.body = body;
    }
}

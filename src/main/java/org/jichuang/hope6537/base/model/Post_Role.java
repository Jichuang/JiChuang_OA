package org.jichuang.hope6537.base.model;

import javax.persistence.*;

@Entity
@Table(name = "Post_Role")
public class Post_Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 50)
    private Integer id;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Post.class)
    @JoinColumn(name = "postId")
    private Post postId;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Role.class)
    @JoinColumn(name = "roleId")
    private Role roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }
}

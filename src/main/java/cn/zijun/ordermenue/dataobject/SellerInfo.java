package cn.zijun.ordermenue.dataobject;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Title SellerInfo
 * @Description
 * @Author Zijun_Wei
 * @Date 2020/2/23
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class SellerInfo {
    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;

    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;
}
